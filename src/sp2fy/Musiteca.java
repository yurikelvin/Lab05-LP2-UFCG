package sp2fy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Comparators.ArtistaComparator;
import Comparators.DuracaoTotalComparator;
import Comparators.NumeroDeFaixasComparator;
import exception.ValidacaoException;
import validacao.Validacao;

public class Musiteca {
	
	private HashSet<Album> meusAlbunsFavoritos;
	private ArrayList<Album> meusAlbuns;
	
	private HashMap<String, Playlist> minhasPlaylists;
	private final String FIM_DE_LINHA = System.lineSeparator();
	private Validacao minhaValidacao;
	
	public Musiteca() {
		
		this.meusAlbunsFavoritos = new HashSet<>();
		this.meusAlbuns = new ArrayList<>();
		this.minhasPlaylists = new HashMap<>();
		this.minhaValidacao = new Validacao();
	}
	
	public boolean adicionaAlbum(Album novoAlbum) throws ValidacaoException{
		minhaValidacao.validaObjeto(novoAlbum, "Album nao pode ser nulo");

		meusAlbuns.add(novoAlbum);
		Collections.sort(meusAlbuns); // ordena album com base nos anos de lancamento
		return true;
	}
	
	public boolean adicionaAlbumFavorito(Album novoAlbum) throws ValidacaoException{
		minhaValidacao.validaObjeto(novoAlbum, "Album nao pode ser nulo");

		if( !(pesquisaAlbum(novoAlbum.getTitulo())) ) {
			return false;
			
		}
		meusAlbunsFavoritos.add(novoAlbum);
		return true;
	}
	
	public boolean removeAlbum(String titulo) throws ValidacaoException {
		minhaValidacao.validaTitulo(titulo, "Nome do album invalido");
		if( pesquisaAlbum(titulo) ) {
			Iterator<Album> it = meusAlbuns.iterator();

			while(it.hasNext()) {

				Album a = it.next();
				if(a.getTitulo().equals(titulo)){
					it.remove();
					return true;
				}
			}
		} 
		return false;
	}
	
	public boolean removeAlbumFavorito(String titulo) throws ValidacaoException {
		minhaValidacao.validaTitulo(titulo, "Nome do album invalido");
		if( pesquisaAlbumFavorito(titulo) ) {
			Iterator<Album> it = meusAlbunsFavoritos.iterator();

			while(it.hasNext()) {

				Album a = it.next();
				if(a.getTitulo().equals(titulo)){
					it.remove();
					return true;
				}
			}
		} 
		return false;
	}

	public boolean pesquisaAlbum(String nome) throws ValidacaoException{
		minhaValidacao.validaTitulo(nome, "Nome do album invalido");
		
		Iterator<Album> it = meusAlbuns.iterator();
		while(it.hasNext()) {
			Album a = it.next();
			if(a.getTitulo().equals(nome)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean pesquisaAlbumFavorito(String nome) throws ValidacaoException{
		minhaValidacao.validaTitulo(nome, "Nome do album invalido");
		
		Iterator<Album> it = meusAlbunsFavoritos.iterator();
		while(it.hasNext()) {
			Album a = it.next();
			if(a.getTitulo().equals(nome)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Album getAlbum(String nomeAlbum) throws ValidacaoException{
		try {
			minhaValidacao.validaTitulo(nomeAlbum, "Nome de album invalido");
		} catch(Exception e) {
			return null;
		}
		Iterator<Album> it = meusAlbuns.iterator();
		while(it.hasNext()) {
			Album album = it.next();
			if (album.getTitulo().equals(nomeAlbum)) {
				return album;
			}
		} 
		return null;
		
	}
	
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception{
		minhaValidacao.validaTitulo(nomePlaylist, "Nome playlist invalido");
		minhaValidacao.validaTitulo(nomeAlbum, "Nome album invalido");
		minhaValidacao.validaNumero(faixa, "Faixa invalida");
	
		if(minhasPlaylists.containsKey(nomePlaylist)) {
			if (pesquisaAlbum(nomeAlbum)) {
				Playlist adicionarMusicaPlaylist = minhasPlaylists.get(nomePlaylist);
				adicionarMusicaPlaylist.adicionaMusica(getAlbum(nomeAlbum).getMusica(faixa));
				return true;
			} else {
				throw new Exception("Album nao pertence ao Perfil especificado");
			}
			
		} else {
			minhasPlaylists.put(nomePlaylist, new Playlist(nomePlaylist));
			if(pesquisaAlbum(nomeAlbum)) {
				Playlist adicionarMusicaPlaylist = minhasPlaylists.get(nomePlaylist);
				adicionarMusicaPlaylist.adicionaMusica(getAlbum(nomeAlbum).getMusica(faixa));
				return true;
			} else {
				throw new Exception("Album nao pertence ao Perfil especificado");
			}
		}


	}

	public boolean removePlaylist(String nomePlaylist) throws ValidacaoException{
		minhaValidacao.validaTitulo(nomePlaylist, "Nome de playlist invalido");
		
		if(minhasPlaylists.remove(nomePlaylist) == null) {
			return false;
		} return true;
		
	}

	public void ordenaAlbumWithArtist() {
		ArtistaComparator comparator = new ArtistaComparator();
		Collections.sort(meusAlbuns, comparator);
	}
	
	public void ordenaAlbumWithDuration() {
		DuracaoTotalComparator comparator = new DuracaoTotalComparator();
		Collections.sort(meusAlbuns, comparator);
	}
	
	public void ordenaAlbumWithTrackNumbers() {
		NumeroDeFaixasComparator comparator = new NumeroDeFaixasComparator();
		Collections.sort(meusAlbuns, comparator);
	}
	
	@Override
	public String toString() {
		String musiteca = "--- Albuns ---" + FIM_DE_LINHA;
		
		if(meusAlbuns.size() == 0) {
			musiteca += FIM_DE_LINHA + "Sem albuns adicionados" + FIM_DE_LINHA;
			
		} else {
			for(int i = 0; i < meusAlbuns.size(); i ++) {
				musiteca += String.format(FIM_DE_LINHA + "%s", meusAlbuns.get(i));
			}
			
			musiteca += FIM_DE_LINHA;
			
			
		}
		musiteca += "-------------------" + FIM_DE_LINHA;
		
		musiteca += FIM_DE_LINHA + "--- Albuns Favoritos ---" + FIM_DE_LINHA;
		if(meusAlbunsFavoritos.size() == 0) {
			musiteca += FIM_DE_LINHA + "Sem albuns favoritos" + FIM_DE_LINHA;
		} else {
			Iterator<Album> it = meusAlbunsFavoritos.iterator();
			while(it.hasNext()) {
				Album album = it.next();
				musiteca += String.format(FIM_DE_LINHA + "%s", album);
			}
			
			musiteca += FIM_DE_LINHA;
			
		}
		musiteca += "-------------------" + FIM_DE_LINHA;
		
		musiteca += FIM_DE_LINHA + "--- Playlists ---" + FIM_DE_LINHA;
		if(minhasPlaylists.size() == 0) {
			musiteca += FIM_DE_LINHA + "Sem playlists adicionadas" + FIM_DE_LINHA;
			
		} else {
			Set<String> chaves = minhasPlaylists.keySet();
			for(String keys : chaves) {
				musiteca += String.format(FIM_DE_LINHA + "%s", minhasPlaylists.get(keys));
			}
			
			musiteca += FIM_DE_LINHA;
		}
		musiteca += "-------------------" + FIM_DE_LINHA;
		
		return musiteca;
	}

	
}
