package br.com.mdsgpp.guiaescolaideal.model;

import java.util.List;

public class Pagina {
    private String nome;
    private String estado;
    private String municipio;
    private List<Escola> listaEscola;
    private int numResult;
    private int maxResult;
    private int numeroDePag;
    private int pagAtual;
    private int escAtual;

    public int getEscAtual() {
        return escAtual;
    }

    public void setEscAtual(int escAtual) {
        this.escAtual = escAtual;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

    public String getMunicipio() {
	return municipio;
    }

    public void setMunicipio(String municipio) {
	this.municipio = municipio;
    }

    public List<Escola> getListaEscola() {
	return listaEscola;
    }

    public void setListaEscola(List<Escola> listaEscola) {
	this.listaEscola = listaEscola;
    }

    public int getNumResult() {
	return numResult;
    }

    public void setNumResult(int numResult) {
	this.numResult = numResult;
    }

    public int getMaxResult() {
	return maxResult;
    }

    public void setMaxResult(int maxResult) {
	this.maxResult = maxResult;
    }

    public int getNumeroDePag() {
	return numeroDePag;
    }

    public void setNumeroDePag(int numeroDePag) {
	this.numeroDePag = numeroDePag;
    }

    public int getPagAtual() {
	return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
	this.pagAtual = pagAtual;
    }
}
