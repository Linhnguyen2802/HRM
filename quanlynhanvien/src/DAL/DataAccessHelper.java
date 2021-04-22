package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//kết nối CSDL
public class DataAccessHelper {
    //ket noi sqls
    protected Connection con;
    String HostName ="localhost";
    String port = "1433";
    String dbName= "ProjectManagement";
    String use ="sa";
    String pass="123456";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=ProjectManagement";   
    public  void getConnect(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, use, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void getClose(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    }
