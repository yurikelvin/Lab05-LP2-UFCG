package sp2fy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import sp2fy.Album;
import sp2fy.Musica;

public class AlbumTest {
	
	private Album mariliaMendDVD;

	
	@Before
	public void criaAlbum() throws Exception {
		mariliaMendDVD = new Album("Marilia Mendonca", "Marilia Mendonca- Audio DVD", 2015);
		

	}
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testConstrutorWithException() {
		// Test artista vazio/null/ se contem numeros ou caracteres especiais
		try {
			Album testeAlbum = new Album(null, "Teste - DVD", 2016);
			Assert.fail("Lancamento de Exception com nome de artista vazio");
		}catch(Exception e) {
			assertEquals("Artista do album nao pode ser nulo", e.getMessage());
			
		} //
		
		try {
			Album testeAlbum = new Album(" ", "Teste - DVD", 2015);
			Assert.fail("Lancamento de Exception com nome de artista vazio");
		}catch(Exception e) {
			
			assertEquals("Artista do album nao pode ser nulo", e.getMessage());
			
		} //
		
		try {
			Album testeAlbum = new Album("", "Teste - DVD", 2015);
			Assert.fail("Lancamento de Exception com nome de artista vazio");
		}catch(Exception e) {
			assertEquals("Artista do album nao pode ser nulo", e.getMessage());
		} //

		
		// Test titulo nulo/vazio
		
		try {
			Album testeAlbum = new Album("Marilia", null, 2015);
			Assert.fail("Lancamento de Exception com titulo do album vazio");
			
			
		}catch(Exception e) {
			assertEquals("Titulo do album nao deve ser nulo ou vazio", e.getMessage());
			
		} //
		
		try {
			Album testeAlbum = new Album("Mendonca", "", 2015);
			Assert.fail("Lancamento de Exception com titulo do album vazio");
		}catch(Exception e) {
			assertEquals("Titulo do album nao deve ser nulo ou vazio", e.getMessage());
			
		} //
		
		try {
			Album testeAlbum = new Album("Carioca", " ", 2010);
			Assert.fail("Lancamento de Exception com titulo do album vazio");
			
		}catch(Exception e) {
			assertEquals("Titulo do album nao deve ser nulo ou vazio", e.getMessage());

		} //
		
		// Test com ano de lancamento inferior a 1800 e superior a 2016/nulo
		
		try {
			Album testeAlbum = new Album("Carioca", "Agora vai", 1799);
			Assert.fail("Lancamento de Exception com ano de lancamento inferior a 1800");
			
		}catch(Exception e) {
			assertEquals("Ano de lancamento nao deve ser inferior a 1800 ou superior a 2016", e.getMessage());
			
		} //
		
		try {
			Album testeAlbum = new Album("Carioca", "Agora deu", 2017);
			Assert.fail("Lancamento de Exception com ano de lancamento superior a 2016");
			
		}catch(Exception e) {
			
			assertEquals("Ano de lancamento nao deve ser inferior a 1800 ou superior a 2016", e.getMessage());
			
		} //
		
		try {
			Album testeAlbum = new Album("Carioca", "Nao deu", 0);
			Assert.fail("Lancamento de Exception com ano de lancamento nulo");
		}catch(Exception e) {
			assertEquals("Ano de lancamento nao deve ser inferior a 1800 ou superior a 2016", e.getMessage());
		}
	
	}

	@Test
	public void testConstrutorWithExceptionRule() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("Artista do album nao pode ser nulo");
		new Album(null, "Teste", 0);
	}
	
	@Test
	public void testAdicionaMusicaEContem() throws Exception {
		
		Musica infiel = new Musica("Infiel", 3, "Sertanejo");
		Musica comoFazComEla = new Musica("Como faz com ela", 3, "Sertanejo");
		Musica aloPorteiro = new Musica("Alo porteiro", 5, "Sertanejo");
		Musica comoFazComElaPop = new Musica("Como faz com ela", 3, "Pop");
		Musica testeMusica = new Musica("Musica test", 5, "Reggae");

		
		// Test casos corretos
		assertTrue(mariliaMendDVD.adicionaMusica(infiel));
		assertTrue(mariliaMendDVD.adicionaMusica(comoFazComEla));
		assertTrue(mariliaMendDVD.adicionaMusica(aloPorteiro));
		
		// Test casos iguais
		assertTrue(mariliaMendDVD.adicionaMusica(comoFazComElaPop));
		
		// Test contem musica
		assertTrue(mariliaMendDVD.contemMusica("Infiel"));
		assertTrue(mariliaMendDVD.contemMusica("Como faz com ela"));
		assertTrue(mariliaMendDVD.contemMusica("Alo porteiro"));
		assertFalse(mariliaMendDVD.contemMusica("Musica test"));
		
			
	}
	
	@Test
	public void testAdicionaMusicaWithException() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Musica nao pode ser nula");
		// Test casos incorretos de adicao objeto null
		mariliaMendDVD.adicionaMusica(null);
	}
	
	@Test
	public void testContemMusicaWithException() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Titulo da musica invalido");
		// Test casos incorretos de adicao objeto null
		mariliaMendDVD.contemMusica(null);
	}
	
	@Test
	public void testContemMusicaWithException1() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Titulo da musica invalido");
		// Test casos incorretos de adicao objeto null
		mariliaMendDVD.contemMusica(" ");
	}
	
	@Test
	public void testContemMusicaWithException2() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Titulo da musica invalido");
		// Test casos incorretos de adicao objeto null
		mariliaMendDVD.contemMusica("");
	}

	@Test
	public void testRemoveMusica() throws Exception {
		Musica infiel = new Musica("Infiel", 3, "Sertanejo");
		Musica comoFazComEla = new Musica("Como faz com ela", 3, "Sertanejo");
		Musica aloPorteiro = new Musica("Alo porteiro", 5, "Sertanejo");
		
		// Test removendo faixas null/negativos/inexistentes
		assertFalse(mariliaMendDVD.removeMusica(0));
		assertFalse(mariliaMendDVD.removeMusica(-2));
		assertFalse(mariliaMendDVD.removeMusica(3));
		
		//
		
		mariliaMendDVD.adicionaMusica(aloPorteiro);
		mariliaMendDVD.adicionaMusica(comoFazComEla);
		mariliaMendDVD.adicionaMusica(infiel);
		
		// Test removendo faixas validas
		assertTrue(mariliaMendDVD.contemMusica("Alo porteiro"));
		assertTrue(mariliaMendDVD.removeMusica(1));
		assertFalse(mariliaMendDVD.contemMusica("Alo porteiro"));
		assertTrue(mariliaMendDVD.contemMusica("Infiel"));
		assertTrue(mariliaMendDVD.removeMusica(2));
		assertFalse(mariliaMendDVD.contemMusica("Infiel"));
		assertTrue(mariliaMendDVD.contemMusica("Como faz com ela"));
		assertTrue(mariliaMendDVD.removeMusica(1));
		assertFalse(mariliaMendDVD.contemMusica("Como faz com ela"));
		
		// Test
		assertFalse(mariliaMendDVD.removeMusica(0));
		
	}
	
	
	@Test
	public void testRemoveMusicaWithException() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Faixa invalida");
		mariliaMendDVD.removeMusica(-2);
	}
	
	@Test
	public void testGetMusica() throws Exception {
		Musica oQueFalta = new Musica("O que falta em voce sou eu", 4, "Sertanejo");
		Musica aloPorteiro = new Musica("Alo porteiro", 5, "Sertanejo");
		mariliaMendDVD.adicionaMusica(oQueFalta);
		mariliaMendDVD.adicionaMusica(aloPorteiro);
		
		// Test pegando musicas null/vazio/nao existe
		assertEquals(null, mariliaMendDVD.getMusica("nem sei"));
		assertEquals(null, mariliaMendDVD.getMusica(null));
		assertEquals(null, mariliaMendDVD.getMusica(""));
		assertEquals(null, mariliaMendDVD.getMusica(" "));
		
		// Test pegando musicas validas
		assertEquals(oQueFalta, mariliaMendDVD.getMusica("O que falta em voce sou eu"));
		assertEquals(aloPorteiro, mariliaMendDVD.getMusica("Alo porteiro"));
		
	}
	
	@Test
	public void testGetDuracaoTotal() throws Exception{
		// Test duracao total das faixas do album
		Musica musicaTeste = new Musica("musica teste", 5, "Pop");
		Musica novaMusicaTest = new Musica("musica tensa", 15, "Reggae");
		mariliaMendDVD.adicionaMusica(musicaTeste);
		assertEquals(5, mariliaMendDVD.getDuracaoTotal());
		mariliaMendDVD.adicionaMusica(novaMusicaTest);
		assertEquals(20, mariliaMendDVD.getDuracaoTotal());
		
		
	}
	
	@Test
	public void testNumeroDeFaixas() throws Exception{
		// Test numero de faixas adicionando musicas iguais e diferentes
		Musica faixa1 = new Musica("test faixa1", 1, "pop");
		mariliaMendDVD.adicionaMusica(faixa1);
		assertEquals(1, mariliaMendDVD.numeroDeFaixas());
		Musica faixa2 = new Musica("test faixa2", 50, "test");
		mariliaMendDVD.adicionaMusica(faixa2);
		assertEquals(2, mariliaMendDVD.numeroDeFaixas());
		Musica faixa3 = new Musica("test faixa3", 25, "test");
		mariliaMendDVD.adicionaMusica(faixa3);
		Musica faixa4 = new Musica("test faixa1", 1, "pop");
		mariliaMendDVD.adicionaMusica(faixa4);
		assertEquals(4, mariliaMendDVD.numeroDeFaixas());
		
		
		
	}
	
	@Test
	public void testHashCode() throws Exception{
		Album copiaMarilia = new Album("Marilia Mendonca", "Marilia Mendonca- Audio DVD", 1988);
		assertEquals(mariliaMendDVD.hashCode(), copiaMarilia.hashCode());
		Album novoTeste = new Album("Bruno mars", "Bruno mars- DVD", 2015);
		assertNotEquals(mariliaMendDVD.hashCode(), novoTeste.hashCode());
		assertNotEquals(copiaMarilia.hashCode(), novoTeste.hashCode());
		Album novaMarilia = new Album("Marilia Mendonca", "Marilia Mendonca- Audio DVD", 2015);
		assertEquals(mariliaMendDVD.hashCode(), novaMarilia.hashCode());
		assertEquals(mariliaMendDVD.hashCode(), mariliaMendDVD.hashCode());
	}
	
	@Test
	public void testEquals() throws Exception{
		Album copiaMarilia = new Album("Marilia Mendonca", "Marilia Mendonca- Audio DVD", 1988);
		Album novaMarilia = new Album("Marilia Mendonca", "Marilia Mendonca- Audio DVD", 2015);
		assertTrue(mariliaMendDVD.equals(copiaMarilia));
		assertTrue(mariliaMendDVD.equals(mariliaMendDVD));
		assertTrue(mariliaMendDVD.equals(novaMarilia));
		
	}
	
	@Test
	public void testNotEquals() throws Exception{
		Album novoTeste = new Album("Bruno mars", "Bruno mars- DVD", 2015);
		assertFalse(mariliaMendDVD.equals(null));
		assertFalse(mariliaMendDVD.equals(novoTeste));
		Object objetoTeste = new Object();
		assertFalse(mariliaMendDVD.equals(objetoTeste));
		assertFalse(mariliaMendDVD.equals("ola"));
		
	}
	
	@Test
	public void testToString() throws Exception{
		final String FIM_DE_LINHA = System.lineSeparator();
		
		String toStringCore = "Artista: Marilia Mendonca"  + FIM_DE_LINHA +
					 "Titulo do album: Marilia Mendonca- Audio DVD" + FIM_DE_LINHA +
					 "Ano de Lancamento: 2015" + FIM_DE_LINHA;
		// Testando sem musicas adicionadas
		String semMusica = toStringCore + FIM_DE_LINHA + "Album Marilia Mendonca- Audio DVD sem musicas adicionadas";
		assertEquals(semMusica, mariliaMendDVD.toString());
		
		// Testando com musicas adicionais
		
		Musica newMusic = new Musica("Teste", 5, "Reggae");
		mariliaMendDVD.adicionaMusica(newMusic);
		String comMusica = toStringCore + FIM_DE_LINHA +
							"Faixa 1) " + "Titulo: Teste, Duracao: 5 minutos, Genero: Reggae" + FIM_DE_LINHA;
		assertEquals(comMusica, mariliaMendDVD.toString());
		
	}

	@Test
	public void testCompareTo() throws Exception {
		Album testeAlbum = new Album("Album teste", "teste", 2016);
		assertEquals(-1, mariliaMendDVD.compareTo(testeAlbum));
		assertEquals(1, testeAlbum.compareTo(mariliaMendDVD));
		Album outroTeste = new Album("Album teste", "diferente", 2015);
		assertEquals(0, mariliaMendDVD.compareTo(outroTeste));
	}
}


