package info.openrocket.core.rocketvisitors;

import info.openrocket.core.rocketcomponent.RocketComponent;
import info.openrocket.core.rocketcomponent.RocketComponentVisitor;

public abstract class BredthFirstRecusiveVisitor<R> implements RocketComponentVisitor<R> {

	@Override
	public final void visit(RocketComponent visitable) {

		this.doAction(visitable);

		for (RocketComponent child : visitable.getChildren()) {
			this.doAction(child);
		}

		for (RocketComponent child : visitable.getChildren()) {
			this.visit(child);
		}

	}

	protected abstract void doAction(RocketComponent visitable);

}
