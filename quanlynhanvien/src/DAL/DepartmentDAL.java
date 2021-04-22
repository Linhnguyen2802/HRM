package DAL;
import Entily.Deperment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//phòng ban
public class DepartmentDAL extends DataAccessHelper{
    private final String GET_BY_ID = "select * from Department where depID=?";
    private final String GET_ALL = "select * from Department";
    private final String ADD_DATA = "insert into Department(DepName) values(?)";
        private final String UPDATE_DATA = "UPDATE Department SET DepName = ? where depID = ?";
            private final String REMOVE_DATA = "delete from Department where depid=?";

         
    public ArrayList<Deperment> getByID(int id){
        ArrayList<Deperment> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next()){
                Deperment item = new Deperment();
                item.setdepID(rs.getInt("depID"));
                item.setdepName(rs.getString("depName"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    // ds phòng ban   
    public ArrayList<Deperment> getAll(){
        ArrayList<Deperment> objs = new ArrayList<>();
        try {
            getConnect();
           PreparedStatement ps = con.prepareStatement(GET_ALL);
           ResultSet rs = ps.executeQuery();
           if(rs!=null){
               while(rs.next()){
                   Deperment item= new Deperment();
                   item.setdepID(rs.getInt("DepID"));
                   item.setdepName(rs.getString("DepName"));
                   objs.add(item);
               }
           }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    // Thêm 
    public boolean AddData(Deperment dep){
       boolean check= false;
        try {
            getConnect();
            PreparedStatement ps= con.prepareStatement(ADD_DATA);
            ps.setString(1, dep.getdepName());
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
    //sửa
    public boolean Update(Deperment dep){
       boolean check= false;
        try {
            getConnect();
            PreparedStatement ps= con.prepareStatement(UPDATE_DATA);
            ps.setString(1, dep.getdepName());
            ps.setInt(2, dep.getdepID());

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
    //xóa
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
}
