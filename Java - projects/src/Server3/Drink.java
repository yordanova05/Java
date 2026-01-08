package Server3;

public class Drink {
    private int id;
    private String name;
    private String type;
    private int quantity;

    public Drink(int id, String name, String type, int quantity){
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public int getQuantity(){
        return quantity;
    }
    public String outOfQuantity(){
        return "ID:"+id+" Name: "+name+" Type: "+type+" NO QUANTITY! ";
    }
    public void setQuantity(int quantity){
        this.quantity +=quantity;
    }

    @Override
    public String toString(){
        return "ID:"+id+" Name: "+name+" Type: "+type+" Quantity: "+quantity;
    }
}
