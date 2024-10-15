# Made by: @Legopitstop
# Desc: Register this datapack and all its dependencies (1.20.2)
#
# Called By: #minecraft:load

# https://legopitstop.github.io/Update_Checker
# https://minecraft.fandom.com/wiki/Data_version#List_of_data_versions

# dependencies
# function lps:RANDOM

# pack
# data modify storage lps:datapacks dependencies append value {id: RANDOM, description: "DEP_DESC"}
# 1.19.4 3320 - 3337
# 1.19.3 3205 - 3218
# 1.19.2 3118 - 3120
# 1.19.1 3106 - 3117
# 1.19   3080 - 3105
# 1.20   3442 - 3463
# 1.20.2 3567 - 
data modify storage lps:datapacks pack set value {id: RANDOM, name: 'NAME', description:'DESC', version: "1.0.0", minDataVersion: 3569, updateChecker: '{"text": "[Update Checker]", "clickEvent": {"action": "open_url", "value": "https://example.com"}}'}

# Register the datapack
function lps:condition/register