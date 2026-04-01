# Architecture and Development

GraNa-GraNo is a containerized application that is split into a web-based [frontend](#frontend) 
and a backend that performs normalization and connects to graph stores, for which currently [Neo4j](https://neo4j.com) and [Memgraph](https://memgraph.com) are supported.

<figure markdown="span">
  <img alt="The architecture of GraNa-GraNo" src="/assets/architecture.png" width="400"/>
  <figcaption>The architecture of GraNa-GraNo</figcaption>
</figure>

## Configuration
The following environment variables need to be set in a `.env` file in order to run GraNa-GraNo:
* `USERNAME`: The username, which the Neo4j graph store should use
* `PASSWORD`: The password, which the Neo4j graph store should use

## Frontend
### Web GUI

The frontend is a [Next.js](https://nextjs.org)-based web-app that communicates with the [backend](#python-core) trough a REST API.
For visualizing the graphs and the dependencies [cytoscape.js](https://js.cytoscape.org) is used.
The frontend is included into GraNa-GraNo as a submodule. The source code can be found at <https://github.com/dmki-tuwien/lpg-normalization-demo>.

To develop the frontend, [node.js](https://nodejs.org/) is required.
The frontend can be run in development mode by executing `npm install` and `npm run dev` in the submodule's root folder.

## Backend
### Python core
The REST API is provided by a [Python](https://python.org)-based core, which is - as the [frontend](#frontend) - contained in a submodule.
The source code can be found at <https://github.com/dmki-tuwien/lpg-normalization>.

To develop the backend [Python](https://python.org) version 3.14 or higher is required.
The backend can be run in development mode by executing `pip install -r requirements.txt` followed by `fastapi dev restapi/restapi.py`,
which runs the REST API in development mode.

### Graph stores
The [Python core](#python-core) currently supports the normalization of [Cypher](https://opencypher.org)-based LPGs
stored in [Neo4j](https://neo4j.com) and [Memgraph](https://memgraph.com).
Both graph stores are used in the form of [Docker](https://docker.com) containers. 
For development purposes, the container running Neo4j binds on [bolt://localhost:7687](bolt://localhost:7687) and the container running Memgraph binds on [bolt://localhost:7688](bolt://localhost:7688).

