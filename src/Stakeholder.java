public class Stakeholder {
    private int ID;
    private String name;
    private String address;
    private int balance;
    public Stakeholder(){
        this.ID = 9999;
        this.name = "blank_name";
        this.address = "blank_address";
        this.balance = 0;
    }
    public Stakeholder(int a, String b, String c, int d){
        this.ID = a;
        this.name = b;
        this.address = c;
        this.balance = d;
    }
    public void setID(int a){
        this.ID = a;
    }
    public void setName(String a){
        this.name = a;
    }
    public void setAddress(String a){
        this.address = a;
    }
    public void setBalance(int a){
        this.balance = a;
    }
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getBalance(){
        return balance;
    }
    public String toString(){
        String string;
        string = Integer.toString(this.ID) + " " + this.name + " " + this.address + " " + Integer.toString(this.balance);
        return string;
    }
}
