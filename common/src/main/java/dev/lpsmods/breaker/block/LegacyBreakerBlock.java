package dev.lpsmods.breaker.block;


import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class LegacyBreakerBlock extends DirectionalBlock {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    public TagKey<Block> blockTag;
    public int delay;

    protected LegacyBreakerBlock(TagKey<Block> blockTag, int delay, BlockBehaviour.Properties properties) {
        super(properties);
        this.blockTag = blockTag;
        this.delay = delay;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)((BlockState)this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite())).with(POWERED, false);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }
        boolean bl = state.get(POWERED);
        if (bl != world.isReceivingRedstonePower(pos)) {
            if (bl) {
                world.scheduleBlockTick(pos, this, this.delay);
            } else {
                world.setBlockState(pos, (BlockState)state.cycle(POWERED), Block.NOTIFY_LISTENERS);
                this.destroyBlock(state, world, pos);
            }
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(POWERED).booleanValue() && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, (BlockState)state.cycle(POWERED), Block.NOTIFY_LISTENERS);
        }
    }

    public void destroyBlock(BlockState state, World world, BlockPos pos) {
        BlockPos sourcePos = pos.offset(state.get(FACING));
        BlockState sourceState = world.getBlockState(sourcePos);
        // Ignore unbreakable blocks and air
        if (sourceState.getBlock().getHardness() > -1 && !sourceState.isAir()) {
            world.breakBlock(sourcePos, true);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
