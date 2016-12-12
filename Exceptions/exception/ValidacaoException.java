package exception;

public class ValidacaoException extends Exception {

   private static final long serialVersionUID = 1L;;

    // constrói um objeto MusicaValidacaoException com a mensagem passada por parâmetro
	public ValidacaoException(String msg) {
		super (msg);
	}

}
