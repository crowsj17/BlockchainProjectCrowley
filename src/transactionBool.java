import java.awt.*;
import java.awt.event.ItemEvent;

public class transactionBool extends Frame{
    private Panel boolTrans;
    private Label newTrans;
    private Choice yesNo;
    private boolean creation = false;
    String choice;
    public transactionBool() {
        setLayout(new FlowLayout());
        boolTrans = new Panel();
        add(boolTrans);
        newTrans = new Label("Do you want to create a new Transaction?");
        add(newTrans);
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
