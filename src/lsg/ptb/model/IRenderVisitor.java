package lsg.ptb.model;

/**
 * 
 * @author Mhlongo L
 *
 */
public interface IRenderVisitor {
	
	void render(PlannedZone planned);
	
	void render(ActiveZone active);
}
