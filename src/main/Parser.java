package main;

import java.io.*;
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
	private String nomeArquivoEntrada;
	private String arquivoSaida;
	private int formato;
	public static final int COLUNA = 0;
	public static final int LINHA = 1;

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
		int lastIndex = path.lastIndexOf('/');
		if(lastIndex != -1) {
			this.nomeArquivoEntrada = path.substring(lastIndex+1);
		} else {
			this.nomeArquivoEntrada = path;
		}

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

	public void setFormatoSaida(int formato) {
		this.formato = formato;

	}

	public int getFormatoSaida() {
		return formato;
	}

	public void escreverArquivo() throws EscritaNaoPermitidaException {
		String caminhoCompletoSaida = this.nomeArquivoEntrada;

		int indexPonto = -1;
		for(int i = caminhoCompletoSaida.length() - 1; i >= 0; i--) {
			if(caminhoCompletoSaida.charAt(i) == '.') {
				indexPonto = i;
				break;
			}
		}

		if(indexPonto == 0) {
			caminhoCompletoSaida = "Tab" + caminhoCompletoSaida;
		} else if(indexPonto != -1) {
			caminhoCompletoSaida = caminhoCompletoSaida.substring(0,indexPonto) + "Tab" + caminhoCompletoSaida.substring(indexPonto);
		} else {
			caminhoCompletoSaida += "Tab";
		}

		caminhoCompletoSaida = caminhoArquivoSaida + caminhoCompletoSaida;
		this.arquivoSaida = caminhoCompletoSaida;

		try {
			File file = new File(caminhoCompletoSaida);
			if(!file.exists()) {
				file.createNewFile();
			}

			FileWriter filew = new FileWriter(file);
			BufferedWriter bufferw = new BufferedWriter(filew);

			if(this.formato == LINHA) {
				for(int index = 0; index < this.buffer.size(); index++) {
					if(index != 0) bufferw.newLine();
					bufferw.write(Double.toString(index+1));
					for (int i=0; i < this.buffer.elementAt(index).size(); i++) {
						bufferw.write(this.delimitador);
						bufferw.write(Double.toString(buffer.elementAt(index).elementAt(i)));
					}
				}
			} else if(this.formato == COLUNA) {
				Vector <Vector <String>> linhas = new Vector< Vector <String>>();
				int max_size=0;
				for(int i=0; i<buffer.size(); i++) {
					if(i!=0) bufferw.write(this.delimitador);
					bufferw.write(Double.toString(i+1));
					bufferw.write(Double.toString(i+1));
					if(buffer.elementAt(i).size() > max_size) max_size = buffer.elementAt(i).size();
				}
				bufferw.newLine();
				for(int j=0; j<max_size; j++) { // linha
					if(j!=0) bufferw.newLine();
					for(int i=0; i<buffer.size(); i++) {
						if(i!=0) bufferw.write(this.delimitador);
						if(buffer.elementAt(i).size() > j) {
							bufferw.write(Double.toString(buffer.elementAt(i).elementAt(j)));
						}
					}
				}

			} else {
//		    	throw new FormatoInvalidoException(this.formato);
			}

			bufferw.close();
			filew.close();
		} catch (Exception e) {
			System.out.println(e);
			throw new EscritaNaoPermitidaException(caminhoCompletoSaida);
		}
	}

	public String getArquivoSaida() {
		return arquivoSaida;
	}
}