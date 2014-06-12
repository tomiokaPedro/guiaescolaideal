package br.com.mdsgpp.guiaescolaideal.model;

public class Posicao {
    private double latitude;
    private double longitude;
    
    public Posicao(double latitude, double longitude){
	this.latitude = latitude;
	this.longitude = longitude;
    }
    
    public Posicao(){
	this(5,5);
    }
    
    public double getLatitude() {
	return latitude;
    }

    public void setLatitude(double latitude) {
	this.latitude = latitude;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }
    
    public static double converterDouble(String numero){
	return Double.parseDouble(numero);
    }

}
