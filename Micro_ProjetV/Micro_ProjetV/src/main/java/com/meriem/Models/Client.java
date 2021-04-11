package com.meriem.Models;

public class Client {

	private int id;
	private String Email;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private int CodePostal;
	private String Ville;
	private int Tel;
	private String MotPasse;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public int getCodePostal() {
		return CodePostal;
	}
	public void setCodePostal(int codePostal) {
		CodePostal = codePostal;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public String getMotPasse() {
		return MotPasse;
	}
	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}
}
