package Model.Metier;

import java.util.ArrayList;

import Dao.DaoFilm;
import Model.Entities.Film;

public class ModelFilm {
	
	DaoFilm daofilm=new DaoFilm();
	
	public ArrayList<Film> getFilms() {
		return daofilm.getAllFilms();
	}
	
	public void updateFilm(Film f){
		daofilm.updateFilm(f);
	}
	public Film getFilm(int id) {
		return daofilm.getFilm(id);
	}
	public boolean deleteFilm(int id) {
		return daofilm.deleteFilm(id)==true;
	}
	public void insertFilm(Film f) {
		daofilm.insertFilm(f);
	}

}
