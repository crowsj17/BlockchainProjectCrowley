import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class userTransaction extends Frame implements ActionListener{
    private Panel artefact;
    //private Panel seller;
    private Panel buyer;
    private Panel auctionHouse;
    private Panel price;
    private Label artefactLabel;
    //private Label sellerLabel;
    private Label buyerLabel;
    private Label auctionHouseLabel;
    private Label priceLabel;
    private Choice artefactChoice;
    //private Choice sellerChoice;
    private Choice buyerChoice;
    private Choice auctionHouseChoice;
    private TextField priceText;
    private Button allDone;
    private Artefact artefactValue;
    //private Stakeholder sellerValue;
    private Stakeholder buyerValue;
    private Stakeholder auctionHouseValue;
    private int priceValue;
    private ArrayList<Stakeholder> stakeholdersA;
    private ArrayList<Artefact> artefactsA;
    private String done = "no";
    public userTransaction(ArrayList<Stakeholder> stakeholders, ArrayList<Artefact> artefacts){
        stakeholdersA = stakeholders;
        artefactsA = artefacts;
        setLayout(new FlowLayout());
        artefact = new Panel();
        add(artefact);
        //seller = new Panel();
        //add(seller);
        buyer = new Panel();
        add(buyer);
        auctionHouse = new Panel();
        add(auctionHouse);
        price = new Panel();
        add(price);
        artefactLabel = new Label("Which artefact is being traded?");
        artefact.add(artefactLabel);
        buyerLabel = new Label("Who is buying it?");
        buyer.add(buyerLabel);
        //sellerLabel = new Label("Who is selling it?");
        //seller.add(sellerLabel);
        auctionHouseLabel = new Label("Where is it being sold?");
        auctionHouse.add(auctionHouseLabel);
        priceLabel = new Label("How much is it being sold for? (integer)");
        price.add(priceLabel);
        artefactChoice = new Choice();
        artefactChoice.add("*Choose an Artefact*");
        for(int i = 0; i < artefacts.size(); i++){
            artefactChoice.add(artefacts.get(i).getName() + " - " + i);
        }
        artefact.add(artefactChoice);
        buyerChoice = new Choice();
        buyerChoice.add("*Choose a buyer*");
        for(int j = 0; j < stakeholders.size(); j++){
            buyerChoice.add(stakeholders.get(j).getName() + " - " + j);
        }
        buyer.add(buyerChoice);
        //sellerChoice = new Choice();
        //sellerChoice.add("*Choose a seller*");
        //for(int m = 0; m < stakeholders.size(); m++){
        //    sellerChoice.add(stakeholders.get(m).getName() + " - " + m);
        //}
        //seller.add(sellerChoice);
        auctionHouseChoice = new Choice();
        auctionHouseChoice.add("*Choose an Auction House*");
        for(int k = 0; k < stakeholders.size(); k++){
            auctionHouseChoice.add(stakeholders.get(k).getName() + " - " + k);
        }
        auctionHouse.add(auctionHouseChoice);
        priceText = new TextField();
        priceText.setEditable(true);
        priceText.setColumns(10);
        add(priceText);
        allDone = new Button("Submit");
        add(allDone);
        allDone.addActionListener(this);
        setVisible(true);
        setSize(500, 800);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        boolean correctly = true;
        try{
            artefactValue = artefactsA.get(Integer.parseInt(artefactChoice.getSelectedItem().substring(artefactChoice.getSelectedItem().length()-2)));
        } catch (NumberFormatException e){
            artefactValue = artefactsA.get(Integer.parseInt(artefactChoice.getSelectedItem().substring(artefactChoice.getSelectedItem().length()-1)));
        }
        //try{
        //    sellerValue = stakeholdersA.get(Integer.parseInt(sellerChoice.getSelectedItem().substring(sellerChoice.getSelectedItem().length() - 2)));
        //} catch (NumberFormatException f){
        //    sellerValue = stakeholdersA.get(Integer.parseInt(sellerChoice.getSelectedItem().substring(sellerChoice.getSelectedItem().length() - 1)));
        //}
        try{
            buyerValue = stakeholdersA.get(Integer.parseInt(buyerChoice.getSelectedItem().substring(buyerChoice.getSelectedItem().length() - 2)));
        } catch (NumberFormatException n){
            buyerValue = stakeholdersA.get(Integer.parseInt(buyerChoice.getSelectedItem().substring(buyerChoice.getSelectedItem().length() - 1)));
        }
        try{
            auctionHouseValue = stakeholdersA.get(Integer.parseInt(auctionHouseChoice.getSelectedItem().substring(auctionHouseChoice.getSelectedItem().length() - 2)));
        } catch (NumberFormatException w){
            auctionHouseValue = stakeholdersA.get(Integer.parseInt(auctionHouseChoice.getSelectedItem().substring(auctionHouseChoice.getSelectedItem().length() - 1)));
        }
        try{
            priceValue = Integer.parseInt(priceText.getText());
        } catch (NumberFormatException z){
            System.out.println("Invalid price format - Try again");
            correctly = false;
        }
        if(correctly){
            dispose();
            done = "yes";
        }
    }
    public Artefact getArtefactValue(){
        return artefactValue;
    }
    //public Stakeholder getSellerValue(){
    //    return sellerValue;
    //}
    public Stakeholder getBuyerValue(){
        return buyerValue;
    }
    public Stakeholder getAuctionHouseValue(){
        return auctionHouseValue;
    }
    public int getPriceValue(){
        return priceValue;
    }
    public String getDone(){
        return done;
    }
}
