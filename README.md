This project is built using [`scala.js`](https://www.scala-js.org/)

As it uses Scala 3 as a source language, you will need `sbt` installed, version `>= 1.5.0`.

## Build

```
$ sbt
 > [info] started sbt server
sbt:dynamic-revo> ~fastOptJS // Starts interactive watch session
```

Note that this will produce a develop bundle that is suitable for local incremental recompiles and fast reloads. Production should be output with `fullOptJS`, minified, gzipped, etc.

## Serve

```
serve -p 1173 . // (Alternatively, server program and port of choice)
```
