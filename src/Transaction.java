import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Transaction {
    Artefact arte;
    LocalDateTime time;
    Stakeholder seller;
    Stakeholder buyer;
    Stakeholder auctionHouse;
    int price;
    public Transaction(){
        this.arte = new Artefact();
        this.time = LocalDateTime.now();
        this.seller = new Stakeholder();
        this.buyer = new Stakeholder();
        this.auctionHouse = new Stakeholder();
        this.price = 0;
    }
    public Transaction(Artefact a, LocalDateTime b, Stakeholder d, Stakeholder e, int f){
        this.arte = a;
        this.time = b;
        this.seller = a.getOwner();
        this.buyer = d;
        this.auctionHouse = e;
        this.price = f;
    }
    public void setArte(Artefact a){
        this.arte = a;
    }
    public void setTime(LocalDateTime a){
        this.time = a;
    }
    public void setSeller(Stakeholder a){
        this.seller = a;
    }
    public void setBuyer(Stakeholder a){
        this.buyer = a;
    }
    public void setAuctionHouse(Stakeholder a){
        this.auctionHouse = a;
    }
    public void setPrice(int a){
        this.price = a;
    }
    public Artefact getArte(){
        return arte;
    }
    public LocalDateTime getTime(){
        return time;
    }
    public Stakeholder getSeller(){
        return seller;
    }
    public Stakeholder getBuyer(){
        return buyer;
    }
    public Stakeholder getAuctionHouse(){
        return auctionHouse;
    }
    public int getPrice(){
        return price;
    }
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeString = this.time.format(formatter);
        String string;
        string = arte.toString() + " " + timeString + " " + seller.toString() + " " + buyer.toString() + " " + auctionHouse.toString() + " " + Integer.toString(price);
        return string;
    }
    public String toStringForHash(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeString = this.time.format(formatter);
        String string = timeString + Integer.toString(price);
        return string;
    }
}
