package sp2fy.album;

import java.util.Comparator;

public class ArtistaComparator implements Comparator<Album>{

	public int compare(Album album, Album outroAlbum) {
		return album.getArtista().compareTo(outroAlbum.getArtista());
	}

}
