package com.janita.video

import java.io.File

import scala.io.Source

/**
  * Created by Janita on 2017-05-13 14:48
  */
class RichFile(val from : File) {

  def read = Source.fromFile(from.getPath).mkString

}

object RichFile {

  implicit def file2RichFile(from : File) = new RichFile(from)
}

object MainApp {

  def main(args: Array[String]): Unit = {

    //导入隐式转换
    import RichFile._
    //import RichFile.file2RichFile
    println(new File("e://track-log.txt").read)

  }
}
