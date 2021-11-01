package exceptions;

public class EscritaNaoPermitidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public EscritaNaoPermitidaException(String msg){
        super("Caminho sem permissao de escrita: " + msg);
	}
}