import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class userArtefact extends Frame implements ActionListener{
    private Panel ID;
    private Panel name;
    private Panel country;
    private Panel owner;
    private Label IDLabel;
    private Label nameLabel;
    private Label countryLabel;
    private Label ownerLabel;
    private TextField IDText;
    private TextField nameText;
    private TextField countryText;
    private Choice ownerChoice;
    private Button allDone;
    private int IDValue;
    private String nameValue;
    private String countryValue;
    private Stakeholder ownerValue;
    private String done = "no";
    private ArrayList<Stakeholder> stakeholdersA;
    public userArtefact(ArrayList<Stakeholder> stakeholders){
        stakeholdersA = stakeholders;
        setLayout(new FlowLayout());
        ID = new Panel();
        add(ID);
        name = new Panel();
        add(name);
        country = new Panel();
        add(country);
        owner = new Panel();
        add(owner);
        IDLabel = new Label("Enter 4 digit ID that does not start with 0:");
        ID.add(IDLabel);
        nameLabel = new Label("Enter Artefact's name");
        name.add(nameLabel);
        countryLabel = new Label("Enter Artefact's home country:");
        country.add(countryLabel);
        ownerLabel = new Label("Choose Owner:");
        owner.add(ownerLabel);
        IDText = new TextField(10);
        IDText.setEditable(true);
        ID.add(IDText);
        nameText = new TextField(10);
        nameText.setEditable(true);
        name.add(nameText);
        countryText = new TextField(10);
        countryText.setEditable(true);
        country.add(countryText);
        ownerChoice = new Choice();
        ownerChoice.add("*Choose Stakeholder*");
        for (int i = 0; i < stakeholders.size(); i++){
            ownerChoice.add(stakeholders.get(i).getName() + " - " + Integer.toString(i));
        }
        owner.add(ownerChoice);
        allDone = new Button("Submit");
        add(allDone);
        allDone.addActionListener(this);
        setVisible(true);
        setSize(500,800);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        boolean correctly = true;
        try{
            IDValue = Integer.parseInt(IDText.getText());
        } catch (NumberFormatException e){
            System.out.println("Invalid ID, try again");
            correctly = false;
        }
        nameValue = nameText.getText();
        countryValue = countryText.getText();
        try{
            ownerValue = stakeholdersA.get(Integer.parseInt(ownerChoice.getSelectedItem().substring(ownerChoice.getSelectedItem().length()-2)));
        } catch (NumberFormatException n) {
            ownerValue = stakeholdersA.get(Integer.parseInt(ownerChoice.getSelectedItem().substring(ownerChoice.getSelectedItem().length()-1)));
        }
        if(correctly){
            dispose();
            done = "yes";
        }
    }
    public String getDone(){
        return done;
    }
    public int getIDValue(){
        return IDValue;
    }
    public Stakeholder getOwnerValue(){
        return ownerValue;
    }
    public String getNameValue(){
        return nameValue;
    }
    public String getCountryValue(){
        return countryValue;
    }
}
