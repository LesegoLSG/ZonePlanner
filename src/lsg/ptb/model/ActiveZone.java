package lsg.ptb.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class read the pattern and matches it.
 * @author Mhlongo L
 *
 */
public class ActiveZone extends Zone{
	
	/**
	 * Validate data from file
	 * @param line, string from file and matches with the pattern
	 * @return matched, true or false if there's a match or not
	 */
	public static boolean validate(String line){
		
		boolean matched = false;
		
		Pattern pattern = Pattern.compile("[A-Z]+\\s\\d+:\\d+\\s[A-Z][a-z]+\\s\\d+");
		
		Matcher match = pattern.matcher(line);
		
		if(match.matches()){
			matched =true;
		}
		return matched;
	}
	
	private final String export;
	private final int size;
	
	/**
	 * Constructs coordinate x,y, the type and size and also export.
	 * @param x coordinate
	 * @param y coordinate
	 * @param type, zone type of ActiveZone
	 * @param size, size of ActiveZone
	 * @param export, Text export of ActiveZone
	 */
	public ActiveZone(int x, int y, EZoneType type, int size, String export){
		super(x,y,type);
		this.size = size;
		this.export = export;
	}
	/**
	 * Accept a visitor
	 */
	public void accept(IRenderVisitor visitor){
		visitor.render(this);
	}
	
	/**
	 * @return a string representation of the current instance
	 */
	public String toString(){
		return String.format("%s\t%d:%d\t%s\t%d", getType(),getLocation().getX(),getLocation().getY(),getExport(),getSize());
		
	}
	/**
	 * 
	 * @return the exported items
	 */
	public String getExport(){
		return export;
	}
	/**
	 * 
	 * @return the size
	 */
	public int getSize(){
		return size;
	}
}

