package sp2fy;

import java.util.ArrayList;

import exception.ValidacaoException;
import validacao.Validacao;

public class Album implements Comparable<Album>{
	
	private final String FIM_DE_LINHA = System.lineSeparator();
	
	private String artista;
	private String titulo;
	private int anoLancamento;
	private Validacao minhaValidacao;
	
	private ArrayList<Musica> musicas;

	
	public Album(String artista, String titulo, int anoLancamento) throws ValidacaoException{
		
		this.minhaValidacao = new Validacao();
		
		minhaValidacao.validaAlbum(artista, titulo, anoLancamento);
		
		this.artista = artista;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.musicas = new ArrayList<>();
		
	}
	

	// gets
	
	public String getArtista() {
		return this.artista;
	}
	
	public String getTitulo() {

		return this.titulo;
	}
	
	public int getAnoLancamento() {
		return anoLancamento;
	}


	public int getDuracaoTotal(){ // retorna a duracao total do album com base nas faixas
		int duracao = 0;
		for(int i = 0; i < musicas.size(); i++) {
			duracao += musicas.get(i).getDuracao();
		}
		
		return duracao;
		
		
	}
	
	public Musica getMusica(String titulo) throws ValidacaoException{

		minhaValidacao.validaMusica(titulo);

		
		for(int i = 0; i < musicas.size(); i++) {
			if(musicas.get(i).getTitulo().equals(titulo)) {
				return musicas.get(i);
			}
		}
		
		return null;
		
		
	}
	
	public Musica getMusica(int faixa) throws ValidacaoException{
		if(faixa - 1 < 0) {
			throw new ValidacaoException("Faixa invalida");
		}
		
		return musicas.get(faixa-1);
	}
	
	public boolean adicionaMusica(Musica newMusic) throws ValidacaoException{ 
		minhaValidacao.validaObjeto(newMusic, "Musica nao pode ser nula");
		
		musicas.add(newMusic);
		return true;
		
		
	}
	
	public boolean removeMusica(int faixa) throws ValidacaoException {
		minhaValidacao.validaNumeroFaixa(faixa, "Faixa invalida");
		
		if(numeroDeFaixas() - faixa < 0) {
			return false;
		}
		
		musicas.remove(faixa-1);
		return true;
	}
	
	public boolean contemMusica(String titulo) throws ValidacaoException{
		minhaValidacao.validaTitulo(titulo, "Titulo da musica invalido");
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
		result = prime * result + ((this.getArtista() == null) ? 0 : this.getArtista().hashCode());
		result = prime * result + ((this.getTitulo() == null) ? 0 : this.getTitulo().hashCode());
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
		if (this.getArtista() == null) {
			if (other.getArtista() != null)
				return false;
		} else if (!getArtista().equals(other.getArtista()))
			return false;
		if (this.getTitulo() == null) {
			if (other.getTitulo() != null)
				return false;
		} else if (!this.getTitulo().equals(other.getTitulo()))
			return false;
		return true;
	}
	
	@Override
	public String toString() { // mostra artista, titulo, ano de lancamento e as musicas contidas no album
		String album = "Artista: " + this.getArtista() + FIM_DE_LINHA +
					 "Titulo do album: " + this.getTitulo() + FIM_DE_LINHA +
					 "Ano de Lancamento: " + this.getAnoLancamento() + FIM_DE_LINHA;
		if (musicas.size() >= 1){
			album += FIM_DE_LINHA;
			for (int i = 0; i < musicas.size(); i++) {
				album += String.format("Faixa %d) %s" + FIM_DE_LINHA, i+1, musicas.get(i).toString());
			}
		} else {
			album += FIM_DE_LINHA + "Album " + this.getTitulo() + " sem musicas adicionadas";
		}
		return album;
	}

	public int compareTo(Album outroAlbum) { // comparacao padrao com base no ano de lancamento
		if (this.getAnoLancamento() < outroAlbum.getAnoLancamento()) {
			return -1;
		}
		if (this.getAnoLancamento() > outroAlbum.getAnoLancamento()) {
			return 1;
		}
		return 0;
	}

}
