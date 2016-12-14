package Comparators;

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
