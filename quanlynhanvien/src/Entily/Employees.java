package Entily;
//nhân viên
public class Employees {
    String username;
    String password;
    String FullName;
    String age;
    String address;
    String phone;
    int depID;
    int prID;
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getFullName(){
        return FullName;
    }
    public void setFullName(String FullName){
        this.FullName=FullName;
    }
    
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age=age;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    
    public int getdepID(){
        return depID;
    }
    public void setdepID(int depID){
        this.depID=depID;
    }
    public int getprID(){
        return prID;
    }
    public void setprID(int prID){
        this.prID=prID;
    }
    
}
