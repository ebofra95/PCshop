package com.example.demo;

public class Pc {
	String nome;
	String marca;
	String descrizione;
	double prezzo;
	String url;
	public Pc(String nome, String marca, String descrizione, double prezzo, String url) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.url = url;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
