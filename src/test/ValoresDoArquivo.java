package test;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import main.Parser;
import exceptions.ArquivoNaoEncontradoException;

public class ValoresDoArquivo {
    private Parser parser;

    @Before
    public void setup() {
        parser = new Parser();
    }

    @Test
    public void teste1NumeroEvolucoes() throws ArquivoNaoEncontradoException {
        parser.lerArquivo("src/assets/analysisTime.out");
        Vector<Vector<Double>> array = parser.getBuffer();
        assertEquals(21, array.size());
    }

    @Test
    public void teste2NumeroEvolucoes() throws ArquivoNaoEncontradoException {
        parser.lerArquivo("src/assets/analysisMemory.out");
        Vector<Vector<Double>> array = parser.getBuffer();
        assertEquals(21, array.size());
    }

    @Test
    public void teste3NumeroEvolucoes() throws ArquivoNaoEncontradoException {
        parser.lerArquivo("src/assets/arquivoVazio.out");
        Vector<Vector<Double>> array = parser.getBuffer();
        assertEquals(0, array.size());
    }

}
