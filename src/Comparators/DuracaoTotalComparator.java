package Comparators;

/** 
 * Código desenvolvido para o lab05 de LP2-computacao@ufcg 2016.2
 * Yuri Silva - 116110057
 */


import java.util.Comparator;

import sp2fy.Album;

public class DuracaoTotalComparator implements Comparator<Album>{

	public int compare(Album album, Album outroAlbum) {
		if (album.getDuracaoTotal() < outroAlbum.getDuracaoTotal()) {
			return -1;
		}
		if (album.getDuracaoTotal() > outroAlbum.getDuracaoTotal()) {
			return 1;
		}
		return 0;
	}

}
