package br.com.mdsgpp.guiaescolaideal.model;

import br.com.mdsgpp.guiaescolaideal.exceptions.TamanhoDeStringErradoException;


public class Escola {
    private String nome;

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) throws TamanhoDeStringErradoException {
	if (nome.length() > 10) {
	    this.nome = nome;
	} else {
	    throw new TamanhoDeStringErradoException();
	}
    }
}
