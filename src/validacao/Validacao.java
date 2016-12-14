package validacao;

import exception.ValidacaoException;
import sp2fy.Album;
import sp2fy.Musica;

public class Validacao {

	public void validaMusica(String titulo, int duracao, String genero) throws ValidacaoException{
		
		// titulo nao pode ser nulo ou primeiro caractere de titulo tem que ser um numero ou uma letra, tamanho minimo para titulo: 2
		if(titulo == null || titulo.length() < 2 ){
			throw new ValidacaoException("Titulo da musica nao pode ser nulo e deve contar no minimo 2 caracteres");
		}
		
		// duracao nao pode ser negativa
		if(duracao <= 0 ) {
			throw new ValidacaoException("Duracao da musica nao pode ser nulo ou negativo");
		}
		
		// genero nao pode ser nulo nem conter numeros ou caracteres especiais, tamanho minimo para genero: 2
		if(genero == null || genero.length() < 2) {
			throw new ValidacaoException("Genero da musica nao pode ser nulo e o tamanho minimo para genero eh 2");
		} else if(!(Character.isAlphabetic(genero.charAt(0)))) {
			throw new ValidacaoException("Genero da musica nao pode conter numeros ou caracteres especiais");
		}
		for(int i = 1; i < genero.length() ; i ++) {
			if (!(Character.isAlphabetic(genero.charAt(i)))){
				if(genero.charAt(i) != ' ' && genero.charAt(i) != '-') {
					throw new ValidacaoException("Genero da musica nao pode conter numeros ou caracteres especiais");
				}
					
			}
		}
	}

	public void validaMusica(String titulo) throws ValidacaoException {
		// titulo nao pode ser nulo ou primeiro caractere de titulo tem que ser um numero ou uma letra, tamanho minimo para titulo: 2
		if(titulo == null || titulo.length() < 2 ){
			throw new ValidacaoException("Titulo da musica nao pode ser nulo e deve contar no minimo 2 caracteres");
		}
	}
	
	public void validaAlbum(String artista, String titulo, int anoLancamento) throws ValidacaoException{
		if(artista == null || artista.equals(" ") || artista.equals("")) {
			throw new ValidacaoException("Artista do album nao pode ser nulo");
		} 
		if(titulo == null || titulo.equals(" ") || titulo.equals("")) {
			throw new ValidacaoException("Titulo do album nao deve ser nulo ou vazio");
			
		}
		if(anoLancamento < 1800 || anoLancamento > 2016) {
			throw new ValidacaoException("Ano de lancamento nao deve ser inferior a 1800 ou superior a 2016");
			
		}
		

	}

	public void validaAlbum(String titulo) throws ValidacaoException{
		if(titulo == null || titulo.length() < 2) {
			throw new ValidacaoException("Titulo do album nao deve ser nulo ou vazio, informe um titulo com no minimo 2 letras");
			
		}
	}
	
	public void validaObjetoMusica(Object obj) throws ValidacaoException{
		if (obj == null) {
			throw new ValidacaoException("Musica nao pode ser nula");
		}
		
		
	}
	
	public void validaObjeto(Object obj, String msg) throws ValidacaoException {
		if(obj == null) {
			throw new ValidacaoException(msg);
		}
	}
	
	public void validaTitulo(String titulo, String msg) throws ValidacaoException {
		if(titulo == null || titulo.equals(" ") || titulo.equals("")) {
			throw new ValidacaoException(msg);
		}
	}
	
	public void validaTituloEArtista(String titulo, String artista, String msg) throws ValidacaoException {
		if(titulo == null || titulo.length() < 2) {
			throw new ValidacaoException(msg);
		}
		
		if(artista == null || artista.length() < 2) {
			throw new ValidacaoException(msg);
		} else if(!Character.isAlphabetic(artista.charAt(0))) {
			throw new ValidacaoException(msg);
		}else {
			for(int i = 1; i < artista.length(); i++) {
				if(!(Character.isAlphabetic(artista.charAt(i)))){
					if(artista.charAt(i) != ' ') {
						throw new ValidacaoException(msg);
					}
				}
			}
		}
	}

	public void validaNumero(int x, String msg) throws ValidacaoException{
		if(x < 0) {
			throw new ValidacaoException(msg);
		}
	}

	public void validaNumeroFaixa(int faixa, String msg) throws ValidacaoException{
		if(faixa <= 0) {
			throw new ValidacaoException(msg);
		}
		
	}
	
}

