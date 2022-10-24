package Model;

import FileManager.FileManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpellParser {
    private static FileManager fm = new FileManager();
    public static List<String> parseSpellsForCharacter(String job){
        JSONObject jsonSpells = fm.readFile("spells.json");
        JSONArray jsonSpellList = jsonSpells.getJSONArray("spells");
        List<Object> spellList = jsonSpellList.toList();
        List<String> spellNames = new ArrayList();
        HashMap<String, String> spellMap = new HashMap<>();
        jsonSpellList.forEach(spell -> {
            JSONObject spellObject = (JSONObject) spell;
            JSONArray x = spellObject.getJSONArray("classes");
            if (spellObject.getJSONArray("classes").toList().contains(job)){
                spellNames.add(spellObject.getString("name"));
            }
        });


        return spellNames;
    }
}
