package Model;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Race {
    private String name;
    private String description;
    private int speed;
    private List<Feature> traits;
    private Map proficiencies;
    private Race subRace;


    public Race(RaceParser raceParsed) {
        this.name = raceParsed.getName();
        this.description = raceParsed.getDescription();
        this.speed = raceParsed.getSpeed();
        this.traits = raceParsed.getTraits();
        this.proficiencies = raceParsed.getProficiencies();
    }

    public Race(String racename) throws IOException, ClassNotFoundException {
        RaceParser raceParser = new RaceParser(racename);
        this.name = raceParser.getName();
        this.description = raceParser.getDescription();
        this.speed = raceParser.getSpeed();
        this.traits = raceParser.getTraits();
        this.proficiencies = raceParser.getProficiencies();
    }

    public Race(String superRaceName,String subraceName) throws IOException, ClassNotFoundException {
        RaceParser raceParser = new RaceParser(superRaceName,subraceName);
        this.name = raceParser.getName();
        this.description = raceParser.getDescription();
        this.speed = raceParser.getSpeed();
        this.traits = raceParser.getTraits();
        this.proficiencies = raceParser.getProficiencies();
    }



    public void setupSubrace(Race subRace) {
        setSubRace(subRace);
    }

    //--------------------------------- GETTERS AND SETTERS -------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Race getSubRace() {
        return this.subRace;
    }

    public static List<Race> getAllSubraces(String raceName) throws IOException, ClassNotFoundException {
        List<Race> subraces = new ArrayList<>();
        RaceParser.getAllSubraces(raceName).forEach(subrace -> {
            try {
                subraces.add(new Race(subrace.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        return subraces;
    }


    public void setSubRace(Race subrace){ // Use this when a subrace has been selected by the user from getAllSubraces()
        this.subRace = subrace;
        setSpeed(subrace.getSpeed());
    }

    public List<Feature> getTraits() {
        return traits;
    }

    public void setTraits(List<Feature> traits) {
        this.traits = traits;
    }

    public Map getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(Map<String, String> proficiencies) {this.proficiencies = proficiencies;}

    public static List<String> getAllRaces(){
        List<String> racenames = null;
        try {
            racenames = RaceParser.getAllRaces();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return racenames;
    }







}
