package Comparators;

import java.util.Comparator;

import sp2fy.Album;

public class NumeroDeFaixasComparator implements Comparator<Album>{

	public int compare(Album album, Album outroAlbum) {
		if(album.numeroDeFaixas() < outroAlbum.numeroDeFaixas()) {
			return -1;
		}
		
		if(album.numeroDeFaixas() > outroAlbum.numeroDeFaixas()) {
			return 1;
		}
		
		return 0;
	}

}
