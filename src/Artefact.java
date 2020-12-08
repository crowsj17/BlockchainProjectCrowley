import java.util.ArrayList;
public class Artefact {
    private int ID;
    private String name;
    private String country;
    private Stakeholder owner;
    private ArrayList<Transaction> Provenance = new ArrayList<Transaction>();
    public Artefact(){
        this.ID = 9999;
        this.name = "blank_artefact";
        this.country = "blank_country";
        Stakeholder blankStakeholder = new Stakeholder();
        this.owner = blankStakeholder;
    }
    public Artefact(int a, String b, String c, Stakeholder d){
        this.ID = a;
        this.name = b;
        this.country = c;
        this.owner = d;
    }
    public void setID(int a){
        this.ID = a;
    }
    public void setName(String a){
        this.name = a;
    }
    public void setCountry(String a){
        this.country = a;
    }
    public void setOwner(Stakeholder a){
        this.owner = a;
    }
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    public Stakeholder getOwner(){
        return owner;
    }
    public String toString(){
        String string;
        string = Integer.toString(ID) + " " + name + " " + country + " " + owner.toString();
        return string;
    }
    public void addTransaction(Transaction t){
        Provenance.add(t);
    }
    public ArrayList<Transaction> getProvenance(){
        return this.Provenance;
    }
}
