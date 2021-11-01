package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Vector;

import exceptions.ArquivoNaoEncontradoException;
import exceptions.DelimitadorInvalidoException;
import exceptions.EscritaNaoPermitidaException;

public class Parser {
	private Vector <Vector <Double>> buffer;
	private char delimitador;
	private String caminhoArquivoSaida;
	
	public Parser(){
		buffer = new Vector <Vector <Double>>();
		delimitador = ';';
		caminhoArquivoSaida = "assets/";
	}

	public void lerArquivo(String path) throws ArquivoNaoEncontradoException {
		Scanner input;
		try {
			input = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new ArquivoNaoEncontradoException(path);
		}

		while(input.hasNextLine()) {
			
			String data = input.nextLine();
			
			if (data.startsWith("-")) {
				Vector<Double> row = new Vector<Double>();
				buffer.add(row);
			}
			else {
				buffer.lastElement().add(Double.parseDouble(data));
			}
		}
		
		input.close();
		
	}

	public Vector <Vector <Double>> getBuffer() {
		return buffer;
	}

	public void setDelimitador(String delimitador) throws DelimitadorInvalidoException {
		if (delimitador.length() == 1) {
			this.delimitador = delimitador.charAt(0);
		}
		else {
			throw new DelimitadorInvalidoException(delimitador);
		}
	}
	
	public char getDelimitador() {
		return delimitador;
	}

	public void setCaminhoArquivoSaida(String caminhoArquivoSaida) throws EscritaNaoPermitidaException {
		if (!caminhoArquivoSaida.endsWith("/")) {
			caminhoArquivoSaida += "/";
		}
		
		Path caminho = Paths.get(caminhoArquivoSaida);
		
		if(!Files.isWritable(caminho)) {
			throw new EscritaNaoPermitidaException(caminhoArquivoSaida);
		}
		
		this.caminhoArquivoSaida = caminhoArquivoSaida;
	}

	public String getCaminhoArquivoSaida() {
		return caminhoArquivoSaida;
	}
	
}