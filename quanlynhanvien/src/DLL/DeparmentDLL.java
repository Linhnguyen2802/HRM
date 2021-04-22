package DLL;
import DAL.DepartmentDAL;
import Entily.Deperment;
import java.util.ArrayList;
//phòng ban
public class DeparmentDLL {
    DepartmentDAL dal = new DepartmentDAL();
    
    public ArrayList<Deperment> getByID(int id){
        return dal.getByID(id); 
}
    public ArrayList<Deperment>getAll(){
        return  dal.getAll();
    }
    public boolean AddData(Deperment dep){
        return dal.AddData(dep);
    }
       public boolean update(Deperment dep){
        return dal.Update(dep);
    }
         public boolean delete(String u){
        return dal.DeleteData(u);
    }
       
}
