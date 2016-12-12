package sp2fy.musiteca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import sp2fy.album.Album;

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
		assertTrue(minhaMusitecaTest.adicionaAlbumFavorito(brunoTest));
		assertFalse(minhaMusitecaTest.adicionaAlbumFavorito(null));
		
		
	}
	
	@Test
	public void testRemoveAlbum() throws Exception {
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		assertTrue(minhaMusitecaTest.adicionaAlbum(brunoTest));
		assertTrue(minhaMusitecaTest.removeAlbum("Bruno Mars", "I know you"));
		assertTrue(minhaMusitecaTest.adicionaAlbum(brunoTest));
		Album brunoMarrone = new Album("Bruno e Marrone", "Seu guarda", 2004);
		assertTrue(minhaMusitecaTest.adicionaAlbum(brunoMarrone));
		assertTrue(minhaMusitecaTest.removeAlbum("Bruno e Marrone", "Seu guarda"));
		
	}
	
	@Test
	public void testNotRemoveAlbum() throws Exception {
		assertFalse(minhaMusitecaTest.removeAlbum("Teste", "Testando"));
		assertFalse(minhaMusitecaTest.removeAlbum("Ola", "como vai"));
		assertFalse(minhaMusitecaTest.removeAlbum("TesteUm", "TestandoDois"));
	}
	
	@Test
	public void testRemoveAlbumFavorito() throws Exception {
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		assertTrue(minhaMusitecaTest.adicionaAlbumFavorito(brunoTest));
		assertTrue(minhaMusitecaTest.pesquisaAlbumFavorito("Bruno Mars", "I know you"));
		assertTrue(minhaMusitecaTest.removeAlbumFavorito("Bruno Mars", "I know you"));
		assertTrue(minhaMusitecaTest.adicionaAlbumFavorito(brunoTest));
		Album brunoMarrone = new Album("Bruno e Marrone", "Seu guarda", 2004);
		assertTrue(minhaMusitecaTest.adicionaAlbumFavorito(brunoMarrone));
		assertTrue(minhaMusitecaTest.removeAlbumFavorito("Bruno e Marrone", "Seu guarda"));
		
	}
	
	@Test
	public void testNotRemoveAlbumFavorito() throws Exception {
		assertFalse(minhaMusitecaTest.removeAlbumFavorito("Teste", "Testando"));
		assertFalse(minhaMusitecaTest.removeAlbumFavorito("Ola", "como vai"));
		assertFalse(minhaMusitecaTest.removeAlbumFavorito("TesteUm", "TestandoDois"));
	}
	
	@Test
	public void testRemoveAlbumWithException1() throws Exception {
		// Test nome de artista null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbum(null, "teste");
	}
	
	@Test
	public void testRemoveAlbumWithException2() throws Exception {
		// Test nome de artista invalido
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbum("Marc1nha", "teste");
	}
	
	@Test
	public void testRemoveAlbumWithException3() throws Exception {
		// Test nome de artista invalido
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbum("12345", "teste");
	}
	
	@Test
	public void testRemoveAlbumWithException4() throws Exception {
		// Test nome do titulo null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbum("Marcinha", null);
	}
	
	@Test
	public void testRemoveAlbumWithException5() throws Exception {
		// Test nome do titulo invalido
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbum("Marc1nha", "1");
	}
	
	public void testRemoveAlbumFavoritoWithException1() throws Exception {
		// Test nome de artista null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbumFavorito(null, "teste");
	}

	@Test
	public void testRemoveAlbumFavoritoWithException2() throws Exception {
		// Test nome de artista invalido
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbumFavorito("Marc1nha", "teste");
	}
	
	@Test
	public void testRemoveAlbumFavoritoWithException3() throws Exception {
		// Test nome de artista invalido
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbumFavorito("12345", "teste");
	}
	
	@Test
	public void testRemoveAlbumFavoritoWithException4() throws Exception {
		// Test nome do titulo null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbumFavorito("Marcinha", null);
	}
	
	@Test
	public void testRemoveAlbumFavoritoWithException5() throws Exception {
		// Test nome do titulo invalido
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.removeAlbumFavorito("Marc1nha", "1");
	}

	@Test
	public void testPesquisaAlbum() throws Exception {
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		minhaMusitecaTest.adicionaAlbum(brunoTest);
		assertTrue(minhaMusitecaTest.pesquisaAlbum("Bruno Mars", "I know you"));
		
	}
	
	@Test
	public void testPesquisaAlbumFavorito() throws Exception {
		Album brunoTest = new Album("Bruno Mars", "I know you", 1967);
		minhaMusitecaTest.adicionaAlbumFavorito(brunoTest);
		assertTrue(minhaMusitecaTest.pesquisaAlbumFavorito("Bruno Mars", "I know you"));
	}
	
	@Test
	public void testNotPesquisaAlbum() throws Exception {
		assertFalse(minhaMusitecaTest.pesquisaAlbum("Nemo", "onde esta voce"));
		assertFalse(minhaMusitecaTest.pesquisaAlbum("dori", "procurando dori"));
		
	}
	
	@Test
	public void testNotPesquisaAlbumFavorito() throws Exception {
		assertFalse(minhaMusitecaTest.pesquisaAlbumFavorito("Nemo", "onde esta voce"));
		assertFalse(minhaMusitecaTest.pesquisaAlbumFavorito("dori", "procurando dori"));
		
	}
	
	@Test
	public void testPesquisaAlbumWithException() throws Exception {
		
		// Test nome de artista null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.pesquisaAlbum(null, "teste");
		
	}
	
	@Test
	public void testPesquisaAlbumWithException1() throws Exception {
		
			// Test nome de artista invalido
			exception.expect(Exception.class);
			exception.expectMessage("Nome do album ou artista invalido");
			minhaMusitecaTest.pesquisaAlbum("t12", "teste");
		
	}
	
	@Test
	public void testPesquisaAlbumWithException2() throws Exception {
		
			// Test titulo null
			exception.expect(Exception.class);
			exception.expectMessage("Nome do album ou artista invalido");
			minhaMusitecaTest.pesquisaAlbum("Miranda", null);
		
	}
	
	@Test
	public void testPesquisaAlbumFavoritoWithException() throws Exception {
		
		// Test nome de artista null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.pesquisaAlbumFavorito(null, "teste");
		
	}
	
	@Test
	public void testPesquisaAlbumFavoritoWithException1() throws Exception {
		
		// Test nome de artista invalido
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.pesquisaAlbumFavorito("k54", "teste");
		
	}
	
	@Test
	public void testPesquisaAlbumFavoritoWithException2() throws Exception {
		
		// Test titulo null
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.pesquisaAlbumFavorito("Madrana", null);
		
	}
	
	@Test
	public void testPesquisaAlbumFavoritoWithException3() throws Exception {
		
		// Test titulo invalido
		exception.expect(Exception.class);
		exception.expectMessage("Nome do album ou artista invalido");
		minhaMusitecaTest.pesquisaAlbumFavorito("Madrana", "t");
		
	}
	
	
}
