package izpit;

public class Autor {
    private String fname;
    private String lname;

    public Autor(){}
    public Autor(String fname, String lname){
        this.fname= fname;
        this.lname = lname;
    }

    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
}
