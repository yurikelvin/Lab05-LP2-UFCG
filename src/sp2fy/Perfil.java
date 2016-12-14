package sp2fy;

import exception.ValidacaoException;
import validacao.Validacao;

public class Perfil {

	private Musiteca minhaMusiteca;
	private String nomeUsuario;
	private Validacao minhaValidacao;
	
	public Perfil(String nomeUsuario) throws ValidacaoException{
		minhaValidacao = new Validacao();
		minhaValidacao.validaTitulo(nomeUsuario, "Nome de usuario invalido");
		
		
		this.nomeUsuario = nomeUsuario;
		minhaMusiteca = new Musiteca();
	}
	
	public boolean adicionaAlbum(Album album) {
		return minhaMusiteca.adicionaAlbum(album);
	}
	
	public boolean adicionaAlbumFavorito(Album album) {
		return minhaMusiteca.adicionaAlbumFavorito(album);
	}
	
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception{
		return minhaMusiteca.adicionaPlaylist(nomePlaylist, nomeAlbum, faixa);
	}
	
	public boolean removeAlbum(String titulo) throws Exception{
		return minhaMusiteca.removeAlbum(titulo);
	}
	
	public boolean removeAlbumFavorito(String titulo) throws Exception {
		return minhaMusiteca.removeAlbumFavorito(titulo);
	}
	
	public boolean removePlaylist(String titulo) throws Exception {
		return minhaMusiteca.removePlaylist(titulo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
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
		Perfil other = (Perfil) obj;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Usuario: " + this.nomeUsuario + System.lineSeparator() + minhaMusiteca + "Fim do perfil de " + this.nomeUsuario;
	}

}
