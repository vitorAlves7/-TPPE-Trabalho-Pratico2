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
	public Persistencia persistencia;

	public Parser(){
		buffer = new Vector <Vector <Double>>();
		delimitador = ';';
		caminhoArquivoSaida = "assets/";
		persistencia = new Persistencia();
	}

	public void lerArquivo(String path) throws ArquivoNaoEncontradoException {
		Scanner input = abrirArquivo(path);

		persistencia.iniciaLeitura(input);
		while(persistencia.temProximaLinha()) {
			String data = persistencia.lerArquivo();

			if (data.startsWith("-")) {
				Vector<Double> row = new Vector<Double>();
				buffer.add(row);
			}
			else {
				buffer.lastElement().add(Double.parseDouble(data));
			}
		}

		persistencia.fechaLeitura();

		int lastIndex = path.lastIndexOf('/');
		if(lastIndex != -1) {
			this.setNomeArquivoEntrada(path.substring(lastIndex+1));
		} else {
			this.setNomeArquivoEntrada(path);
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
		String caminhoCompletoSaida = getNomeArquivoEntrada();

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

		caminhoCompletoSaida = getCaminhoArquivoSaida() + caminhoCompletoSaida;
		setArquivoSaida(caminhoCompletoSaida);

		new EscreverArquivo(this).escreve();
		return;
	}

	private Scanner abrirArquivo(String path) throws ArquivoNaoEncontradoException {
		Scanner input;
		try {
			input = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new ArquivoNaoEncontradoException(path);
		}
		return input;
	}

	public File abrirArquivoSaida(String caminhoCompletoSaida) throws IOException {
		File file = new File(caminhoCompletoSaida);
		if(!file.exists()) {
			file.createNewFile();
		}
		return file;
	}

	public String getArquivoSaida() {
		return arquivoSaida;
	}

	public String getNomeArquivoEntrada() { return nomeArquivoEntrada; }

	public void setNomeArquivoEntrada(String nomeArquivoEntrada) {
		this.nomeArquivoEntrada = nomeArquivoEntrada;
	}

	public void setArquivoSaida(String caminhoCompletoSaida) {
		this.arquivoSaida = caminhoCompletoSaida;
	}
}