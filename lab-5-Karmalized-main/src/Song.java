import java.util.Arrays;

public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	private static final String INFO_DELIMITER = ";";
	private static final String TIME_DELIMITER = ":";
	private static final int IDX_TITLE = 0;
	private static final int IDX_ARTIST = 1;
	private static final int IDX_TIME = 2;
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
	}
	
	public Song(String info) {
		String[] metaData = info.split(INFO_DELIMITER);
		this.title = metaData[IDX_TITLE].trim();
		this.artist = metaData[IDX_ARTIST].trim();
		String[] timeParser = metaData[IDX_TIME].split(TIME_DELIMITER);
		time = new int[timeParser.length];
		int i = time.length-1;
		for(String timePiece : timeParser) {
			String cleaner = timePiece.trim();
			time[i] = Integer.parseInt(cleaner);
			i--;
			
		}
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
		return Arrays.copyOf(time, time.length);
	}
	
	public String toString() {
		String formatTime = "";
		if(time.length == 1)
			formatTime = Integer.toString(time[0]);
		if(time.length == 2)
			formatTime = Integer.toString(time[1]) + ":" + String.format("%02d",time[0]);
		if(time.length == 3)
			formatTime = Integer.toString(time[2]) + ":" + String.format("%02d",(time[1])) + ":" + String.format("%02d", (time[0]));
		
		return title + "; " + artist + "; " + formatTime;
	}
}
