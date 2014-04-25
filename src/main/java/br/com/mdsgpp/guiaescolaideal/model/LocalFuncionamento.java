package br.com.mdsgpp.guiaescolaideal.model;

public class LocalFuncionamento 
{
    private String tipoLocalFuncionamento;
    private Escola escola;

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public String getTipoLocalFuncionamento() {
        return tipoLocalFuncionamento;
    }

    public void setTipoLocalFuncionamento(String tipoLocalFuncionamento) {
        this.tipoLocalFuncionamento = tipoLocalFuncionamento;
    }
    
    
}
