package sp2fy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sp2fy.Album;
import sp2fy.Musica;
import sp2fy.Perfil;

public class PerfilTest {
	
	private Perfil meuPerfil;
	private String FIM_DE_LINHA;

	@Before
	public void criaPerfil() throws Exception {
		meuPerfil = new Perfil("Yuri");
		FIM_DE_LINHA = System.lineSeparator();
	}

	@Test
	public void testPerfil() throws Exception {
		Album maroonFive = new Album("Maroon 5", "Sugar", 2015);
		maroonFive.adicionaMusica(new Musica("Sugar", 3, "Pop"));
		maroonFive.adicionaMusica(new Musica("Animals", 5, "Pop"));
		maroonFive.adicionaMusica(new Musica("Payphone", 4, "Pop"));
		
		
		Album justinTimberlake = new Album("Justin Timberlake", "Mirror", 2015);
		justinTimberlake.adicionaMusica(new Musica("Mirror", 10, "Romantic"));
		justinTimberlake.adicionaMusica(new Musica("Whats goes around", 6, "Pop"));
		
		meuPerfil.adicionaAlbum(maroonFive);
		meuPerfil.adicionaAlbum(justinTimberlake);
		
		meuPerfil.adicionaPlaylist("So as melhores", "Sugar", 1);
		meuPerfil.adicionaPlaylist("So as melhores", "Mirror", 1);
		
		meuPerfil.adicionaAlbumFavorito(maroonFive);
		
		final String testePerfil = "Usuario: Yuri" + FIM_DE_LINHA +
				                   "--- Albuns ---" + FIM_DE_LINHA + FIM_DE_LINHA + 
				                   "Artista: Maroon 5" + FIM_DE_LINHA + 
				                   "Titulo do album: Sugar" + FIM_DE_LINHA + 
				                   "Ano de Lancamento: 2015" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "Faixa 1) Titulo: Sugar, Duracao: 3 minutos, Genero: Pop" + FIM_DE_LINHA +
				                   "Faixa 2) Titulo: Animals, Duracao: 5 minutos, Genero: Pop" + FIM_DE_LINHA +
				                   "Faixa 3) Titulo: Payphone, Duracao: 4 minutos, Genero: Pop" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "Artista: Justin Timberlake" + FIM_DE_LINHA +
				                   "Titulo do album: Mirror" + FIM_DE_LINHA +
				                   "Ano de Lancamento: 2015" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "Faixa 1) Titulo: Mirror, Duracao: 10 minutos, Genero: Romantic" + FIM_DE_LINHA +
				                   "Faixa 2) Titulo: Whats goes around, Duracao: 6 minutos, Genero: Pop" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "-------------------" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "--- Albuns Favoritos ---" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "Artista: Maroon 5" + FIM_DE_LINHA + 
				                   "Titulo do album: Sugar" + FIM_DE_LINHA + 
				                   "Ano de Lancamento: 2015" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "Faixa 1) Titulo: Sugar, Duracao: 3 minutos, Genero: Pop" + FIM_DE_LINHA +
				                   "Faixa 2) Titulo: Animals, Duracao: 5 minutos, Genero: Pop" + FIM_DE_LINHA +
				                   "Faixa 3) Titulo: Payphone, Duracao: 4 minutos, Genero: Pop" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "-------------------" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "--- Playlists ---" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "Playlist: \"So as melhores\"" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "1) Titulo: Sugar, Duracao: 3 minutos, Genero: Pop" + FIM_DE_LINHA +
				                   "2) Titulo: Mirror, Duracao: 10 minutos, Genero: Romantic" + FIM_DE_LINHA + FIM_DE_LINHA +
				                   "-------------------" + FIM_DE_LINHA +
				                   "Fim do perfil de Yuri";
		

		assertEquals(testePerfil, meuPerfil.toString());
				                   
				                   
		
	}

}
