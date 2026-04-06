# Scenarios

GraNa-GraNo ships with 15 normalization scenarios that each consist of a graph and a set of [dependencies](dependencies.md).
The scenarios can be classified as small graphs that are ideal for visualization, as graphs based on real world data, and as graphs that resemble redundancy patterns.

!!! info
    All scenarios _except [London Public Transport](#london-public-transport)_
    are included out-of-the-box with GraNa-GraNo. Due to licensing, the sources for the graph of [London Public Transport](#london-public-transport) need to be downloaded manually from [Zenodo](https://zenodo.org/records/18479732).

## Available Scenarios

### Small Graphs

#### Grana large and small
The _Grana_ scenarios contain two small illustrative examples that show graph-native LPG normalization for graphs.
The graphs contain "cheese" that "ages" for a certain
duration in "aging rooms" to become a cheese of a particular type,
e.g., "Grana Padano DOP". The resulting type of cheese (the "goal")
depends on the "aging duration", which is given in months.<br>The _Grana small_ scenario contains 2 cheeses and 1 aging room,
The _Grana large_ scenario containes 4 cheeses and 2 aging rooms.

#### No Socks 1, 2, and 3
The _No Socks_ scenarios originate from the motivating example of [^1]. _No Socks 1_ and _2_ model the same scenario from [^1], but differ in the way gFDs were translated to GO-FDs.
_No Socks 3_ is a distinct scenario.

#### University 1 and 2
The _University_ scenarios originate from the motivating example of [^2].
_University 1_ contains a _between-n-ep_ dependency, _University 2_ defines a _between-np-ep_ dependency over gthe same graph.


### Real-world Graphs
#### Northwind
The _Northwind_ scenario originates from [^1].
The graph is provided on [GitHub](https://github.com/neo4j-graph-examples/northwind), 
and is combined with GO-FDs that were converted from gFDs mined in [^1].

#### London Public Transport
The _London Public Transport_ scenario is built on a graph whose sources are available on [Zenodo](https://zenodo.org/records/18479732).
For this scenario, a minimal cover of 2 within-node GO-FDs and 1 within-edge GO-FD is provided.
As noted above, this is the only dataset the _is not_ distributed out-of-the-box with GraNa-GraNo. It needs to be downloaded from Zenodo [Zenodo](https://zenodo.org/records/18479732).

### Redundancy Patterns

These 6 scenarios provide a small generic graph for each redundancy pattern, i.e., for each [transformation](transformations.md).

## Adding Scenarios

Scenarios are configured in the `setup.yaml` YAML file located in the [backend](architecture.md#backend). 
In order to be available in GraNa-GraNo, graphs must be provided as Cypher files (YAML key: `from_file`). Graphs from database dumps are currently not supported.
The dependencies used in a scenario can be edited by users in GraNa-GraNo without touching the YAML configuration file.

[^1]: Philipp Skavantzos and Sebastian Link. 2025. Third and Boyce-Codd normal
form for property graphs. VLDB J. 34, 2 (2025), 23.
[^2]: ohannes Schrott, Maxime Jakubowski, and Katja Hose. A Graph-Native Ap-
proach to Normalization. arXiv:2603.02995 <https://arxiv.org/abs/2603.02995>