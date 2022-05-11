package lsg.ptb.model;

/**
 * 
 * @author Mhlongo L
 *
 */
public interface IRenderable {
	void accept(IRenderVisitor visitor);
}
