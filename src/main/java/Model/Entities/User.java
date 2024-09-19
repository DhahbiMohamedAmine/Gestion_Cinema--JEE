package Model.Entities;

import java.util.Objects;

public class User {	
	private int id_user;
	private String name;
	private String role; 
	 private String email;
	 private String password;
	 
	 public User(int id,String name, String role, String email, String password) {
		 	this.id_user=id;
			this.name = name;
			this.role = role;
			this.email = email;
			this.password = password;
		}
	public String getEmail() {
		return email;
	}
	public void setEmail(String username) {
		this.email = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", role=" + role + ", email=" + email + ", password=" + password + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId_user() {
		return id_user;
	}


}
