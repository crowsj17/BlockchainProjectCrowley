import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class testProgram extends Frame {
    private Panel boolStke;
    private Label newStake;
    private Choice yesNo;
    private boolean creation = false;
    String choice;
    public testProgram() {
        setLayout(new FlowLayout());
        boolStke = new Panel();
        add(boolStke);
        newStake = new Label("Do you want to create a new Stakeholder?");
        add(newStake);
        yesNo = new Choice();
        yesNo.add("*choose one*");
        yesNo.add("yes");
        yesNo.add("no");
        add(yesNo);
        yesNo.addItemListener(this::itemStateChanged);
        setVisible(true);
        setSize(500,200);
        //if(choice.equals("yes")){
        //    creation = true;
        //}
    }
    public boolean getCreation(){
        return creation;
    }
    public String getChoice(){
        return choice;
    }
    public void itemStateChanged(ItemEvent e) {
        choice = yesNo.getSelectedItem();
        dispose();
        creation = true;
    }
}
