import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

/*
This program was written to simulate a blockchain using the methods given to us for the project.
The program will run and initialize the beginning of a blockchain, using four artefacts.
Three of the artefacts will each have three transactions, and one of them will only have one.
Then, the user can manipulate the blockchain, however, because of provenance issues, the user
needs to add transactions in one of the three valid artefacts.
 */
public class Main{
    public static void main(String[] args) {
        ArrayList<Block> blockchain = new ArrayList<>();
        int prefix = 4;   //we want our hash to start with four zeroes
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        Stakeholder John = new Stakeholder(1000, "John", "Winston-Salem", 1000);
        Stakeholder Amy = new Stakeholder(2000, "Amy", "Paris", 500);
        Stakeholder Emily = new Stakeholder(3000,"Emily","Boston",4000);
        Stakeholder Scott = new Stakeholder(4000,"Scott","Boston", 2500);
        Stakeholder Quinn = new Stakeholder(5000,"Quinn","Bali",800);
        Stakeholder Tony = new Stakeholder(6000,"Tony","Demascus",1500);
        Stakeholder Smithsonian = new Stakeholder(7000, "Smithsonian Institute","New York, New York", 100000);
        Stakeholder Louvre = new Stakeholder(8000, "Musee Louvre", "Paris, France",100000);
        Stakeholder MofS = new Stakeholder(9000, "Museum of Science", "New York, New York", 100000);
        Stakeholder Kremlin = new Stakeholder(1100, "The Kremlin", "St. Petersburg, Russia", 100000);
        Stakeholder Embassy = new Stakeholder(1200, "U.S. Embassy Prague", "Prague, Czech Republic", 0);
        Stakeholder Embassy2 = new Stakeholder(1300, "U.S. Embassy Milan", "Milan, Italy",0);
        Stakeholder Moose = new Stakeholder(1400, "Moose Crowley", "Moscow", 10000000);
        Artefact chalice = new Artefact(1000, "chalice", "Mexico", John);
        Artefact crown = new Artefact(2000, "Ancient Crown", "Russia", Amy);
        Artefact scroll = new Artefact(3000, "Wisdom Scroll", "Brazil", Quinn);
        Artefact skull = new Artefact(4000, "Animal Skull", "China", Tony);
        Artefact coin = new Artefact(5000, "Minted coin", "United States", Scott);
        Transaction og = new Transaction(coin, LocalDateTime.of(2000,01,01,10,45),Quinn, Embassy, 400);
        Transaction first = new Transaction(chalice, LocalDateTime.of(2005,03,05,10,30), Emily, Embassy, 2000);
        Transaction second = new Transaction(crown, LocalDateTime.of(2005,12,25,11,0),Scott,Embassy,1200);
        Transaction third = new Transaction(coin, LocalDateTime.of(2006,02,12,11,57),Emily, Embassy2, 500);
        Transaction fourth = new Transaction(skull, LocalDateTime.of(2007,11,13,10,30),John,Embassy,1000);
        Transaction fifth = new Transaction(chalice, LocalDateTime.of(2001,11,27,15,9),Louvre, Embassy, 2500);
        Transaction sixth = new Transaction(scroll, LocalDateTime.of(2010, 06,15,19,30),Emily, Embassy2, 100);
        Transaction seven = new Transaction(scroll, LocalDateTime.of(2011, 6,21,2,45),Scott, Embassy2, 300);
        Transaction eight = new Transaction(crown, LocalDateTime.of(2012, 12,12,4,38),Kremlin,Embassy, 2000);
        Transaction nine = new Transaction(skull, LocalDateTime.of(2015,01,15,4,35),MofS,Embassy,1800);
        Transaction ten = new Transaction(scroll, LocalDateTime.of(2019,10,31,11,11),Smithsonian,Embassy2,800);
        Block ogBlock = new Block(null, og, LocalDateTime.now());
        ogBlock.mineStarterBlock(prefix);
        blockchain.add(ogBlock);
        System.out.println("Block Added");
        Block firstBlock = new Block(ogBlock.getCurrentHash(), first, LocalDateTime.now());
        firstBlock.mineStarterBlock(prefix);
        blockchain.add(firstBlock);
        System.out.println("Block Added");
        Block secondBlock = new Block(firstBlock.getCurrentHash(), second, LocalDateTime.now());
        secondBlock.mineStarterBlock(prefix);
        blockchain.add(secondBlock);
        System.out.println("Block Added");
        Block thirdBlock = new Block(secondBlock.getCurrentHash(), third, LocalDateTime.now());
        thirdBlock.mineStarterBlock(prefix);
        blockchain.add(thirdBlock);
        System.out.println("Block Added");
        Block fourthBlock = new Block(thirdBlock.getCurrentHash(), fourth, LocalDateTime.now());
        fourthBlock.mineStarterBlock(prefix);
        blockchain.add(fourthBlock);
        System.out.println("Block Added");
        Block fifthBlock = new Block(fourthBlock.getCurrentHash(), fifth, LocalDateTime.now());
        fifthBlock.mineStarterBlock(prefix);
        blockchain.add(fifthBlock);
        System.out.println("Block Added");
        Block sixthBlock = new Block(fifthBlock.getCurrentHash(), sixth, LocalDateTime.now());
        sixthBlock.mineStarterBlock(prefix);
        blockchain.add(sixthBlock);
        System.out.println("Block Added");
        Block seventhBlock = new Block(sixthBlock.getCurrentHash(), seven, LocalDateTime.now());
        seventhBlock.mineStarterBlock(prefix);
        blockchain.add(seventhBlock);
        System.out.println("Block Added");
        Block eightBlock = new Block(seventhBlock.getCurrentHash(), eight, LocalDateTime.now());
        eightBlock.mineStarterBlock(prefix);
        blockchain.add(eightBlock);
        System.out.println("Block Added");
        Block ninthBlock = new Block(eightBlock.getCurrentHash(), nine, LocalDateTime.now());
        ninthBlock.mineStarterBlock(prefix);
        blockchain.add(ninthBlock);
        System.out.println("Block Added");
        Block tenthBlock = new Block(ninthBlock.getCurrentHash(), ten, LocalDateTime.now());
        tenthBlock.mineStarterBlock(prefix);
        blockchain.add(tenthBlock);
        System.out.println("Block Added");
        //Making my GUI interface
        ArrayList<Stakeholder> stakeholders = new ArrayList<Stakeholder>();
        stakeholders.add(John);
        stakeholders.add(Emily);
        stakeholders.add(Amy);
        stakeholders.add(Scott);
        stakeholders.add(Quinn);
        stakeholders.add(Tony);
        stakeholders.add(Smithsonian);
        stakeholders.add(Louvre);
        stakeholders.add(MofS);
        stakeholders.add(Kremlin);
        stakeholders.add(Embassy);
        stakeholders.add(Embassy2);
        stakeholders.add(Moose);
        boolean creationStake = true;
        while(creationStake) {
            testProgram c = new testProgram();
            while (c.getChoice() == null) {
                System.out.print("");
            }
            if (c.getChoice().equals("yes")) {
                userStakeholder u = new userStakeholder();
                while (u.getDone().equals("no")){
                    System.out.print("");
                }
                stakeholders.add(new Stakeholder(u.getIDValue(), u.getNameValue(), u.getAddressValue(), u.getBalanceValue()));
            } else {
                creationStake = false;
            }
        }
        ArrayList<Artefact> artefacts = new ArrayList<Artefact>();
        artefacts.add(chalice);
        artefacts.add(crown);
        artefacts.add(scroll);
        artefacts.add(coin);
        artefacts.add(skull);
        boolean creationArt = true;
        while(creationArt){
            ArtefactBool a = new ArtefactBool();
            while(a.getChoice() == null){
                System.out.print("");
            }
            if(a.getChoice().equals("yes")) {
                userArtefact p = new userArtefact(stakeholders);
                while (p.getDone().equals("no")){
                    System.out.print("");
                }
                artefacts.add(new Artefact(p.getIDValue(), p.getNameValue(), p.getCountryValue(), p.getOwnerValue()));
            } else {
                creationArt = false;
            }
        }
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(og);
        transactions.add(first);
        transactions.add(second);
        transactions.add(third);
        transactions.add(fourth);
        transactions.add(fifth);
        transactions.add(sixth);
        transactions.add(seven);
        transactions.add(eight);
        transactions.add(nine);
        transactions.add(ten);
        boolean creationTrans = true;
        while(creationTrans){
            transactionBool t = new transactionBool();
            while(t.getChoice() == null){
                System.out.print("");
            }
            if(t.getChoice().equals("yes")){
                userTransaction z = new userTransaction(stakeholders, artefacts);
                while (z.getDone().equals("no")){
                    System.out.print("");
                }
                transactions.add(new Transaction(z.getArtefactValue(),LocalDateTime.now(),z.getBuyerValue(),z.getAuctionHouseValue(),z.getPriceValue()));
            }else{
                creationTrans = false;
            }
        }
        boolean addBlock = true;
        while(addBlock){
            BlockBool b = new BlockBool();
            while(b.getChoice() == null){
                System.out.print("");
            }
            if(b.getChoice().equals("yes")){
                GUIBlock g = new GUIBlock(transactions);
                while(g.getDone().equals("no")){
                    System.out.print("");
                }
                Block q = new Block(blockchain.get(blockchain.size()-1).getCurrentHash(), g.getTransactionValue(), LocalDateTime.now());
                q.mineUserBlock(prefix);
                if(q.getCurrentHash()!=null){
                    blockchain.add(q);
                    System.out.println("Block Added");
                } else {
                    System.out.println("Block Not Added");
                }
            }else{
                addBlock = false;
            }
        }
        if(verify_Blockchain(blockchain)) {
            System.out.println("Blockchain valid and complete");
        } else{
            System.out.println("Blockchain Invalid");
        }
    }
    public static boolean verify_Blockchain(ArrayList<Block> BC){
        for (int i = 0; i < BC.size(); i++){
            //Check if the Hash is correct
            if(!BC.get(i).getCurrentHash().equals(BC.get(i).calculateBlockHash())){
                System.out.println("Hash is not correct! " + i);
                return false;
            }
            //Check if the previous Hash is correct
            try {
                if(!BC.get(i).getPreviousHash().equals(BC.get(i-1).getCurrentHash())) {
                    System.out.println("Previous Hash is not correct " + i);
                    return false;
                }
            } catch (IndexOutOfBoundsException d){
                if(BC.get(i).getPreviousHash()!=null){
                    System.out.println("Previous hash is null!" + i);
                    return false;
                }
            }
            //Check if hash has been mined (Otherwise nonce is 0)
            if(BC.get(i).getNonce() == 0){
                System.out.println("Not mined! " + i);
                return false;
            }
        }
        return true;
    }

}

