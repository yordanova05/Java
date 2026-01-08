package Server2;

import java.io.Serializable;

public class Place implements Serializable {
    private int id;
    private int number;
    private String name;
    private boolean free;

    public Place(int id, int number){
        this.id = id;
        this.number = number;
        this.name = null;
        this.free = true;
    }

    public int getId(){
        return id;
    }
    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
    public boolean getFree(){
        return free;
    }

    public void takeFree(String clientName){
        this.free = false;
        this.name = clientName;
    }
    public void reFree(){
        this.free = true;
        this.name = null;
    }

    @Override
    public String toString(){
        if (free){
            return "id: " + id + " number: " + number +" FREE";
        }
        else{
            return "id: " + id + " number: " + number + " name: " + name;
        }
    }
}
