package day1

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<Int>
            = File(fileName).useLines { it.toList() }.map{it.toInt()}

    val lines = readFileAsLinesUsingUseLines("src\\day1\\input")
//  A
    var current = lines[0]
    var total = 0
    for(i in lines.indices){
        if (lines[i] > current){
            total += 1
        }
        current = lines[i]
    }

    println("A: $total")

//  B
    var sums = mutableListOf<Int>()

    for(i in lines.indices){
        if (i < (lines.size - 2)){
            sums.add(lines[i] + lines[i+1] + lines[i+2])
        }
    }

    current = sums[0]
    total = 0
    for(i in sums.indices){
        if (sums[i] > current){
            total += 1
        }
        current = sums[i]
    }

    println("B: $total")


}