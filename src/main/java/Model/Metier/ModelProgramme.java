package Model.Metier;

import java.util.ArrayList;

import Dao.DaoProgramme;
import Model.Entities.Programme;


public class ModelProgramme {
DaoProgramme daoprogramme=new DaoProgramme();
	
	public ArrayList<Programme> getProgrammes() {
		return daoprogramme.getAllProgrammes();
	}
	
	public void updateProgramme(Programme p){
		daoprogramme.updateProgramme(p);
	}
	public Programme getProgramme(int id) {
		return daoprogramme.getProgramme(id);
	}
	public boolean deleteProgramme(int id) {
		return daoprogramme.deleteProgramme(id)==true;
	}
	public void insertProgramme(Programme p) {
		daoprogramme.insertProgramme(p);
	}

}
