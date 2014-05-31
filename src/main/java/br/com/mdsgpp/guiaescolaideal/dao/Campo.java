package br.com.mdsgpp.guiaescolaideal.dao;

public class Campo 
	{
    		
    	private final String nome;
    	private final String valor;
    	private final String tabela;
    	
    public Campo(String nome, String valor, String tabela) 
    {
	this.nome = nome;
	this.valor = valor;
	this.tabela = tabela;
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

    public String getTabela() {
        return tabela;
    }
    
    

}
