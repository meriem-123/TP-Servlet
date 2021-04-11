package com.meriem.Models;

public class Article {

	private int CodeArticle;
	private String Titre;
	private int Prix;
	private int Stock;
	private String Categorie;
	private String Photo;
	
	public int getCodeArticle() {
		return CodeArticle;
	}
	public void setCodeArticle(int codeArticle) {
		CodeArticle = codeArticle;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String designation) {
		Titre = designation;
	}
	public int getPrix() {
		return Prix;
	}
	public void setPrix(int prix) {
		Prix = prix;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String categorie) {
		Categorie = categorie;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String bs) {
		Photo = bs;
	}
	
}
