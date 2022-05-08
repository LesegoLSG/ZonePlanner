package lsg.ptb.model;

public interface IRenderable {
	void accept(IRenderVisitor visitor);
}
