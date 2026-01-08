package Server3;

public class Order {
    private int id;
    private Drink drink;
    private int productQuantity;
    private String status;

    public Order(int number, int productQuantity){
        this.number = number;
        this.productQuantity = productQuantity;
    }

    public int getId(){
        return id;
    }

    public String getStatus(){
        return status;
    }
    public int getProductQuantity(){
        return productQuantity;
    }

    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString(){
        return "Id drink:"+id+" Product name: "+drink.getName()+" Quantity: "+productQuantity+" Status: " +status;
    }
}
