package lsg.ptb.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlannedZone extends Zone {

	public static boolean validate(String line){
		boolean matched = false;
		
		Pattern pattern = Pattern.compile("[A-Z]+\\s\\d+:\\d+\\s[a-z]+");
		
		Matcher match = pattern.matcher(line);
		
		if(match.matches()){
			matched = true;
		}
		return matched;
	}
	
	private final String quality;
	
	public PlannedZone(int x, int y,EZoneType type, String quality){
		super(x,y,type);
		this.quality = quality;
	}
	
	public void accept(IRenderVisitor visitor){
		visitor.render(this);
	}
	
	public String toString(){
		return String.format("%s\t%d:%d\t%s", getType(), getLocation().getX(), getLocation().getY(),
				getQuality());
	}
	
	public String getQuality(){
		return quality;
	}
}
