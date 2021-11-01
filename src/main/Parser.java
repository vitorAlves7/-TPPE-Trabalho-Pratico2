package main;

import exceptions.ArquivoNaoEncontradoException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Parser {
    Vector <Vector<Double>> buffer;

    public Parser(){
        buffer = new Vector <Vector <Double>>();
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
}
