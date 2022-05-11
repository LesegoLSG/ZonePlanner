package lsg.ptb.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class read the pattern and matches it.
 * @author Mhlongo L
 *
 */
public class PlannedZone extends Zone {
	/**
	 * Validate data from file
	 * @param line, string from file and matches with the pattern
	 * @return matched, true or false if there's a match or not
	 */
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
	/**
	 * Creating a new instance of PlannedZone
	 * @param x coordinate
	 * @param y coordinate
	 * @param type, zone type of PlannedZone
	 * @param quality, quality of PlannedZone
	 */
	public PlannedZone(int x, int y,EZoneType type, String quality){
		super(x,y,type);
		this.quality = quality;
	}
	/**
	 * Accept a visitor
	 */
	public void accept(IRenderVisitor visitor){
		visitor.render(this);
	}
	/**
	 * Returns a String representation of the current instance
	 */
	public String toString(){
		return String.format("%s\t%d:%d\t%s", getType(), getLocation().getX(), getLocation().getY(),
				getQuality());
	}
	/**
	 * Get quality of the current instance
	 * @return quality
	 */
	public String getQuality(){
		return quality;
	}
}
