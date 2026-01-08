package Server3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BarSystem {
    private static List<Order> orders = new ArrayList<>();
    private static List<Drink> drinks = new ArrayList<>();

    static {
        drinks.add(new Drink(2,"Vodka","alcohol", 1));
        drinks.add(new Drink(1,"Tequila","alcohol",2 ));
        drinks.add(new Drink(3, "Coca-Cola", "no-alcohol", 5));
    }

    public void showDrinks(PrintWriter out){
        synchronized(this){
            if(drinks!=null){
                for(Drink d: drinks){
                    if(d.getQuantity() == 0){
                        out.println(d.outOfQuantity());
                    }
                    else {
                        out.println(d.toString());
                    }
                }
            }
            else{
                out.println("Empty list!");
            }
        }
    }

    public void makeOrder(int id, int quantity, PrintWriter out){
        synchronized(this){
                for(Drink d: drinks){
                    if (id == d.getId()) {
                        if (d.getQuantity() >= quantity) {
                            d.setQuantity(d.getQuantity() - quantity);
                            orders.add(new Order(id, quantity));
                            out.println("Order made successfully!");
                        } else {
                            out.println("Not enough quantity!");
                        }
                        return;
                    }
                }
                out.println("Incorrect id!");
            }
    }

    public void showOrders(PrintWriter out){
        synchronized(this){
            for(Order o: orders){
                out.println(o.toString());
            }
        }
    }

    public void restock(PrintWriter out){
        synchronized(orders){
            boolean flag = false;
            for(Order o : orders){
                if(o.getStatus().equals("Edited")){
                    flag = true;
                    for(Drink d: drinks){
                        if(o.getId() == d.getId()){
                            d.setQuantity(o.getProductQuantity());
                            o.setStatus("Finished");
                        }
                    }
                }
            }
            if(!flag) {
                out.println("Can't restock the bar without edited orders!");
            }
        }
    }
}
