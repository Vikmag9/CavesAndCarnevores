import Stats.Stats;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import Stats.StatGenerator;

public class WizardController implements Initializable{

    //General
    @FXML private AnchorPane basicsPane;
    @FXML private AnchorPane inventoryPane;
    @FXML private AnchorPane jobSpecificPane;
    @FXML private AnchorPane lorePane;
    @FXML private AnchorPane satsAndSkillsPane;
    @FXML private AnchorPane weaponsAndArmourPane;

    @FXML private StackPane stackPane;


    Stats stats = new Stats();
    CharacterDataClass dataClass = new CharacterDataClass();

    //Basics AnchorPane
    @FXML private TextField ameTextField;
    @FXML private ComboBox<String> raceComboBox;
    @FXML private ComboBox<String> jobComboBox;
    @FXML private ComboBox<String> backgroundComboBox;

    //StatsAndSkill AnchorPane
    //Dex
    @FXML private CheckBox AcrobaticsCheckBox;
    @FXML private CheckBox SleightOfHandCheckBox;
    @FXML private CheckBox StealthCheckBox;

    //Wis
    @FXML private CheckBox AnimalHandlingCheckBox;
    @FXML private CheckBox InsightCheckBox;
    @FXML private CheckBox MedicineCheckBox;
    @FXML private CheckBox PerceptionCheckBox;
    @FXML private CheckBox SurvivalCheckBox;

    //Int
    @FXML private CheckBox ArcanaCheckBox;
    @FXML private CheckBox HistoryCheckBox;
    @FXML private CheckBox InvestigationCheckBox;
    @FXML private CheckBox NatureCheckBox;
    @FXML private CheckBox ReligionCheckBox;

    //Str
    @FXML private CheckBox AthleticsCheckBox;
    @FXML private CheckBox IntimidationCheckBox;

    //Cha
    @FXML private CheckBox DeceptionCheckBox;
    @FXML private CheckBox PerformanceCheckBox;
    @FXML private CheckBox PersuasionCheckBox;

    //Stats
    @FXML private TextField StrengthTextField;
    @FXML private TextField DexterityTextField;
    @FXML private TextField ConstitutionTextField;
    @FXML private TextField IntelligenceTextField;
    @FXML private TextField WisdomTextField;
    @FXML private TextField CharismaTextField;




    //WeaponsAndArmour AnchorPane
    @FXML private FlowPane WeaponsFlowPane;
    List<ComboBox<String>> comboBoxList = new ArrayList<>();



    //Inventory AnchorPane
    @FXML private ComboBox<String> inventoryComboBox1;
    @FXML private ComboBox<String> inventoryComboBox2;
    @FXML private ComboBox<String> inventoryComboBox3;
    @FXML private TextField inventoryTextField1;
    @FXML private TextField inventoryTextField2;
    @FXML private TextField inventoryTextField3;


    // Lore AnchorPane
    @FXML private TextField arlyLifeTextField;
    @FXML private TextField rganisationTextField;
    @FXML private TextField oreMemoriesTextField;
    @FXML private TextField anguagesTextField;
    @FXML private Button finishButton;

    //JobSpecific AnchorPane
    @FXML private FlowPane jobSpecificFlowPane;

    //Radiobuttons on stats
    private ToggleGroup statToggleGroup;
    @FXML private RadioButton rollDropRadio;
    @FXML private RadioButton arrayRadio;
    @FXML private RadioButton nightmareRadio;

    @FXML private Label StatView1Big;
    @FXML private Label StatView2Big;
    @FXML private Label StatView3Big;
    @FXML private Label StatView4Big;
    @FXML private Label StatView5Big;
    @FXML private Label StatView6Big;
    @FXML private Label StatView1Small;
    @FXML private Label StatView2Small;
    @FXML private Label StatView3Small;
    @FXML private Label StatView4Small;
    @FXML private Label StatView5Small;
    @FXML private Label StatView6Small;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prepareComboBoxes();
        prepareRadioButtons();
        //prepareTextFields();
    }
/*
    private void prepareTextFields(){
        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            //dataClass.setName(nameTextField.getText());
            System.out.println("Bob");
        });
/*
        earlyLifeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataClass.setEarlierLife(earlyLifeTextField.getText());
        });
        coreMemoriesTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataClass.setCoreMemories(coreMemoriesTextField.getText());
        });
        organisationTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataClass.setOrganisations(organisationTextField.getText());
        });
        languagesTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            dataClass.setLanguages(languagesTextField.getText());
        });
        }
 */









    //navigation methods for the wizard within the stackpane
    @FXML private void toBasicsPane() {
        basicsPane.toFront();
    }

    @FXML private void toStatsAndSkillPane() {
        satsAndSkillsPane.toFront();
    }

    @FXML private void toJobSpecificPane() {
        jobSpecificPane.toFront();
    }

    @FXML private void toWeaponsAndArmourPane() {
        weaponsAndArmourPane.toFront();
    }

    @FXML private void toInventoryPane() {
        inventoryPane.toFront();
    }

    @FXML private void toLorePane() {
        lorePane.toFront();
    }

    protected void prepareComboBoxes(){
        List<String> jobs = new ArrayList<>();
        List<String> races = new ArrayList<>();
        jobs = Job.getAllJobs();
        races = Race.getAllRaces();
        raceComboBox.getItems().addAll(races);
        raceComboBox.getSelectionModel().selectFirst();
        raceComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            dataClass.setRaceName(raceComboBox.getValue());
        });

        jobComboBox.getItems().addAll(jobs);
        jobComboBox.getSelectionModel().selectFirst();
        jobComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            dataClass.setRaceName(jobComboBox.getValue());
        });

        //Background is not extensible yet, need to parse json file but don't have the time
        backgroundComboBox.getItems().addAll("Acolyte", "Charlatan", "Criminal", "Entertainer", "Folk Hero", "Guild Artisan", "Hermit", "Noble", "Outlander", "Sage", "Sailor", "Soldier", "Urchin");
        backgroundComboBox.getSelectionModel().selectFirst();
        backgroundComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            dataClass.setRaceName(backgroundComboBox.getValue());
        });
    }

    @FXML
    public void updateStatView(ArrayList<Integer> stats){
        StatView1Big.setText(stats.get(0).toString());
        StatView2Big.setText(stats.get(1).toString());
        StatView3Big.setText(stats.get(2).toString());
        StatView4Big.setText(stats.get(3).toString());
        StatView5Big.setText(stats.get(4).toString());
        StatView6Big.setText(stats.get(5).toString());

        updateStatViewSmall(stats);

    }

    @FXML
    private void updateStatViewSmall(ArrayList<Integer> stats){
        List<Integer> modifierList = new ArrayList<>();
        for (Integer stat : stats) {
            StatGenerator statGenerator = new StatGenerator();
            modifierList.add(statGenerator.getModifier(stat));
        }
        StatView1Small.setText(modifierList.get(0).toString());
        StatView2Small.setText(modifierList.get(1).toString());
        StatView3Small.setText(modifierList.get(2).toString());
        StatView4Small.setText(modifierList.get(3).toString());
        StatView5Small.setText(modifierList.get(4).toString());
        StatView6Small.setText(modifierList.get(5).toString());
    }

    @FXML
    private void setStrength(){
        dataClass.setStrength((Integer.parseInt(StrengthTextField.getText())));
        System.out.println("str");
    }

    @FXML
    private void setIntelligence(){
        dataClass.setIntelligence((Integer.parseInt(IntelligenceTextField.getText())));
        System.out.println("int");


    }

    @FXML
    private void setWisdom(){
        dataClass.setWisdom((Integer.parseInt(WisdomTextField.getText())));
        System.out.println("wis");

    }

    @FXML
    private void setCharisma(){
        dataClass.setCharisma((Integer.parseInt(CharismaTextField.getText())));
        System.out.println("cha");

    }

    @FXML
    private void setDexterity(){
        dataClass.setDexterity((Integer.parseInt(DexterityTextField.getText())));
        System.out.println("dex");

    }

    @FXML
    private void setConstitution(){
        dataClass.setConstitution((Integer.parseInt(ConstitutionTextField.getText())));
    }

    private void prepareRadioButtons(){
        statToggleGroup = new ToggleGroup();
        rollDropRadio.setToggleGroup(statToggleGroup);
        arrayRadio.setToggleGroup(statToggleGroup);
        nightmareRadio.setToggleGroup(statToggleGroup);
        statToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (statToggleGroup.getSelectedToggle() != null){
                RadioButton selected = (RadioButton) statToggleGroup.getSelectedToggle();
                System.out.println(selected.getText());
                stats.chooseStrategy(selected.getText());
                ArrayList<Integer> listOfStats = stats.getStats();
                updateStatView(listOfStats);

            }
        });
    }

    private List<String> checkBoxProficiencyToList(){
        //this is not very extensible, however, due to how the game Dungeons & Dragons (5e) is written, there will never be a need to add more skill proficiencies.
        List<String> listOfProficiencies = new ArrayList<>();
        if (AcrobaticsCheckBox.isSelected()){
            listOfProficiencies.add("Acrobatics");
        }
        if (SleightOfHandCheckBox.isSelected()){
            listOfProficiencies.add("Sleight of Hand");
        }
        if (StealthCheckBox.isSelected()){
            listOfProficiencies.add("Stealth");
        }
        if (AnimalHandlingCheckBox.isSelected()){
            listOfProficiencies.add("Animal Handling");
        }
        if (InsightCheckBox.isSelected()){
            listOfProficiencies.add("Insight");
        }
        if (MedicineCheckBox.isSelected()){
            listOfProficiencies.add("Medicine");
        }
        if (PerceptionCheckBox.isSelected()){
            listOfProficiencies.add("Perception");
        }
        if (SurvivalCheckBox.isSelected()){
            listOfProficiencies.add("Survival");
        }
        if (ArcanaCheckBox.isSelected()){
            listOfProficiencies.add("Arcana");
        }
        if (HistoryCheckBox.isSelected()){
            listOfProficiencies.add("History");
        }
        if (InvestigationCheckBox.isSelected()){
            listOfProficiencies.add("Investigation");
        }
        if (NatureCheckBox.isSelected()){
            listOfProficiencies.add("Nature");
        }
        if (ReligionCheckBox.isSelected()){
            listOfProficiencies.add("Religion");
        }
        if (DeceptionCheckBox.isSelected()){
            listOfProficiencies.add("Deception");
        }
        if (IntimidationCheckBox.isSelected()){
            listOfProficiencies.add("Intimidation");
        }
        if (PerformanceCheckBox.isSelected()){
            listOfProficiencies.add("Performance");
        }
        if (PersuasionCheckBox.isSelected()){
            listOfProficiencies.add("Persuasion");
        }
        if (AthleticsCheckBox.isSelected()){
            listOfProficiencies.add("Athletics");
        }
        return listOfProficiencies;
    }

    private void loadWeaponsArmourTools(Map<String, List<String>> map){

        map.forEach((key, value) -> {
            ComboBox<String> combobox = new ComboBox<>();
            combobox.setPlaceholder(new Label(key));
            combobox.getItems().addAll(value);
            comboBoxList.add(combobox);
            });


        WeaponsFlowPane.getChildren().clear();
        WeaponsFlowPane.getChildren().add(comboBoxList.get(0));
    }

    @FXML
    private void finishCreation() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        CharacterHandler.createCharacter(dataClass, 1);
    }

}





