import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userStakeholder extends Frame implements ActionListener{
    private Panel ID;
    private Panel name;
    private Panel address;
    private Panel balance;
    private Label IDLabel;
    private Label nameLabel;
    private Label addressLabel;
    private Label balanceLabel;
    private TextField IDText;
    private TextField nameText;
    private TextField addressText;
    private TextField balanceText;
    private Button allDone;
    private int IDValue;
    private String nameValue;
    private String addressValue;
    private int balanceValue;
    private String done = "no";
    public userStakeholder(){
        setLayout(new FlowLayout());
        ID = new Panel();
        add(ID);
        name = new Panel();
        add(name);
        address = new Panel();
        add(address);
        balance = new Panel();
        add(balance);
        IDLabel = new Label("Enter 4 digit ID that does not start with 0:");
        ID.add(IDLabel);
        nameLabel = new Label("Enter Stakeholder's name");
        name.add(nameLabel);
        addressLabel = new Label("Enter Stakeholder's home city:");
        address.add(addressLabel);
        balanceLabel = new Label("Enter Stakeholder's balance (integer):");
        balance.add(balanceLabel);
        IDText = new TextField(10);
        IDText.setEditable(true);
        ID.add(IDText);
        nameText = new TextField(10);
        nameText.setEditable(true);
        name.add(nameText);
        addressText = new TextField(10);
        addressText.setEditable(true);
        address.add(addressText);
        balanceText = new TextField(10);
        balanceText.setEditable(true);
        balance.add(balanceText);
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
        addressValue = addressText.getText();
        try{
            balanceValue = Integer.parseInt(balanceText.getText());
        } catch (NumberFormatException m){
            System.out.println("Invalid Balance, try again");
            correctly = false;
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
    public int getBalanceValue(){
        return balanceValue;
    }
    public String getNameValue(){
        return nameValue;
    }
    public String getAddressValue(){
        return addressValue;
    }
}
