package Comparators;

/** 
 * Código desenvolvido para o lab05 de LP2-computacao@ufcg 2016.2
 * Yuri Silva - 116110057
 */


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Comparators.NumeroDeFaixasComparator;
import sp2fy.Album;
import sp2fy.Musica;

public class NumeroDeFaixasComparatorTest {

	private NumeroDeFaixasComparator comparator;
	
	@Before
	public void criaNumeroDeFaixas(){
		comparator = new NumeroDeFaixasComparator();
	}
	
	@Test
	public void testCompare() throws Exception{
		Album a = new Album("Ate", "ako", 2014);
		Album b = new Album("bete", "kao", 2013);
		
		a.adicionaMusica(new Musica("Teste", 50, "Longa musica"));
		a.adicionaMusica(new Musica("vamos la", 15, "Teste comparator"));
		
		b.adicionaMusica(new Musica("musica de b", 10, "Teste"));
		
		assertEquals(1, comparator.compare(a, b));
		assertEquals(-1, comparator.compare(b, a));
		
		Album c = new Album("album de teste", "koqp", 2010);
		
		c.adicionaMusica(new Musica("Musica de c", 15, "Testk"));
		assertEquals(0, comparator.compare(b, c));
		assertEquals(0, comparator.compare(c,b));
	}

}
