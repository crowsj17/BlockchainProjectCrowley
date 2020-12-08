import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class GUIBlock extends Frame implements ActionListener{
    private Panel transaction;
    private Label transactionLabel;
    private Choice transactionChoice;
    private Transaction transactionValue;
    private Button allDone;
    private ArrayList<Transaction> transactionsA;
    private String done = "no";
    public GUIBlock(ArrayList<Transaction> transactions){
        transactionsA = transactions;
        setLayout(new FlowLayout());
        transaction = new Panel();
        add(transaction);
        transactionLabel = new Label("Choose the Transaction to add to a block:");
        transaction.add(transactionLabel);
        transactionChoice = new Choice();
        transactionChoice.add("*Choose Transaction*");
        for(int i = 0; i < transactions.size(); i++){
            transactionChoice.add(transactions.get(i).getBuyer().getName() + " buys " + transactions.get(i).getArte().getName() + " from " + transactions.get(i).getSeller().getName() + " " + i);
        }
        transaction.add(transactionChoice);
        allDone = new Button("Submit");
        add(allDone);
        allDone.addActionListener(this);
        setVisible(true);
        setSize(500,500);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        try{
            transactionValue = transactionsA.get(Integer.parseInt(transactionChoice.getSelectedItem().substring(transactionChoice.getSelectedItem().length()-2)));
        } catch (NumberFormatException e){
            transactionValue = transactionsA.get(Integer.parseInt(transactionChoice.getSelectedItem().substring(transactionChoice.getSelectedItem().length()-1)));
        }
        dispose();
        done = "yes";
    }
    public Transaction getTransactionValue(){
        return transactionValue;
    }
    public String getDone(){
        return done;
    }
}
