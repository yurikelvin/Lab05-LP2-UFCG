package exception;

public class ValidacaoException extends Exception {

   private static final long serialVersionUID = 1L;;

    // constrói uma excessao geral ValidacaoException para sp2fy, com mensagem passada pelo parametro
	public ValidacaoException(String msg) {
		super (msg);
	}

}
