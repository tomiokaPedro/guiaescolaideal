package br.com.mdsgpp.guiaescolaideal.model;

import br.com.mdsgpp.guiaescolaideal.util.Util;

public class Posicao {
    private String latitude;
    private String longitude;
    private static final String SEM_POSICAO = "ERROR";
    
    public Posicao(String latitude, String longitude){
	this.latitude = latitude;
	this.longitude = longitude;
    }
    
    public Posicao(){
	this(SEM_POSICAO, SEM_POSICAO);
    }
    
    public String getLatitude() {
	return latitude;
    }

    public String getLongitude() {
	return longitude;
    }

    public void converter(String latitude, String longitude){
	if(Util.textoTemConteudo(latitude)){
		this.latitude = latitude.replaceAll(",", ".");
		this.longitude = longitude.replaceAll(",", ".");
	}else{
		this.latitude = SEM_POSICAO;
		this.longitude = SEM_POSICAO;
	}
    }

}
