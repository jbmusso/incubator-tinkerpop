package com.tinkerpop.gremlin.process.graph.step.filter

import com.tinkerpop.gremlin.process.Traversal
import com.tinkerpop.gremlin.process.graph.step.ComputerTestHelper
import com.tinkerpop.gremlin.structure.Vertex

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @author Daniel Kuppitz (daniel at thinkaurelius.com)
 */
public abstract class GroovyDedupTest extends DedupTest {

    public static class StandardTest extends DedupTest {
        @Override
        public Traversal<Vertex, String> get_g_V_both_dedup_name() {
            g.V.both.dedup.value('name')
        }

        @Override
        public Traversal<Vertex, String> get_g_V_both_dedupXlangX_name() {
            g.V.both.dedup { it.get().property('lang').orElse(null) }.value('name')
        }

        @Override
        public Traversal<Vertex, String> get_g_V_both_name_orderXa_bX_dedup() {
            g.V.both.name.order { a, b -> a.get() <=> b.get() }.dedup
        }
    }

    public static class ComputerTest extends DedupTest {
        @Override
        public Traversal<Vertex, String> get_g_V_both_dedup_name() {
            ComputerTestHelper.compute("g.V.both.dedup.name", g);
        }

        @Override
        public Traversal<Vertex, String> get_g_V_both_dedupXlangX_name() {
            ComputerTestHelper.compute("g.V.both.dedup{it.get().property('lang').orElse(null)}.name", g);
        }

        @Override
        public Traversal<Vertex, String> get_g_V_both_name_orderXa_bX_dedup() {
            ComputerTestHelper.compute("g.V.both.name.order { a, b -> a.get() <=> b.get() }.dedup", g);
        }
    }
}