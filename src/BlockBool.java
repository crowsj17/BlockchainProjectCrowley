import java.awt.*;
import java.awt.event.ItemEvent;
public class BlockBool extends Frame{
    private Panel blockBool;
    private Label blockLabel;
    private Choice blockChoice;
    private boolean creation = false;
    String choice;
    public BlockBool(){
        setLayout(new FlowLayout());
        blockBool = new Panel();
        add(blockBool);
        blockLabel = new Label("Do you wish to add a Block to the Blockchain?");
        add(blockLabel);
        blockChoice = new Choice();
        blockChoice.add("*Choose one*");
        blockChoice.add("yes");
        blockChoice.add("no");
        add(blockChoice);
        blockChoice.addItemListener(this::itemStateChanged);
        setVisible(true);
        setSize(500,200);

    }
    public String getChoice(){
        return choice;
    }
    public void itemStateChanged(ItemEvent e){
        choice = blockChoice.getSelectedItem();
        dispose();
        creation=true;
    }
}
