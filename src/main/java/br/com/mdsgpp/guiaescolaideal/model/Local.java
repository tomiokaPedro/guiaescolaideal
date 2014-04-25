package br.com.mdsgpp.guiaescolaideal.model;

public enum Local 
{
    SALA_EMPRESA,UNIDADE_INTERNACAO, TEMPLO_OU_IGREJA, CASA_PROFESSOR, RANCHO, OUTROS, OUTRA_ESCOLA;
    private LocalFuncionamento localFuncionamento;

    public LocalFuncionamento getLocalFuncionamento() {
        return localFuncionamento;
    }

    public void setLocalFuncionamento(LocalFuncionamento localFuncionamento) {
        this.localFuncionamento = localFuncionamento;
    }
    
    
}
