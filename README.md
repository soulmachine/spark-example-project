# Spark Example Project [![Build Status](https://travis-ci.org/soulmachine/spark-example-project.png)](https://travis-ci.org/soulmachine/spark-example-project)

## Introduction

This is a simple word count job written in Scala for the [Spark] [spark] cluster computing platform. This project is ported directly from [Snowplow Analytics] [snowplow]'s [Spark Example Project](https://github.com/snowplow/spark-example-project).

_See also:_ [Scalding Example Project] [scalding-example-project]

## Building

Assuming you already have [SBT] [sbt] installed:

    $ git clone git://github.com/soulmachine/spark-example-project.git
    $ cd spark-example-project
    $ sbt assembly

The 'fat jar' is now available as:

    target/spark-example-project-1.0.jar

## Unit testing

The `assembly` command above runs the test suite - but you can also run this manually with:

    $ sbt test
    <snip>
    [info] + A WordCount job should
    [info]   + count words correctly
    [info] Passed: : Total 1, Failed 0, Errors 0, Passed 1, Skipped 0

## Submit job to Spark on YARN

    spark-submit --class me.soulmachine.spark.WordCount --master yarn-cluster ./spark-example-project-1.0.jar wordcount-test/input wordcount-test/output
