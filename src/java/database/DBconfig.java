package database;

/**
 *
 * @author Bob
 */
public class DBconfig {
    private String urlString;
    private String driverClass;
    private String user;
    private String password;
    
    public DBconfig(String urlString, String driverClass, String user, String password){
        this.urlString = urlString;
        this.driverClass = driverClass;
        this.user = user;
        this.password = password;
    }
    public DBconfig(String urlString){
        this.urlString = urlString;
    }
    public String getUrlString(){
        return urlString;
    }
    public String getDriverClass(){
        return driverClass;
    }
    public String getUser(){
        return user;
    }
    public String getPassword(){
        return password;
    }
}
