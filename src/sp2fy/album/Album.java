package sp2fy.album;

import java.util.ArrayList;

import exception.ValidacaoException;
import sp2fy.musica.Musica;
import validacao.Validacao;

public class Album implements Comparable<Album>{
	
	private final String FIM_DE_LINHA = System.lineSeparator();
	
	private String artista;
	private String titulo;
	private int anoLancamento;
	private Validacao minhaValidacao;
	
	private ArrayList<Musica> musicas;

	
	public Album(String artista, String titulo, int anoLancamento) throws ValidacaoException{
		
		minhaValidacao = new Validacao();
		
		minhaValidacao.validaAlbum(artista, titulo, anoLancamento);
		
		this.artista = artista;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		musicas = new ArrayList<>();
	}
	

	// gets
	
	public String getArtista() {
		return this.artista;
	}
	
	public String getTitulo() {

		return this.titulo;
	}
	
	public int getDuracaoTotal(){ // retorna a duracao total do album com base nas faixas
		int duracao = 0;
		for(int i = 0; i < musicas.size(); i++) {
			duracao += musicas.get(i).getDuracao();
		}
		
		return duracao;
		
		
	}
	
	public Musica getMusica(String titulo) throws ValidacaoException{

		try {
			minhaValidacao.validaMusica(titulo);
		}catch(ValidacaoException e) {
			return null;
		}

		
		for(int i = 0; i < musicas.size(); i++) {
			if(musicas.get(i).getTitulo().equals(titulo)) {
				return musicas.get(i);
			}
		}
		
		return null;
		
		
	}
	
	public Musica getMusica(int faixa) {
		if(faixa - 1 < 0) {
			return null;
		}
		
		return musicas.get(faixa-1);
	}
	
	public boolean adicionaMusica(Musica newMusic) { 
		if(newMusic == null) {
			return false;
		}
		
		musicas.add(newMusic);
		return true;
		
		
	}
	
	public boolean removeMusica(int faixa) {
		if(faixa <= 0) {
			return false;
		}
		
		if(numeroDeFaixas() - faixa < 0) {
			return false;
		}
		
		musicas.remove(faixa-1);
		return true;
	}
	
	public boolean contemMusica(String titulo) throws ValidacaoException{
		try{
			minhaValidacao.validaMusica(titulo);
		}catch(ValidacaoException e) {
			return false;
		}
		
		for(int i = 0; i < musicas.size(); i++) {
			if (musicas.get(i).getTitulo().equals(titulo)) {
				return true;
			}
		}
		
		return false;
	}
	
	public int numeroDeFaixas() { // retorna a quantidade de musicas no album
		return musicas.size();
	}

	@Override
	public int hashCode() { // baseado em artista e titulo
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { // baseado em artista e titulo

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	@Override
	public String toString() { // mostra artista, titulo, ano de lancamento e as musicas contidas no album
		String album = "Artista: " + this.artista + FIM_DE_LINHA +
					 "Titulo do album: " + this.titulo + FIM_DE_LINHA +
					 "Ano de Lancamento: " + this.anoLancamento + FIM_DE_LINHA;
		if (musicas.size() >= 1){
			album += FIM_DE_LINHA;
			for (int i = 0; i < musicas.size(); i++) {
				album += String.format("Faixa %d) %s" + FIM_DE_LINHA, i+1, musicas.get(i).toString());
			}
		} else {
			album += FIM_DE_LINHA + "Album sem musicas adicionadas";
		}
		return album;
	}

	public int compareTo(Album outroAlbum) { // comparacao padrao com base no ano de lancamento
		if (this.anoLancamento < outroAlbum.anoLancamento) {
			return -1;
		}
		if (this.anoLancamento > outroAlbum.anoLancamento) {
			return 1;
		}
		return 0;
	}

}
