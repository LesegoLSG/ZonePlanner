package lsg.ptb.file;

import lsg.ptb.model.*;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public final class ZoneFileHandler {
		
	public static ArrayList<Zone> readZones(File zoneFile){
		
		ArrayList<Zone> zones = new ArrayList<>();
		
		Scanner scan = null;
		
		try{
			scan = new Scanner(zoneFile);
			String line;
			
			while(scan.hasNext()){
				line = scan.nextLine();
				
				if(ActiveZone.validate(line)){
					StringTokenizer tokens = new StringTokenizer(line,"\t");
					
					EZoneType type = EZoneType.valueOf(tokens.nextToken());
					
					String loc = tokens.nextToken();
					StringTokenizer locToc = new StringTokenizer(loc, ":");
					int x = Integer.parseInt(locToc.nextToken());
					int y = Integer.parseInt(locToc.nextToken());
					
					String scanClass = tokens.nextToken();
					
					int size = Integer.parseInt(tokens.nextToken());
					zones.add(new ActiveZone(x,y,type,size,scanClass));
				
				}else if(PlannedZone.validate(line)){
					StringTokenizer tokens = new StringTokenizer(line, "\t");
					
					EZoneType type = EZoneType.valueOf(tokens.nextToken());
					
					String loc = tokens.nextToken();
					StringTokenizer locToc = new StringTokenizer(loc,":");
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
