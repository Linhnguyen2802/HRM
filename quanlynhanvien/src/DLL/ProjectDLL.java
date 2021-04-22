package DLL;
import DAL.ProjectDAL;
import Entily.Project;
import java.util.ArrayList;
//chức vụ
public class ProjectDLL {
    ProjectDAL dal = new ProjectDAL();
    public ArrayList<Project> getByID(int id){
        return dal.getByID(id);
    }
    public ArrayList<Project>getAll(){
        return dal.getAll();
    }
    public boolean AddData(Project pr){
        return dal.AddData(pr);
    }
     public boolean delete(String u){
        return dal.DeleteData(u);
    }
    public boolean update(Project pr){
        return dal.Update(pr);
    }
}
