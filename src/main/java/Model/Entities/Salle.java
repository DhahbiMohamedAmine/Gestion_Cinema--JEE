package Model.Entities;

	public class Salle {
		private int id_salle;
		private String nom_salle;
		private int nb_place;
		
		public String getNomSalle() {
			return nom_salle;
		}
		public int getId() {
			return id_salle;
		}
		public void setId(int id) {
			this.id_salle = id;
		}
		public void setNomSalle(String salle) {
			this.nom_salle = salle;
		}
		public int getNb_place() {
			return nb_place;
		}
		public void setNb_place(int nb_place) {
			this.nb_place = nb_place;
		}
		public Salle(String salle, int nb_place) {
			super();
			this.nom_salle = salle;
			this.nb_place = nb_place;
		}
		public Salle(int id,String salle, int nb_place) {
			super();
			this.id_salle = id;
			this.nom_salle = salle;
			this.nb_place = nb_place;
		}

}
