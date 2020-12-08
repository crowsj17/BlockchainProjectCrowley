import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Block {
    String previousHash;
    Transaction data;
    LocalDateTime timestamp;
    int nonce;
    String currentHash;
    public Block(){
        this.previousHash = null;
        this.data = new Transaction();
        this.timestamp = LocalDateTime.now();
        this.nonce = 0;
        this.currentHash = null;
    }
    public Block(String a, Transaction b, LocalDateTime c){
        this.previousHash = a;
        this.data = b;
        this.timestamp = c;
        this.nonce = 0;
        this.currentHash = null;
    }
    public Block(String a, Transaction b, LocalDateTime c, int d){
        this.previousHash = a;
        this.data = b;
        this.timestamp = c;
        this.nonce = d;
        this.currentHash = null;
    }
    public Block(String a, Transaction b, LocalDateTime c, int d, String e){
        this.previousHash = a;
        this.data = b;
        this.timestamp = c;
        this.nonce = d;
        this.currentHash = e;
    }
    public void setPreviousHash(String a){
        this.previousHash = a;
    }
    public void setData(Transaction a){
        this.data = a;
    }
    public void setTimestamp(LocalDateTime a){
        this.timestamp = a;
    }
    public void setNonce(int a){
        this.nonce = a;
    }
    public void setCurrentHash(String a){
        this.currentHash = a;
    }
    public String getPreviousHash(){
        return previousHash;
    }
    public Transaction getData(){
        return data;
    }
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
    public int getNonce(){
        return nonce;
    }
    public String getCurrentHash(){
        return currentHash;
    }
    public String calculateBlockHash() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestampString = this.timestamp.format(formatter);
        String dataToHash = previousHash
                + timestampString
                + Integer.toString(nonce)
                + data.toStringForHash();
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(UTF_8));
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("The encoding is not supported");
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }
    public void mineStarterBlock(int prefix){
        Random rand = new Random();
        this.nonce = rand.nextInt();
        String prefixString = "";
        for(int i = 0; i < prefix; i++){
            prefixString = prefixString + "0";
        }
        while(!calculateBlockHash().substring(0, prefix).equals(prefixString)){
            this.nonce = this.nonce + 1;
        }
        this.data.setSeller(this.data.arte.getOwner());
        this.currentHash = calculateBlockHash();
        this.data.auctionHouse.setBalance(this.data.auctionHouse.getBalance() + (this.data.getPrice() / 10));
        this.data.seller.setBalance(this.data.seller.getBalance() + (7 * (this.data.getPrice() / 10)));
        this.data.buyer.setBalance(this.data.buyer.getBalance() - this.data.getPrice());
        this.data.arte.addTransaction(this.data);
        this.data.arte.setOwner(this.data.getBuyer());
    }
    public void mineUserBlock(int prefix){
        Random rand = new Random();
        if (userTreatySC(this.data)){
            this.nonce = rand.nextInt(1000);
            String prefixString = "";
            for(int i = 0; i < prefix; i++){
                prefixString = prefixString + "0";
            }
            while(!calculateBlockHash().substring(0, prefix).equals(prefixString)){
                this.nonce = this.nonce + 1;
            }
            this.currentHash = calculateBlockHash();
        }else{
            System.out.println("Invalid Block");
        }
    }
    public boolean userTreatySC(Transaction t) {
        LocalDateTime first_guy = LocalDateTime.of(2001, 01, 01, 00, 00);
        if (retrieveProvenance(first_guy).size() < 2) {
            System.out.println("Artefact has Provenance Issues");
            return false;
        }
        if (t.buyer.getBalance() < t.getPrice()) {
            System.out.println("Buyer does not have the funds");
            return false;
        }
        t.auctionHouse.setBalance(t.auctionHouse.getBalance() + (t.getPrice() / 10));
        t.seller.setBalance(t.seller.getBalance() + (7 * t.getPrice() / 10));
        t.buyer.setBalance(t.buyer.getBalance() - t.getPrice());
        t.arte.addTransaction(t);
        t.arte.setOwner(t.getBuyer());
        return true;
    }
    public ArrayList<Transaction> retrieveProvenance(){
        return this.data.arte.getProvenance();
    }
    public ArrayList<Transaction> retrieveProvenance(LocalDateTime t){
        ArrayList<Transaction> prov = this.data.arte.getProvenance();
        ArrayList<Transaction> provTime = new ArrayList<Transaction>();
        for(int i = 0; i < prov.size(); i++){
            if(prov.get(i).getTime().isAfter(t)){
                provTime.add(prov.get(i));
            }
        }
        return provTime;
    }
}
