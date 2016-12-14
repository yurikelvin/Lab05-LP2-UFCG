package sp2fy;

import static org.junit.Assert.fail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import sp2fy.Musica;
import sp2fy.Playlist;

public class PlaylistTest {

	private Playlist minhaPlaylist;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void criaPlaylist() throws Exception {
		minhaPlaylist = new Playlist("Pra relaxar");

		
	}
	
	@Test
	public void testConstrutorWithException1() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("Nome de playlist invalida");
		new Playlist(null);
	}

	@Test
	public void testConstrutorWithException2() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("Nome de playlist invalida");
		new Playlist("");
	}
	
	@Test
	public void testConstrutorWithException3() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("Nome de playlist invalida");
		new Playlist(" ");
	}

	@Test
	public void testAdicionaMusicaWithException() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Musica nao pode ser nula");
		minhaPlaylist.adicionaMusica(null);
		
	}
	
	@Test
	public void testRemoveMusicaPeloNome() throws Exception {
		Musica adorar = new Musica("Quero te adorar", 3, "Gospel");
		Musica abrirCoracao = new Musica("Vou abrir meu coracao", 8, "Gospel");
		Musica cheiaDeManias = new Musica("Cheia de manias", 4, "Pagode");
		minhaPlaylist.adicionaMusica(adorar);
		minhaPlaylist.adicionaMusica(cheiaDeManias);
		minhaPlaylist.adicionaMusica(abrirCoracao);
		
		assertTrue(minhaPlaylist.pesquisaMusica(adorar));
		assertTrue(minhaPlaylist.removeMusica("Quero te adorar"));
		assertFalse(minhaPlaylist.pesquisaMusica(adorar));
		
		assertTrue(minhaPlaylist.pesquisaMusica(cheiaDeManias));
		assertTrue(minhaPlaylist.removeMusica("Cheia de manias"));
		assertFalse(minhaPlaylist.pesquisaMusica(cheiaDeManias));
		
		assertTrue(minhaPlaylist.pesquisaMusica(abrirCoracao));
		assertTrue(minhaPlaylist.removeMusica("Vou abrir meu coracao"));
		assertFalse(minhaPlaylist.pesquisaMusica(abrirCoracao));
		
		
	}

	@Test
	public void testRemoveMusicaPelaMusicaWithException() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Musica nao pode ser nula");
		Musica musicaNull = null;
		minhaPlaylist.removeMusica(musicaNull);
	}
	
	@Test
	public void testRemoveMusicaPeloNomeWithException() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Nome de musica invalida");
		String musicaNull = null;
		minhaPlaylist.removeMusica(musicaNull);
	}
	
	@Test
	public void testNotRemovedMusicaPeloNome() throws Exception{
		assertFalse(minhaPlaylist.removeMusica("era pra dar pau"));
		assertFalse(minhaPlaylist.removeMusica("musica qualquer"));
		assertFalse(minhaPlaylist.removeMusica("Essa"));
	}

	@Test
	public void testPesquisaPeloNome() throws Exception {
		Musica adorar = new Musica("Quero te adorar", 3, "Gospel");
		Musica abrirCoracao = new Musica("Vou abrir meu coracao", 8, "Gospel");
		Musica cheiaDeManias = new Musica("Cheia de manias", 4, "Pagode");
		minhaPlaylist.adicionaMusica(adorar);
		minhaPlaylist.adicionaMusica(cheiaDeManias);
		minhaPlaylist.adicionaMusica(abrirCoracao);
		
		assertTrue(minhaPlaylist.pesquisaMusica("Quero te adorar"));
		assertTrue(minhaPlaylist.pesquisaMusica("Vou abrir meu coracao"));
		assertTrue(minhaPlaylist.pesquisaMusica("Cheia de manias"));
		
		assertFalse(minhaPlaylist.pesquisaMusica("raca negra"));
		assertFalse(minhaPlaylist.pesquisaMusica("digdin"));
		assertFalse(minhaPlaylist.pesquisaMusica("ajuda a segurar"));
		
	}
	
	@Test
	public void testDuracaoTotal() throws Exception {
		Musica adorar = new Musica("Quero te adorar", 3, "Gospel");
		Musica abrirCoracao = new Musica("Vou abrir meu coracao", 8, "Gospel");
		Musica cheiaDeManias = new Musica("Cheia de manias", 4, "Pagode");
		minhaPlaylist.adicionaMusica(adorar);
		assertEquals(3, minhaPlaylist.duracaoTotal());
		minhaPlaylist.adicionaMusica(cheiaDeManias);
		assertEquals(7, minhaPlaylist.duracaoTotal());
		minhaPlaylist.adicionaMusica(abrirCoracao);
		assertEquals(15, minhaPlaylist.duracaoTotal());
	}
	
	@Test
	public void testHashCode() throws Exception {
		Playlist testePrimeiraPlaylist = new Playlist("Pra relaxar");
		Playlist playlist2 = new Playlist("Para dar confusao");
		Playlist playlist3 = new Playlist("Para dar confusao");
		
		assertTrue(minhaPlaylist.hashCode() == testePrimeiraPlaylist.hashCode());
		assertFalse(minhaPlaylist.hashCode() == playlist2.hashCode());
		assertTrue(playlist2.hashCode() == playlist3.hashCode());
		assertFalse(minhaPlaylist.hashCode() == playlist3.hashCode());
		assertFalse(testePrimeiraPlaylist.hashCode() == playlist3.hashCode());
		
	}
	
	@Test
	public void testEquals() throws Exception {
		Playlist testePrimeiraPlaylist = new Playlist("Pra relaxar");
		Playlist playlist2 = new Playlist("Para dar confusao");
		Playlist playlist3 = new Playlist("Para dar confusao");
		
		assertTrue(minhaPlaylist.equals(testePrimeiraPlaylist));
		assertTrue(testePrimeiraPlaylist.equals(minhaPlaylist));
		assertFalse(minhaPlaylist.equals(playlist2));
		assertFalse(minhaPlaylist.equals(playlist3));
		assertFalse(testePrimeiraPlaylist.equals(playlist2));
		assertFalse(testePrimeiraPlaylist.equals(playlist3));
		assertFalse(playlist2.equals(minhaPlaylist));
		assertTrue(playlist3.equals(playlist2));
		
		Object objetoTeste = new Object();
		assertFalse(minhaPlaylist.equals(objetoTeste));
		assertFalse(testePrimeiraPlaylist.equals(objetoTeste));
		assertFalse(playlist2.equals(objetoTeste));
		assertFalse(playlist3.equals(objetoTeste));
		
	}
	
	@Test
	public void testToString() throws Exception{
		final String FIM_DE_LINHA = System.lineSeparator();
		
		Musica cheiaDeManias = new Musica("Cheia de manias", 4, "Pagode");
		minhaPlaylist.adicionaMusica(cheiaDeManias);
		String comMusicas = "Playlist: \"Pra relaxar\"" + FIM_DE_LINHA + FIM_DE_LINHA + 
							"1) Titulo: Cheia de manias, Duracao: 4 minutos, Genero: Pagode" + FIM_DE_LINHA;
		
		assertEquals(comMusicas, minhaPlaylist.toString());
		
		
	}

}
