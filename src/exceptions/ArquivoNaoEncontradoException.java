package exceptions;

public class ArquivoNaoEncontradoException extends Exception {

    public ArquivoNaoEncontradoException(String msg){
        super("Nao foi possivel abrir o arquivo: " + msg);
    }


}

