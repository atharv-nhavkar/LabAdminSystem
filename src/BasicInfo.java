import java.io.Serializable;



public class BasicInfo implements Serializable{
    public String prn ;
    public String date ; 
    public String time ; 
    public String key;
    public String value ;
    public BasicInfo( String prn ,String date , String time,String key , String value){
        this.prn= prn;
        this.date = date;
        this.time = time;
        this.key = key;
        this.value = value;
    }
    
}
