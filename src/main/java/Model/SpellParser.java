package Model;

import FileManager.FileManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellParser {
    private static FileManager fm = new FileManager();
    public static List<Map<String, String>> parseSpellsForCharacter(String job){
        JSONObject jsonSpells = fm.readFile("spells.json");
        JSONArray jsonSpellList = jsonSpells.getJSONArray("spells");
        List<Map<String, String>> spellInfo = new ArrayList<>();
        List<Object> spellList = jsonSpellList.toList();
        List<String> spellNames = new ArrayList();
        jsonSpellList.forEach(spell -> {
            JSONObject spellObject = (JSONObject) spell;
            if (spellObject.getJSONArray("classes").toList().contains(job)){
                HashMap<String, String>  spellMap = new HashMap<>();
                spellMap.put("name", spellObject.getString("name"));
                spellMap.put("description", spellObject.getString("description"));
                spellMap.put("level", spellObject.getString("level"));
                spellInfo.add(spellMap);
                spellNames.add(spellObject.getString("name"));
            }
        });


        return spellInfo;
    }


}
