package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Parser;
import exceptions.EscritaNaoPermitidaException;

public class DefinirCaminhoArquivoSaida {
	
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void DefinirCaminhoArquivoSaida() throws EscritaNaoPermitidaException {
		parser.setCaminhoArquivoSaida("assets");
		assertEquals("assets/", parser.getCaminhoArquivoSaida());
	}
	
	@Test
	public void teste2DefinirCaminhoArquivoSaida() throws EscritaNaoPermitidaException {
		parser.setCaminhoArquivoSaida("assets/");
		assertEquals("assets/", parser.getCaminhoArquivoSaida());
	}
	
	@Test
	public void teste3DefinirCaminhoArquivoSaida() throws EscritaNaoPermitidaException {
		parser.setCaminhoArquivoSaida(".");
		assertEquals("./", parser.getCaminhoArquivoSaida());
	}
	
	@Test(expected=EscritaNaoPermitidaException.class)
	public void testeDefinirCaminhoArquivoSaidaExcecao() throws EscritaNaoPermitidaException {
		parser.setCaminhoArquivoSaida("/dev/");
	}

}