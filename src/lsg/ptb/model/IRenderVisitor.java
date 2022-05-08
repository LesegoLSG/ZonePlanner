package lsg.ptb.model;

public interface IRenderVisitor {
	
	void render(PlannedZone planned);
	
	void render(ActiveZone active);
}
