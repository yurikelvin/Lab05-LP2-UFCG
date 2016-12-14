package Comparators;

import java.util.Comparator;

import sp2fy.Album;

public class ArtistaComparator implements Comparator<Album>{

	public int compare(Album album, Album outroAlbum) {
		return album.getArtista().compareTo(outroAlbum.getArtista());
	}

}
