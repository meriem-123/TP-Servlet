package com.meriem.Models;

import java.sql.Date;

public class Commande {
	
	private int NumCommande;
	private int CodeClient;
	private Date DateCommande;
	
	public int getNumCommande() {
		return NumCommande;
	}
	public void setNumCommande(int numCommande) {
		NumCommande = numCommande;
	}
	public int getCodeClient() {
		return CodeClient;
	}
	public void setCodeClient(int codeClient) {
		CodeClient = codeClient;
	}
	public Date getDateCommande() {
		return DateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		DateCommande = dateCommande;
	}

	
}
