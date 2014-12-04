package com.tinkerpop.gremlin.process.graph.step.util;

import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.process.Traverser;
import com.tinkerpop.gremlin.process.util.AbstractStep;

import java.util.NoSuchElementException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public final class LocalTraversalStep<S> extends AbstractStep<S, S> {

    public LocalTraversalStep(final Traversal traversal) {
        super(traversal);
    }

    @Override
    protected Traverser<S> processNextStart() throws NoSuchElementException {
        return this.starts.next();
    }
}