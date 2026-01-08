package izpit;

public class Reader {
    private String name;
    private String egn;

    public Reader(){}
    public Reader(String name, String egn){
        this.name= name;
        this.egn = egn;
    }

    public String getName(){
        return name;
    }
    public String getEgn(){
        return egn;
    }
}
