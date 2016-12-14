package sp2fy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import sp2fy.Album;
import sp2fy.DuracaoTotalComparator;
import sp2fy.Musica;

public class DuracaoTotalComparatorTest {

	private DuracaoTotalComparator comparator;
	
	@Before
	public void criaDuracaoTotal(){
		comparator = new DuracaoTotalComparator();
	
	}
	
	@Test
	public void testCompare() throws Exception{
		Album a = new Album("Ate", "ako", 2014);
		Album b = new Album("bete", "kao", 2013);
		
		a.adicionaMusica(new Musica("Teste", 50, "Longa musica"));
		
		assertEquals(1, comparator.compare(a, b));
		
		Album c = new Album("Teste", "kap", 2010);
		
		assertEquals(0, comparator.compare(b, c));
		assertEquals(-1, comparator.compare(b, a));
		
		
		
	}

}
