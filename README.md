
# Welcome to GraNa-GraNo <img src="docs/assets/logo.png" style="display: inline; height: 1em">

GraNa-GraNo is a web-based application that allows the
visualization and normalization of LPGs. 

## Getting Started

1. Install [Docker](https://www.docker.com) including Docker Compose
2. Clone GraNa-GraNo from [GitHub](https://github.com/dmki-tuwien/grana-grano) to your host<br>
`bash
git clone https://github.com/dmki-tuwien/grana-grano --recurse-submodules
`
3. Start the Docker containers using<br>
`
docker compose --profile grana-grano up --build
`
4. GraNa-GraNo is available on <http://localhost/>! 🎉


## WASM
To compile Java to WASM run 
```
mvn dependency:build-classpath -Dmdep.outputFile=classpath.txt && \
javac -cp "$(cat classpath.txt)" -d build src/main/java/at/ac/tuwien/dm/granagrano/Wasm.java && \
native-image --tool:svm-wasm -cp "build:$(cat classpath.txt)" -H:-AutoRunVM -H:+EnableFallbackCompilation at.ac.tuwien.dm.granagrano.Wasm && \
cp index.html docs/static/index.html && \
mv at.ac.tuwien.dm.granagrano.Wasm.* docs/static/
```

Useful: https://github.com/graalvm/graalvm-demos/tree/master/web-image/export-java-function

Overall command: `javac src/main/java/at/ac/tuwien/dm/granagrano/Wasm.java -d build & native-image --tool:svm-wasm -cp build -H:-AutoRunVM -O3 at.ac.tuwien.dm.granagrano.Wasm & cp index.html docs/static/index.html & mv at.ac.tuwien.dm.granagrano.wasm.* docs/static/`
## Documentation 
A detailed documentation of GraNa-GraNo can be found at <https://dmki-tuwien.github.io/grana-grano>.