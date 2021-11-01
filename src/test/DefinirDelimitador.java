package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Parser;
import exceptions.DelimitadorInvalidoException;

public class DefinirDelimitador {
	
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testeDefinirDelimitadorDeCampo() throws DelimitadorInvalidoException {
		parser.setDelimitador(";");
		assertEquals(';', parser.getDelimitador());
	}
	
	@Test
	public void teste2DefinirDelimitadorDeCampo() throws DelimitadorInvalidoException {
		parser.setDelimitador(",");
		assertEquals(',', parser.getDelimitador());
	}
	
	@Test(expected=DelimitadorInvalidoException.class)
	public void testDelimitadorInvalidoException() throws DelimitadorInvalidoException {
		parser.setDelimitador("test");
	}
}