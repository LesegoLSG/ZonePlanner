package lsg.ptb.file;

import lsg.ptb.model.*;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
	/**
	 * Class ZoneFileHandler reads data from files
	 * @author Mhlongo L
	 *
	 */
public final class ZoneFileHandler {
		
	/**
	 * Method takes a file and reads it then returns the zone from the reading
	 * @param zoneFile, instance of a file to read from
	 * @return Zone after reading the files
	 */
	public static ArrayList<Zone> readZones(File zoneFile){
		
		//Creating an instance of Zone
		ArrayList<Zone> zones = new ArrayList<>();
		
		//instantiating a scan to retrieve data
		Scanner scan = null;
		
		try{
			scan = new Scanner(zoneFile);
			String line;
			
			while(scan.hasNext()){
				line = scan.nextLine();
				
				if(ActiveZone.validate(line)){
					StringTokenizer tokens = new StringTokenizer(line, "\t");
					
					EZoneType type = EZoneType.valueOf(tokens.nextToken());
					
					String loc = tokens.nextToken();
					//creating a space as a dilemitor
					StringTokenizer locToc = new StringTokenizer(loc, ": ");
					int x = Integer.parseInt(locToc.nextToken());
					int y = Integer.parseInt(locToc.nextToken());
					
					String scanClass = tokens.nextToken();
					
					int size = Integer.parseInt(tokens.nextToken());
					zones.add(new ActiveZone(x,y,type,size,scanClass));
				
				}else if(PlannedZone.validate(line)){
					StringTokenizer tokens = new StringTokenizer(line, "\t");
					
					EZoneType type = EZoneType.valueOf(tokens.nextToken());
					
					String loc = tokens.nextToken();
					//creating a space as a dilemitor
					StringTokenizer locToc = new StringTokenizer(loc, ": ");
					int x = Integer.parseInt(locToc.nextToken());
					int y = Integer.parseInt(locToc.nextToken());
					
					String scale = tokens.nextToken();
					
					zones.add(new PlannedZone(x,y,type,scale));
				}else{
					System.out.println("Invalid Entry!");
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("File is not found");
		}finally{
			if(scan != null){
				scan.close();
			}
		}
		return zones;
	}
	
}
