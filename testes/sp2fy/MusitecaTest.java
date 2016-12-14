package sp2fy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import sp2fy.Album;
import sp2fy.Musica;
import sp2fy.Musiteca;

public class MusitecaTest {
	
	
	private Musiteca minhaMusitecaTest;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void criaMusiteca() {
		minhaMusitecaTest = new Musiteca();
		
	}
	
	@Test
	public void testAdicionaAlbum() throws Exception{
		
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		assertTrue(minhaMusitecaTest.adicionaAlbum(brunoTest));
		assertFalse(minhaMusitecaTest.adicionaAlbum(null));
		
		
	}
	
	@Test
	public void testAdicionaAlbumFavorito() throws Exception{
		
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		assertFalse(minhaMusitecaTest.adicionaAlbumFavorito(brunoTest));
		assertFalse(minhaMusitecaTest.adicionaAlbumFavorito(null));
		
		minhaMusitecaTest.adicionaAlbum(brunoTest);
		assertTrue(minhaMusitecaTest.adicionaAlbumFavorito(brunoTest));
		
		
	}
	
	@Test
	public void testRemoveAlbum() throws Exception {
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		assertTrue(minhaMusitecaTest.adicionaAlbum(brunoTest));
		assertTrue(minhaMusitecaTest.removeAlbum("I know you"));
		assertTrue(minhaMusitecaTest.adicionaAlbum(brunoTest));
		Album brunoMarrone = new Album("Bruno e Marrone", "Seu guarda", 2004);
		assertTrue(minhaMusitecaTest.adicionaAlbum(brunoMarrone));
		assertTrue(minhaMusitecaTest.removeAlbum("Seu guarda"));
		
	}
	
	@Test
	public void testNotRemoveAlbum() throws Exception {
		assertFalse(minhaMusitecaTest.removeAlbum("Testando"));
		assertFalse(minhaMusitecaTest.removeAlbum("como vai"));
		assertFalse(minhaMusitecaTest.removeAlbum("TestandoDois"));
	}
	
	@Test
	public void testRemoveAlbumFavorito() throws Exception {
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		minhaMusitecaTest.adicionaAlbum(brunoTest);
		assertTrue(minhaMusitecaTest.adicionaAlbumFavorito(brunoTest));
		assertTrue(minhaMusitecaTest.pesquisaAlbumFavorito("I know you"));
		assertTrue(minhaMusitecaTest.removeAlbumFavorito("I know you"));
		assertTrue(minhaMusitecaTest.adicionaAlbumFavorito(brunoTest));
		Album brunoMarrone = new Album("Bruno e Marrone", "Seu guarda", 2004);
		minhaMusitecaTest.adicionaAlbum(brunoMarrone);
		assertTrue(minhaMusitecaTest.adicionaAlbumFavorito(brunoMarrone));
		assertTrue(minhaMusitecaTest.removeAlbumFavorito("Seu guarda"));
		
	}
	
	@Test
	public void testNotRemoveAlbumFavorito() throws Exception {
		assertFalse(minhaMusitecaTest.removeAlbumFavorito("Testando"));
		assertFalse(minhaMusitecaTest.removeAlbumFavorito("como vai"));
		assertFalse(minhaMusitecaTest.removeAlbumFavorito("TestandoDois"));
	}

	@Test
	public void testRemoveAlbumWithException() throws Exception {
		// Test nome do titulo null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album invalido");
		minhaMusitecaTest.removeAlbum(null);
	}
	
	@Test
	public void testRemoveAlbumWithException1() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album invalido");
		minhaMusitecaTest.removeAlbum("");
	}
	
	@Test
	public void testRemoveAlbumWithException2() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album invalido");
		minhaMusitecaTest.removeAlbum(" ");
	}

	@Test
	public void testRemoveAlbumFavoritoWithException() throws Exception {
		// Test nome do titulo null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album invalido");
		minhaMusitecaTest.removeAlbumFavorito(null);
	}
	
	@Test
	public void testRemoveAlbumFavoritoWithException1() throws Exception {
		// Test nome do titulo null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album invalido");
		minhaMusitecaTest.removeAlbumFavorito("");
	}
	
	@Test
	public void testRemoveAlbumFavoritoWithException2() throws Exception {
		// Test nome do titulo null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album invalido");
		minhaMusitecaTest.removeAlbumFavorito(" ");
	}

	@Test
	public void testPesquisaAlbum() throws Exception {
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		minhaMusitecaTest.adicionaAlbum(brunoTest);
		assertTrue(minhaMusitecaTest.pesquisaAlbum("I know you"));
		
	}
	
	@Test
	public void testPesquisaAlbumFavorito() throws Exception {
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		minhaMusitecaTest.adicionaAlbum(brunoTest);
		minhaMusitecaTest.adicionaAlbumFavorito(brunoTest);
		assertTrue(minhaMusitecaTest.pesquisaAlbumFavorito("I know you"));
	}
	
	@Test
	public void testNotPesquisaAlbum() throws Exception {
		assertFalse(minhaMusitecaTest.pesquisaAlbum("onde esta voce"));
		assertFalse(minhaMusitecaTest.pesquisaAlbum("procurando dori"));
		
	}
	
	@Test
	public void testNotPesquisaAlbumFavorito() throws Exception {
		assertFalse(minhaMusitecaTest.pesquisaAlbumFavorito("onde esta voce"));
		assertFalse(minhaMusitecaTest.pesquisaAlbumFavorito("procurando dori"));
		
	}
	
	@Test
	public void testPesquisaAlbumWithException() throws Exception {
		
			// Test titulo null
			exception.expect(Exception.class);
			exception.expectMessage("Nome do album invalido");
			minhaMusitecaTest.pesquisaAlbum(null);
		
	}
	
	@Test
	public void testPesquisaAlbumFavoritoWithException() throws Exception {
		
		// Test titulo null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album invalido");
		minhaMusitecaTest.pesquisaAlbumFavorito(null);
		
	}
	
	@Test
	public void testAdicionaPlaylist() throws Exception {
		Album albumTest = new Album("Bruno Mars", "I know you", 1988);
		albumTest.adicionaMusica(new Musica("Musica dahora", 5, "Qualquer um"));
		albumTest.adicionaMusica(new Musica("Musica teste", 10 ,"Esse aeh"));
		minhaMusitecaTest.adicionaAlbum(albumTest);
		assertTrue(minhaMusitecaTest.adicionaPlaylist("pra curtir", "I know you", 1));
		assertTrue(minhaMusitecaTest.adicionaPlaylist("pra curtir", "I know you", 2));
		
		
	}
	
	@Test
	public void testRemovePlaylist() throws Exception {
		Album albumTest = new Album("Bruno Mars", "I know you", 1988);
		albumTest.adicionaMusica(new Musica("Musica dahora", 5, "Qualquer um"));
		albumTest.adicionaMusica(new Musica("Musica teste", 10 ,"Esse aeh"));
		minhaMusitecaTest.adicionaAlbum(albumTest);
		minhaMusitecaTest.adicionaPlaylist("pra curtir", "I know you", 1);
		minhaMusitecaTest.adicionaPlaylist("pra curtir", "I know you", 2);
		assertTrue(minhaMusitecaTest.removePlaylist("pra curtir"));
	}	
	
	@Test
	public void testNotRemovedPlaylist() throws Exception {

		assertFalse(minhaMusitecaTest.removePlaylist("dormir"));
		
	}


}
