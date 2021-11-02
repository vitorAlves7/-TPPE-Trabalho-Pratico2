package test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import main.Parser;

import exceptions.ArquivoNaoEncontradoException;
import exceptions.DelimitadorInvalidoException;
import exceptions.EscritaNaoPermitidaException;

public class EscreverArquivoResposta {
    private Parser parser;

    @Before
    public void setup() {
        parser = new Parser();
    }

    @Test
    public void testeEscreverArquivoResposta() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, FileNotFoundException, EscritaNaoPermitidaException {
        parser.lerArquivo("src/assets/analysisTime.out");
        parser.setDelimitador(";");
        parser.setFormatoSaida(Parser.LINHA);
        parser.setCaminhoArquivoSaida("src/assets/");
        parser.escreverArquivo();

        String path = parser.getArquivoSaida();
        Scanner input = new Scanner(new FileReader(path));
        Vector <Vector <Double>> buffer = new Vector <Vector <Double>>();
        while(input.hasNextLine()) {
            String data = input.nextLine();
            String columns[] = data.split(";");

            Vector<Double> line = new Vector<Double>();
            for(int i=1; i<columns.length; i++) {
                line.add(Double.parseDouble(columns[i]));
            }
            buffer.add(line);

        }

        assertEquals(buffer, parser.getBuffer());
    }

    @Test
    public void teste2EscreverArquivoResposta() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, FileNotFoundException, EscritaNaoPermitidaException {
        parser.lerArquivo("src/assets/analysisTime.out");
        parser.setDelimitador("\t");
        parser.setFormatoSaida(Parser.COLUNA);
        parser.setCaminhoArquivoSaida("src/assets/");
        parser.escreverArquivo();

        String path = parser.getArquivoSaida();
        Scanner input = new Scanner(new FileReader(path));
        Vector <Vector <Double>> buffer = new Vector <Vector <Double>>();
        int line_number=0;
        while(input.hasNextLine()) {
            String data = input.nextLine();
            String columns[] = data.split("\t");
            if(line_number == 0) {
                for(String each:columns) {
                    buffer.add(new Vector<Double>());
                }
            }else {
                for(int i=0; i<columns.length; i++) {
                    buffer.elementAt(i).add(Double.valueOf(columns[i]));
                }
            }

            line_number++;
        }

        assertEquals(buffer, parser.getBuffer());
    }

    @Test
    public void teste3EscreverArquivoResposta() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, FileNotFoundException, EscritaNaoPermitidaException {
        parser.lerArquivo("src/assets/analysisMemory.out");
        parser.setDelimitador(",");
        parser.setFormatoSaida(Parser.LINHA);
        parser.setCaminhoArquivoSaida("src/assets/");
        parser.escreverArquivo();

        String path = parser.getArquivoSaida();
        Scanner input = new Scanner(new FileReader(path));
        Vector <Vector <Double>> buffer = new Vector <Vector <Double>>();
        while(input.hasNextLine()) {
            String data = input.nextLine();
            String columns[] = data.split(",");

            Vector<Double> line = new Vector<Double>();
            for(int i=1; i<columns.length; i++) {
                line.add(Double.parseDouble(columns[i]));
            }
            buffer.add(line);

        }

        assertEquals(buffer, parser.getBuffer());
    }

    @Test
    public void teste4EscreverArquivoResposta() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, FileNotFoundException, EscritaNaoPermitidaException {
        parser.lerArquivo("src/assets/analysisMemory.out");
        parser.setDelimitador(" ");
        parser.setFormatoSaida(Parser.COLUNA);
        parser.setCaminhoArquivoSaida("src/assets/");
        parser.escreverArquivo();

        String path = parser.getArquivoSaida();
        Scanner input = new Scanner(new FileReader(path));
        Vector <Vector <Double>> buffer = new Vector <Vector <Double>>();
        int line_number=0;
        while(input.hasNextLine()) {
            String data = input.nextLine();
            String columns[] = data.split(" ");
            if(line_number == 0) {
                for(String each:columns) {
                    buffer.add(new Vector<Double>());
                }
            }else {
                for(int i=0; i<columns.length; i++) {
                    buffer.elementAt(i).add(Double.valueOf(columns[i]));
                }
            }

            line_number++;
        }

        assertEquals(buffer, parser.getBuffer());
    }

}
