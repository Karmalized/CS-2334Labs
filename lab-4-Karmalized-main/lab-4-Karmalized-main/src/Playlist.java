import java.util.Arrays;

public class Playlist {
	private Song[] songs;
	private int numSongs;
	private static final int MIN_CAPACITY = 3;

	Playlist(){
		songs = new Song[MIN_CAPACITY];
		numSongs = 0;
	}
	
	Playlist(int capacity) {
		if(capacity > MIN_CAPACITY) {
			songs = new Song[capacity];
			numSongs = 0;
		} else {
			songs = new Song[MIN_CAPACITY];
			numSongs = 0;
		}
	}
	
	public int getCapacity() {
		return songs.length;
	}
	
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int index) {
		if(0 <= index && index < songs.length)
			return songs[index];
		else
			return null;
	}
	
	public Song[] getSongs() {
		Song[] copyList = Arrays.copyOf(songs, numSongs);
		return copyList;
	}
	
	public boolean addSong(int index, Song song) {
		if(song != null && index >= 0 && index < numSongs+1 && numSongs != songs.length) {
			for(int i = numSongs-1; i >= index; i--) {
				songs[i+1] = songs[i];
			}
			songs[index] = song;
			numSongs++;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addSong(Song song) {
		if(numSongs != songs.length && song != null) {
			addSong(numSongs, song);
			return true;
		} else {
			return false;
		}
	}
	
	
	public Song removeSong(int index) {
		if(index < 0 || index > numSongs || songs[index] == null) {
			return null;
		} else {
			Song storage = songs[index];
			songs[index] = null;
			for(int i = index; i < songs.length-1; i++) {
				songs[i] = songs[i+1];
			}
			numSongs--;
			return storage;
		}
	}
	
	public Song removeSong() {
		if(numSongs == 0) {
			return null;
		} else {
			return this.removeSong(numSongs-1);
		}
	}
	
	public int addSongs(Playlist playlist) {
		if(playlist == null || playlist.getNumSongs() == 0) {
			return 0;
		} else {
			if(this.getCapacity() < numSongs + playlist.getNumSongs()) {
				int leftoverSpots = this.getCapacity() - this.getNumSongs();
				Song[] copyList = playlist.getSongs();
				for(int i = 0; i < leftoverSpots; i++) {
					this.addSong(copyList[i]);
				}
				return leftoverSpots;
			} else {
			int i = 0;
			Song[] copyList = playlist.getSongs();
			while(i < copyList.length) {
				this.addSong(copyList[i]);
				i++;
			}
			return i;
			}
		}
	}
}
