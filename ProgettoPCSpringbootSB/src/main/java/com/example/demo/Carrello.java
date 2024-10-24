package com.example.demo;

public class Carrello extends Pc {
	int qnt;

	public Carrello(String nome, String marca, String descrizione, double prezzo, String url, int qnt) {
		super(nome, marca, descrizione, prezzo, url);
		this.qnt = qnt;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	} 
	
	

}
