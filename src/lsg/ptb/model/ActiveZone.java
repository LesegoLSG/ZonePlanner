package lsg.ptb.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActiveZone extends Zone{
	
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
	
	public ActiveZone(int x, int y, EZoneType type, int size, String export){
		super(x,y,type);
		this.size = size;
		this.export = export;
	}
	
	public void accept(IRenderVisitor visitor){
		visitor.render(this);
	}
	
	public String toString(){
		return String.format("%s\t%d:%d\t%s\t%d", getType(),getLocation().getX(),getLocation.getY(),getExport(),getSize());
		
	}
	
	public String getExport(){
		return export;
	}
	
	public int getSize(){
		return size;
	}
}

