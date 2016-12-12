package sp2fy.musica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sp2fy.musica.Musica;

public class MusicaTest {
	
	private Musica music;
	
	@Before
	public void criaMusica() throws Exception{
		music = new Musica("Bethoven", 50, "Opera");
	}
	
	@Test
	public void testConstrutorWithException() {
		// testa titulo da musica vazio/null/menor que 2 caracteres
		try {
			Musica musi1 = new Musica(" ", 50, "Opera");
			Assert.fail("Lancamento de Exception com titulo da musica vazio");
		}catch(Exception e) {
			assertEquals("Titulo da musica nao pode ser nulo e deve contar no minimo 2 caracteres", e.getMessage());
		}
		
		try {
			Musica musi1 = new Musica(null, 50, "Opera");
			Assert.fail("Lancamento de Exception com titulo da musica vazio");
			
		}catch(Exception e) {
			assertEquals("Titulo da musica nao pode ser nulo e deve contar no minimo 2 caracteres", e.getMessage());
			
		} 
		
		try {
			Musica musi1 = new Musica("1", 15, "Opera");
			Assert.fail("Lancamento de Exception com titulo da musica menor que dois caracteres");
			
		}catch(Exception e) {
			assertEquals("Titulo da musica nao pode ser nulo e deve contar no minimo 2 caracteres", e.getMessage());
			
		} 
		
		try {
			Musica musi1 = new Musica("", 15, "Opera");
			Assert.fail("Lancamento de Exception com titulo da musica menor que dois caracteres");
			
		}catch(Exception e) {
			assertEquals("Titulo da musica nao pode ser nulo e deve contar no minimo 2 caracteres", e.getMessage());
		}
		
		// testa musica com duracao negativa/nula
		try {
			Musica musi1 = new Musica("Bethoven", -50, "Opera");
			Assert.fail("Lancamento de Exception com duracao da musica negativa");
		}catch(Exception e) {
			assertEquals("Duracao da musica nao pode ser nulo ou negativo", e.getMessage());
		}
		
		try {
			Musica musi1 = new Musica("Bethoven", 0, "Opera");
			Assert.fail("Lancamento de Exception com duracao da musica nula");
			
		}catch(Exception e) {
			assertEquals("Duracao da musica nao pode ser nulo ou negativo", e.getMessage());
		}//
		
		// testa genero da musica nulo ou contendo algo diferente de letras
		try {
			Musica musi1 = new Musica("Bethoven", 50, null);
			Assert.fail("Lancamento de Exception, genero da musica nulo");
		}catch(Exception e) {
			assertEquals("Genero da musica nao pode ser nulo e o tamanho minimo para genero eh 2", e.getMessage());
		} //
		
		try {
			Musica musi1 = new Musica("24K Magic", 15, "!Opera");
			Assert.fail("Lancamento de Exception, genero da musica com caracteres invalidos");
			
		}catch(Exception e) {
			assertEquals("Genero da musica nao pode conter numeros ou caracteres especiais", e.getMessage());
			
		} //
		
		try {
			Musica musi1 = new Musica("Teste", 15, "");
			Assert.fail("Lancamento de Exception, genero da musica nulo");
		}catch(Exception e) {
			assertEquals("Genero da musica nao pode ser nulo e o tamanho minimo para genero eh 2", e.getMessage());
			
		} //
		
		try {
			Musica musi1 = new Musica("Teste", 15, "Opera1 Ola");
			Assert.fail("Lancamento de Exception, genero da musica contem numeros ou caracteres especiais");
		}catch(Exception e) {
			assertEquals("Genero da musica nao pode conter numeros ou caracteres especiais", e.getMessage());
			
		}
		
		try {
			Musica musi1 = new Musica("Teste", 15, "Oper@cao baba");
		}catch(Exception e) {
			assertEquals("Genero da musica nao pode conter numeros ou caracteres especiais", e.getMessage());
		}
	}
	
	@Test
	public void testHashCode() throws Exception {
		Musica musica1 = new Musica("Bethoven", 50, "Opera");
		assertEquals(musica1.hashCode(), music.hashCode());
		Musica musica2 = new Musica("Bethoven", 50, "Galego");
		assertEquals(music.hashCode(), musica2.hashCode());
		Musica musica3 = new Musica("Teste", 50, "Opera");
		assertNotEquals(music.hashCode(), musica3.hashCode());
		assertNotEquals(musica3.hashCode(), musica2.hashCode());
		Musica musica4 = new Musica("Bethoven", 49, "Opera");
		assertNotEquals(music.hashCode(), musica4.hashCode());
		assertNotEquals(musica1.hashCode(), musica4.hashCode());
		assertNotEquals(musica2.hashCode(), musica4.hashCode());
	}
	
	@Test
	public void testEquals() throws Exception{
		// testa se dois objetos sao iguais comparando titulo e duracao
		Musica musi1 = new Musica("Teste", 15, "Opera");
		Musica musi2 = new Musica("Bethoven", 50, "Rap");
		assertTrue(music.equals(musi2));
		Musica musi4 = new Musica("Teste", 15, "Opera");
		assertTrue(musi1.equals(musi4));
		Musica musi5 = new Musica("Teste", 15, "Tango");
		assertTrue(musi1.equals(musi5));
		assertTrue(musi4.equals(musi5));
	}
	
	@Test
	public void testNotEquals() throws Exception {
		Musica musi1 = new Musica("Teste", 15, "Opera");
		assertFalse(music.equals(musi1));
		Musica musi2 = new Musica("Bethoven", 50, "Rap");
		assertFalse(musi1.equals(musi2));
		Musica musi3 = new Musica("Bethove", 49, "Rap");
		assertFalse(music.equals(musi3));
	}
	
	@Test
	public void testToString() {
		assertEquals("Titulo: Bethoven, Duracao: 50 minutos, Genero: Opera", music.toString());
	}

}
