package chapter03;

public class SongApp {
	public static void main(String[] args) {
		Song song = new Song();
		song.setAlbum("Real");
		song.setYear(2010);
		song.setTrack(3);
		song.setComposer("이민수");
		song.setTitle("좋은날");
		song.setArtist("아이유");
		
		song.show();
	}
}
