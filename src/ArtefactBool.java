import java.awt.*;
import java.awt.event.ItemEvent;

public class ArtefactBool extends Frame{
    private Panel boolArt;
    private Label newArt;
    private Choice yesNo;
    private boolean creation = false;
    String choice;
    public ArtefactBool() {
        setLayout(new FlowLayout());
        boolArt = new Panel();
        add(boolArt);
        newArt = new Label("Do you want to create a new Artefact?");
        add(newArt);
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

