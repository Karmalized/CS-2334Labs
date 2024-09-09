import java.util.Scanner;
import java.io.*;
public class Convert {

	public static void convertFile(String filename) {
		try {
		File f = new File(filename);
		Scanner fileReader = new Scanner(f);
		
		String latitude;
		String longitude;
		
		File excel = new File("triplog.csv");
		if(!excel.exists()) {
		excel.createNewFile();
		}
		FileWriter typer = new FileWriter("triplog.csv");
		PrintWriter writer = new PrintWriter(typer);
		int time = 0;
		writer.println("Time,Latitude,Longitude");
		fileReader.nextLine();
		fileReader.nextLine();
		fileReader.nextLine();
		while(fileReader.hasNextLine()) {
			String saver = fileReader.nextLine();
			if(saver.length() > 10) {
				saver.strip();
				saver.trim();
				saver.replaceAll("\\s", "");
				saver.replaceAll("\\?", "");
				saver = saver.replaceAll("[^0-9.-]","");
				StringBuffer adder = new StringBuffer(saver);
				if(!saver.isEmpty()) {
					latitude = saver.substring(0, saver.indexOf('-'));
					longitude = saver.substring(saver.indexOf('-'), saver.length());
				
				String gpsCheckpoint = time + "," + latitude + "," + longitude;
				
				writer.println(gpsCheckpoint);
				time = time + 5;
				}
			}
		}
		
		writer.flush();
		writer.close();
		fileReader.close();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}
	
}
