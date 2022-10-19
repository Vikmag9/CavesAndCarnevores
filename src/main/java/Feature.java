public class Feature {
    private String name;
    private String desc;
    private int levelPrerequisites;
    public Feature(String name, String desc, int prerequisites) {
        this.name = name;
        this.desc = desc;
        this.levelPrerequisites = prerequisites;
    }

    public int getLevel() {
        return this.levelPrerequisites;
    }
}