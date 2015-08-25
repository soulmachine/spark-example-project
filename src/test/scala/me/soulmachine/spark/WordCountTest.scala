package me.soulmachine.spark

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.{Paths, Files}

import org.scalatest._

import scala.io.Source


class WordCountTest extends FlatSpec with Matchers {
  "A WordCount job" should  "count words correctly" in {
    val tempDir = Files.createTempDirectory(null)
    println(tempDir.toAbsolutePath)

    val inputFile = new File(tempDir.toAbsolutePath.toString, "input.txt")
    Files.write(Paths.get(inputFile.getAbsolutePath),
      "hack hack hack and hack".getBytes(StandardCharsets.UTF_8))
    inputFile.deleteOnExit()

    val outputDir = new File(tempDir.toAbsolutePath.toString, "output").getAbsolutePath

    WordCount.execute(
      master = Some("local"),
      input   = inputFile.getAbsolutePath,
      output  = outputDir
    )

    val outputFile = new File(outputDir, "part-00000")
    val actual = Source.fromFile(outputFile, "UTF-8").mkString
    // delete the temporary folder
    new ProcessBuilder("rm","-rf", tempDir.toAbsolutePath.toString).start().waitFor()

    assert(actual === "(hack,4)\n(and,1)\n")
  }
}
