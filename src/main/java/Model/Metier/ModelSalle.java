package Model.Metier;

import java.util.ArrayList;

import Dao.DaoSalle;
import Model.Entities.Salle;

public class ModelSalle {
	
	DaoSalle daoSalle=new DaoSalle();
	
	public ArrayList<Salle> getSalles() {
		return daoSalle.getAllSalles();
	}
	
	public void updateSalle(Salle s){
		daoSalle.updateSalle(s);
	}
	public Salle getSalle(int id) {
		return daoSalle.getSalle(id);
	}
	public boolean deleteSalle(int id) {
		return daoSalle.deleteSalle(id)==true;
	}
	public void insertSalle(Salle s) {
		daoSalle.insertSalle(s);
	}

}
