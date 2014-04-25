package br.com.mdsgpp.guiaescolaideal.model;

public class LocalFuncionamento 
{
    private String tipoLocalFuncionamento;
    private Escola escola;
    private Local local;
    
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

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
