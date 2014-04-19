package model;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.mdsgpp.guiaescolaideal.exceptions.TamanhoDeStringErradoException;
import br.com.mdsgpp.guiaescolaideal.model.Escola;

public class TesteEscola {

    @Test
    public void testGetNome() throws TamanhoDeStringErradoException {
	Escola escola = new Escola();
	String nome = "Nome da escola";

	escola.setNome(nome);

	assertTrue(escola.getNome().equals(nome));
    }

    @Test(expected = TamanhoDeStringErradoException.class)
    public void testGetNomeException() throws TamanhoDeStringErradoException {
	Escola escola = new Escola();
	String nome = "fail";

	escola.setNome(nome);

	assertTrue(escola.getNome().equals(nome));
    }

}
