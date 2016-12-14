package exception;

/** 
 * Código desenvolvido para o lab05 de LP2-computacao@ufcg 2016.2
 * Yuri Silva - 116110057
 */


public class ValidacaoException extends Exception {

   private static final long serialVersionUID = 1L;;

    // constrói uma excessao geral ValidacaoException para sp2fy, com mensagem passada pelo parametro
	public ValidacaoException(String msg) {
		super (msg);
	}

}
