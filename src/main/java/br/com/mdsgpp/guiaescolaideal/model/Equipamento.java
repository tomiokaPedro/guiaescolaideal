package br.com.mdsgpp.guiaescolaideal.model;

public enum Equipamento 
{
    DVD,IMPRESSORA,APARELHO_SOM, PROJETOR_MULTIMEDIA, FAX, 
    MAQUINA_FOTOGRAFICA_OU_FILMADORA,PARABOLICA, FILMADORA, COPIADORA;
    
    private int valorCampo;
    private Escola escola;

    public int getValorCampo() {
        return valorCampo;
    }

    public void setValorCampo(int valorCampo) {
        this.valorCampo = valorCampo;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
    
    
}
