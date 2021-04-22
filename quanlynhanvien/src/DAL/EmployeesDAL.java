package DAL;
import Entily.Employees;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//nhân viên
public class EmployeesDAL extends DataAccessHelper{
    
    private final String GET_LOGIN = "select * from Employees where username=? and password=?";
    private final String GET_ALL = "select * from Employees";
    private final String GET_FIND = "select * from Employees where username = ?";
    private final String ADD_DATA = "insert into Employees values(?,?,?,?,?,?,?,?)";
    private final String REMOVE_DATA = "delete from Employees where username=?";
    private final String UPDATE_DATA = "UPDATE Employees SET password=?, FullName=?, age = ?, address = ?, phone = ?, depID = ?, prID = ? where username = ?";
    
    public  boolean getLoging (String u,String p){
        boolean check = false;
       try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_LOGIN);
                 ps.setString(1, u);
                 ps.setString(2, p);
                 ResultSet rs = ps.executeQuery();
                 if(rs!=null && rs.next()){
                     check = true;
                 }
            getClose();
        } catch (Exception e) {
              e.printStackTrace();
        }
       return check;
   }
    //Lấy ds nhân viên
    public ArrayList<Employees> getAll(){
      ArrayList<Employees> objs = new ArrayList<>();
       try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while (rs.next()) {                    
                    Employees item = new Employees();
                    item.setUsername(rs.getString ("username"));
                    item.setPassword(rs.getString ("Password"));
                    item.setFullName(rs.getString("FullName"));
                    item.setAge(rs.getString("Age"));
                    item.setAddress(rs.getString("Address"));
                    item.setPhone(rs.getString("Phone"));
                    item.setprID(rs.getInt("prID"));
                    item.setdepID(rs.getInt("depID"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return objs;
    }
    //Thên nhân viên
    public boolean AddData(Employees emp){
       boolean check= false;
        try {
            getConnect();
            PreparedStatement ps= con.prepareStatement(ADD_DATA);
            ps.setString(1, emp.getUsername());
            ps.setString(2, emp.getPassword());
            ps.setString(3, emp.getFullName());
            ps.setString(4, emp.getAge());
            ps.setString(5, emp.getAddress());
            ps.setString(6, emp.getPhone());
            ps.setInt(7, emp.getdepID());
            ps.setInt(8, emp.getprID());
            int rs= ps.executeUpdate();
            if(rs>0){
                check=true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
               return check;
    }
    //xóa nhan viên
    public  boolean DeleteData(String u){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps= con.prepareStatement(REMOVE_DATA);
            ps.setString(1, u);
            int rs=ps.executeUpdate();
            if(rs>0){
                check=true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    // sửa nhân viên
    public boolean Update(Employees emp){
       boolean check= false;
        try {
            getConnect();
            PreparedStatement ps= con.prepareStatement(UPDATE_DATA);
            ps.setString(1, emp.getPassword());
            ps.setString(2, emp.getFullName());
            ps.setString(3, emp.getAge());
            ps.setString(4, emp.getAddress());
            ps.setString(5, emp.getPhone());
            ps.setInt(6, emp.getdepID());
            ps.setInt(7, emp.getprID());
            ps.setString(8, emp.getUsername());

            int rs= ps.executeUpdate();
            if(rs>0){
                check=true;
            }
            
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
               return check;
    }
    
    
}

    
