package Model.Metier;
import java.util.ArrayList;

import Dao.DaoUser;
import Model.Entities.User;

public class ModelUser {
	
	DaoUser daouser=new DaoUser();
	
	public ArrayList<User> getUsers() {
		return daouser.getAllUsers();
	}
	
	public void updateUser(User u){
		daouser.updateUser(u);
	}
	
	public boolean authentification(String email,String password) {
		
		User u=daouser.getUserByEmailAndPassword(email, password);
		
		return u!=null;
	}
	
	public void insertUser(User u) {
		daouser.insertUser(u);
	}
	
	public boolean deleteUser(int id) {
		return daouser.deleteUser(id)==true;
	}

}
