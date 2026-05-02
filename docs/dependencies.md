# Dependencies

To perform normalization considering nodes and edges, dependencies 
between (and within) nodes and edges (we refer to them as graph objects) need to be expressed. 
For this, a novel dependency type, graph-object functional dependencies (GO-FDs), is used [^1].
GO-FDs are similar to FDs from the relational data model except that they are based on graph
patterns.

The general structure of a GO-FD is:

$$ Q :: X \rightarrow Y $$

where $Q$ is a graph pattern, and $X$ and $Y$ are sets of variables that reference nodes, edges, or properties of nodes and edges.

The graph objects between mentioned in $X$ and $Y$ need to be the same or directly connected, as described for the [transformations](transformations.md).

A simple GO-FD defined over a node $x$ with label $l$ and property keys $k1$ and $k2$, where $x.k1$ determines $x.k2$ can be defined as:
`(x:l:k1&k2) :: x.k1 => x.k2`.

The grammar used for parsing GO-FDs in GraNa-GraNo can be found [here](https://github.com/dmki-tuwien/lpg-normalization/blob/0bfa06523f4012d6034bc92fc742b367bdccee15/gnfd/gnfd.g4).

An example for a more complex GO-FD is
`(c:Cheese)-[a:agesIn:duration&goal]->(r:AgingRoom)::
a.duration=>a.goal`.
It contains a graph pattern that describes _Cheese_ that _ages_ in _aging rooms_, and in the _aging in_ edge, the property _duration_ determines the property _goal_. 

[^1]: Johannes Schrott, Maxime Jakubowski, and Katja Hose. A Graph-Native Approach to Normalization. arXiv:2603.02995 <https://arxiv.org/abs/2603.02995>