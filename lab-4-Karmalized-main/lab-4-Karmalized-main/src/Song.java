import java.util.Arrays;
public class Song {
	private String title;
	private String artist;
	private int[] time;
	
	 Song(String title, String artist, int[] time){
		this.title = title;
		this.artist = artist;
		int[] copyList = Arrays.copyOf(time, time.length);
		this.time = copyList;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
		int[] copyList = Arrays.copyOf(time, time.length);
		return copyList;
	}
}
