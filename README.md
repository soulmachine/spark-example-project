# Spark Example Project [![Build Status](https://travis-ci.org/soulmachine/spark-example-project.png)](https://travis-ci.org/soulmachine/spark-example-project)

## Introduction

This is a simple word count job written in Scala for the [Spark](http://spark.apache.org/) cluster computing platform. This project is inspired by  Snowplow Analytics's [Spark Example Project](https://github.com/snowplow/spark-example-project) and [Typesafe Activator Spark Sample Project](http://www.typesafe.com/activator/template/spark-sample-project).

_See also:_ 

* [JRuby Example](https://github.com/soulmachine/JRubyExample)
* [Jython Example](https://github.com/soulmachine/JythonExample)
* [Jparsec Example](https://github.com/soulmachine/JparsecExample)
* [Scalding Example Project](https://github.com/soulmachine/scalding-example-project)

## Compile

Assuming you already have [SBT] [sbt] installed:

    $ git clone git://github.com/soulmachine/spark-example-project.git
    $ cd spark-example-project
    $ sbt clean package

The 'fat jar' is now available as:

    target/spark-example-project-1.0.jar

## Unit Test

The `assembly` command above runs the test suite - but you can also run this manually with:

    $ sbt test
    <snip>
    [info] + A WordCount job should
    [info]   + count words correctly
    [info] Passed: : Total 1, Failed 0, Errors 0, Passed 1, Skipped 0

## Load into IntelliJ Idea

Run `sbt gen-idea` to create Idea project files, and click `File->Open...` to open the project's root folder then you're all set.

## Submit job to Spark on YARN

    spark-submit --class me.soulmachine.spark.WordCount --master yarn://ip-or-host:7077 ./spark-example-project-1.0.jar wordcount-test/input wordcount-test/outputs

## Static Analyzer

### linter (https://github.com/HairyFotr/linter)

Usage: automatically runs during Compilation and evaluation in console

### sbt-scapegoat (https://github.com/sksamuel/sbt-scapegoat)

Usage: automatically runs during Compilation

Open target/scala-2.11/scapegoat.xml or target/scala-2.11/scapegoat.html

## Coding Style Checker

### ScalaStyle

Usage: ```sbt scalastyle```

Open `target/scalastyle-result.xml`

Check level are all "warn", change to "error" if you want to reject code changes when integrated with CI tools.
