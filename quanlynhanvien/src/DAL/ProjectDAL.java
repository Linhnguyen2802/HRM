package DAL;
import Entily.Deperment;
import Entily.Project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//Chức vụ
public class ProjectDAL extends DataAccessHelper{
    private final String GET_BY_ID = "select * from Project where prID=?";
    private final String GET_ALL = "select * from Project";
    private final String ADD_DATA = "insert into Project values(?)";
    private final String UPDATE_DATA = "UPDATE Project SET PrName = ? where prID = ?";
    private final String REMOVE_DATA = "delete from Project where prID=?";

    public ArrayList<Project> getByID(int id){
        ArrayList<Project> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next()){
                Project item = new Project();
                item.setprID(rs.getInt("prID"));
                item.setPrName(rs.getString("prName"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    //láy ds
  public ArrayList<Project> getAll(){
        ArrayList<Project> objs = new ArrayList<>();
        try {
            getConnect();
           PreparedStatement ps = con.prepareStatement(GET_ALL);
           ResultSet rs = ps.executeQuery();
           if(rs!=null){
               while(rs.next()){
                   Project item= new Project();
                   item.setprID(rs.getInt("prID"));
                   item.setPrName(rs.getString("PrName"));
                   objs.add(item);
               }
           }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    } 
    //thêm
    public boolean AddData(Project pr){
       boolean check= false;
        try {
            getConnect();
            PreparedStatement ps= con.prepareStatement(ADD_DATA);
            ps.setString(1, pr.getPrName());
           
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
     public boolean Update(Project pr){
       boolean check= false;
        try {
            getConnect();
            PreparedStatement ps= con.prepareStatement(UPDATE_DATA);
            ps.setString(1, pr.getPrName());
            ps.setInt(2, pr.getprID());
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
