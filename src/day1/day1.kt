package day1

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<Int>
            = File(fileName).useLines { it.toList() }.map{it.toInt()}

    val lines = readFileAsLinesUsingUseLines("src\\day1\\input")

    var current = lines[0]
    var total = 0
    for(i in lines.indices){
        if (lines[i] > current){
            total += 1
        }
        current = lines[i]
    }

    print("A: $total")
}