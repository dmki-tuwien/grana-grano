# Metrics

GraNa-GraNo provides two different types of metrics: per-graph
and per-dependency metrics. 
All metrics are computed before and
after performing normalization and
are shown as interactive bar plots that provide 
the exact result values when hovering on them.

## Per-Graph Metrics

We defined five metrics that are computed on
a per-graph basis.


| **Metric name** | **Description**                                    | **Formula**                                                                                                                             |
|-----------------|----------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| NodeCount       | The number of nodes in a graph $G$                 | $&#124;N&#124;$                                                                                                                         | 
| EdgeCount       | The number of edges in a graph $G$                 | $&#124;E&#124;$                                                                                                                         | 
| AvgNodePropCount | The average number of properties over all nodes    | $\mathsf{avg}\bigl(\bigl\{\bigl&#124;\left\{p\in\mathbf{P}:(n,p) \in \mathsf{dom}(\mathsf{prop})\right\}\bigr&#124;:n\in N\bigr\}\bigr)$ |
| AvgEdgePropCount | The average number of properties over all edges    | $\mathsf{avg}\bigl(\bigl\{\bigl&#124;\left\{p\in\mathbf{P}:(e,p) \in \mathsf{dom}(\mathsf{prop})\right\}\bigr&#124;:e\in E\bigr\}\bigr)$ |                                                                                                                                        | The average number of properties over all edges |
| DisconnectedSubgraphCount | The number of disconnected subgraph in a graph $G$ | |

This per-graph metrics rely on the definition of a labeled property graph as
$G=(N,E,\mathsf{lab},\mathsf{src},\mathsf{tgt},\mathsf{prop}))$, where:

* $N$ and $E$ are sets of nodes and edges,

and the functions

* $\mathsf{lab}$ assigns sets of labels to the nodes and edges
* $\mathsf{src}$ and $\mathsf{tgt}$ define the endpoints of the edges
* $\mathsf{prop}$ assigns
constant calues to the property keys in nodes and edges.


## Per-Dependency Metrics
For each [dependency](dependencies.md) of the form $Q :: X \Rightarrow Y$, three
metrics are computed:

| **Metric name**             | **Description**                                                                                                                                                                                                                                                                |
|-----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Max- and AvgRedundancyCount | Inspired by Skavantzos et al.[^1], these two metrics compute the maximum respectively the average of the size of groups of redundant values of the properties in $X$ and $Y$. If no redundancies are present, both metrics have a value of 1.                                  |
| Minimality         | Based on Ehrlinger et al.[^2], minimality calculates the ratio between distinct and all pieces of information involving the properties of $X$ and $Y$. If all pieces of information are redundant, the value of minimality 0; if all are unique, the value of minimality is 1. |

[^1]: Philipp Skavantzos and Sebastian Link. 2025. Third and Boyce-Codd normal
form for property graphs. VLDB J. 34, 2 (2025), 23.
[^2]: Lisa Ehrlinger and Wolfram Wöß. 2018. A Novel Data Quality Metric for Minimality. In QUAT@WISE (Lecture Notes in Computer Science, Vol. 11235). Springer,
1–15.