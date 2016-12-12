package sp2fy.playlists;

import java.util.ArrayList;
import java.util.Iterator;

import exception.ValidacaoException;
import sp2fy.musica.Musica;
import validacao.Validacao;

public class Playlist {
	
	private String nomePlaylist;
	private ArrayList<Musica> musicasPlaylist;
	private Validacao minhaValidacao;
	private String FIM_DE_LINHA = System.lineSeparator();
	
	public Playlist(String nomePlaylist) throws ValidacaoException{
		
		minhaValidacao = new Validacao();
		musicasPlaylist = new ArrayList<>();
		
		minhaValidacao.validaTitulo(nomePlaylist, "Nome de playlist invalida");
		
		
		this.nomePlaylist = nomePlaylist;
	}
	
	// get
	
	public String getNomePlaylist() {
		return this.nomePlaylist;
	}
	
	public boolean adicionaMusica(Musica newMusicPlaylist) throws ValidacaoException{
		
		minhaValidacao.validaObjetoMusica(newMusicPlaylist);
		
		return musicasPlaylist.add(newMusicPlaylist);
		
	}
	
	public boolean removeMusica(Musica removeMusic) throws ValidacaoException{
		
		minhaValidacao.validaObjetoMusica(removeMusic);

		return musicasPlaylist.remove(removeMusic);
	}
	
	public boolean removeMusica(String nomeMusica) throws ValidacaoException{
		minhaValidacao.validaTitulo(nomeMusica, "Nome de musica invalida");
		
		Iterator<Musica> it = musicasPlaylist.iterator();
		while(it.hasNext()) {
			Musica musicaNaPlaylist = it.next();
			if(musicaNaPlaylist.getTitulo().equals(nomeMusica)) {
				it.remove();
				return true;
			}
		}
		
		return false;
	}
	
	public boolean pesquisaMusica(Musica searchMusic) throws ValidacaoException{
		minhaValidacao.validaObjetoMusica(searchMusic);
		
		return musicasPlaylist.contains(searchMusic);
	}
	
	public boolean pesquisaMusica(String nomeMusica) throws ValidacaoException{
		minhaValidacao.validaTitulo(nomeMusica, "Nome de musica invalida");
		
		Iterator<Musica> it = musicasPlaylist.iterator();
		while(it.hasNext()) {
			Musica musicaNaPlaylist = it.next();
			if(musicaNaPlaylist.getTitulo().equals(nomeMusica)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public int duracaoTotal() {
		int duracao = 0;
		
		Iterator<Musica> it = musicasPlaylist.iterator();
		while(it.hasNext()) {
			Musica musicaNaPlaylist = it.next();
			duracao += musicaNaPlaylist.getDuracao();
			
		}
		
		return duracao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomePlaylist == null) ? 0 : nomePlaylist.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		if (nomePlaylist == null) {
			if (other.nomePlaylist != null)
				return false;
		} else if (!nomePlaylist.equals(other.nomePlaylist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String playlist = "Playlist: " + this.nomePlaylist + FIM_DE_LINHA;
		if (musicasPlaylist.size() >= 1){
			playlist += FIM_DE_LINHA;
			for (int i = 0; i < musicasPlaylist.size(); i++) {
				playlist += String.format("%d) %s" + FIM_DE_LINHA, i+1, musicasPlaylist.get(i).toString());
			}
		} else {
			playlist += FIM_DE_LINHA + "Playlist sem musicas adicionadas";
		}
		return playlist;
	}


}

