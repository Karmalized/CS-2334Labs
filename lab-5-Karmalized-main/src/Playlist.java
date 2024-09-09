import java.util.ArrayList;
import java.io.*;
public class Playlist {
	
	private ArrayList<Song> songs;
	
	public Playlist() {
		songs = new ArrayList<Song>();
	}
	
	public Playlist(String filename) {
		this();
		this.addSongs(filename);
	}
	
	public int getNumSongs() {
		return songs.size();
	}
	
	public Song getSong(int index) {
		if (index < 0 || index >= getNumSongs()) {
			return null;
		}
		return songs.get(index);
	}
	
	public Song[] getSongs() {
		return songs.toArray(new Song[0]);
	}
	
	public boolean addSong(Song song) {
		return addSong(getNumSongs(), song);
	}
	
	public boolean addSong(int index, Song song) {
		if(song == null || index < 0 || index > getNumSongs()) {
			return false;
		} else {
			songs.add(index, song);
			return true;
		}
	}
	
	public int addSongs(Playlist playlist) {
		ArrayList<Song> copyList = new ArrayList<Song>();
		if(playlist == null) {
			return 0;
		} else {
			copyList = playlist.songs;
			int added = playlist.songs.size();
			songs.addAll(copyList);
			return added;
			}
		}
	
	public int addSongs(String filename) {
		int counter = 0;
		try {
		BufferedReader fileReader = new BufferedReader(new FileReader(filename));
		while(fileReader.ready()) {
			songs.add(getNumSongs(), new Song(fileReader.readLine()));
			counter++;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return counter;
	}
	
	public Song removeSong() {
		return removeSong(getNumSongs() - 1);
	}
	
	public Song removeSong(int index) {
		if(index >= 0 && index < getNumSongs())
			return songs.remove(index);
		else
			return null;
	}
	
	public String toString() {
		String playlistData = "";
		int counter = 0;
		while(counter != getNumSongs()) {
			playlistData = playlistData + songs.get(counter);
			counter++;
			if(counter < getNumSongs())
				playlistData = playlistData + System.lineSeparator();
		}
		return playlistData;
	}
	
	public void saveSongs(String filename) {
		try {
			BufferedWriter songWriter = new BufferedWriter(new FileWriter(filename));
			songWriter.write(toString());
			songWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int[] getTotalTime() {
		int[] timeStash;
		int[] finalTime = {0};
		int seconds = 0;
		int minutes = 0;
		int hours = 0;
		for(int i = 0; i < getNumSongs(); i++) {
			timeStash = songs.get(i).getTime();
			for(int j = 0; j < timeStash.length; j++) {
				if(j == 0)
					seconds = seconds + timeStash[j];
				if(j == 1)
					minutes = minutes + timeStash[j];
				if(j == 2)
					hours = hours + timeStash[j];
			}
		}
		minutes = minutes + (seconds/60);
		hours = hours + (minutes/60);
		seconds = seconds % 60;
		minutes = minutes % 60;
		
		if(hours > 0) {
			finalTime = new int[3];
			finalTime[2] = hours;
			finalTime[1] = minutes;
			finalTime[0] = seconds;
			return finalTime;
		}
		if(minutes > 0) {
			finalTime = new int[2];
			finalTime[1] = minutes;
			finalTime[0] = seconds;
			return finalTime;
		}
		if(seconds > 0) {
			finalTime = new int[1];
			finalTime[0] = seconds;
			return finalTime;
		}
		return finalTime;
	}
}
