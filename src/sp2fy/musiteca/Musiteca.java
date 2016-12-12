package sp2fy.musiteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import exception.ValidacaoException;
import sp2fy.album.Album;
import sp2fy.musica.Musica;
import validacao.Validacao;

public class Musiteca {
	
	private HashSet<Album> meusAlbunsFavoritos;
	private ArrayList<Album> meusAlbuns;
	private HashMap<String, Musica> minhasPlaylists;
	
	private Validacao minhaValidacao;
	
	public Musiteca() {
		
		meusAlbunsFavoritos = new HashSet<>();
		meusAlbuns = new ArrayList<>();
		minhasPlaylists = new HashMap<>();
		
		minhaValidacao = new Validacao();
	}
	
	public boolean adicionaAlbum(Album novoAlbum) {
		if(novoAlbum == null) {
			return false;
		}
		meusAlbuns.add(novoAlbum);
		return true;
	}
	
	public boolean adicionaAlbumFavorito(Album novoAlbum) {
		if(novoAlbum == null) {
			return false;
		}
		meusAlbunsFavoritos.add(novoAlbum);
		return true;
	}
	
	public boolean removeAlbum(String artista, String titulo) throws ValidacaoException {
		minhaValidacao.validaTituloEArtista(titulo, artista, "Nome do album ou artista invalido");
		if( pesquisaAlbum(artista,titulo) ) {
			Iterator<Album> it = meusAlbuns.iterator();

			while(it.hasNext()) {

				Album a = it.next();
				if(a.getTitulo().equals(titulo) && a.getArtista().equals(artista)){
					it.remove();
					return true;
				}
			}
		} 
		return false;
	}
	
	public boolean removeAlbumFavorito(String artista, String titulo) throws ValidacaoException {
		minhaValidacao.validaTituloEArtista(titulo, artista, "Nome do album ou artista invalido");
		if( pesquisaAlbumFavorito(artista,titulo) ) {
			Iterator<Album> it = meusAlbunsFavoritos.iterator();

			while(it.hasNext()) {

				Album a = it.next();
				if(a.getTitulo().equals(titulo) && a.getArtista().equals(artista)){
					it.remove();
					return true;
				}
			}
		} 
		return false;
	}

	public boolean pesquisaAlbum(String artista, String nome) throws ValidacaoException{
		minhaValidacao.validaTituloEArtista(nome, artista, "Nome do album ou artista invalido");
		
		Iterator<Album> it = meusAlbuns.iterator();
		while(it.hasNext()) {
			Album a = it.next();
			if(a.getTitulo().equals(nome) && a.getArtista().equals(artista)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean pesquisaAlbumFavorito(String artista, String nome) throws ValidacaoException{
		minhaValidacao.validaTituloEArtista(nome, artista, "Nome do album ou artista invalido");
		
		Iterator<Album> it = meusAlbunsFavoritos.iterator();
		while(it.hasNext()) {
			Album a = it.next();
			if(a.getTitulo().equals(nome) && a.getArtista().equals(artista)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) {
		
		boolean temNaPlaylist = false;
		
		Set<String> keys = minhasPlaylists.keySet();
		for(String playlist : keys) {
			if(playlist.equals(nomePlaylist)) {
				temNaPlaylist = true;
				
				
			}
		}
		
		return false;
	}
	
//	public Album getAlbum(String titulo) throws ValidacaoException{
//		try {
//			minhaValidacao.validaAlbum(titulo);
//		}catch(Exception e) {
//			return null;
//		}
//		
//		for(int i = 0; i < albuns.size(); i++) {
//			if(albuns.get(i).getTitulo().equals(titulo)) {
//				return albuns.get(i);
//			}
//		}
//		
//		return null;
//	}

//	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws ValidacaoException{
//		
//		Album albumPlaylist = getAlbum(nomeAlbum).getMusica(faixa);
//		
//		playlist.put(nomePlaylist, albumPlaylist);
//		
//		
//	}

}
