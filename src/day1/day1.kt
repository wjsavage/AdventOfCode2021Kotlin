package day1

import java.io.File

fun main(args: Array<String>) {
    fun readFileAsLinesUsingUseLines(fileName: String): List<Int>
            = File(fileName).useLines { it.toList() }.map{it.toInt()}

    val lines = readFileAsLinesUsingUseLines("src\\day1\\input")

    // best answers (not mine)
    // A
    var total = lines.windowed(2).count{it.last() > it.first()}
    println("A: $total")
    // B
    total = lines.windowed(4).count{it.last() > it.first()}
    println("B: $total")

    // my Python solution but in Kotlin
    // A
    total = lines.zip(lines.subList(1, lines.size)).count{(x, y) -> x < y}
    println("A: $total")
    // B
    val sums = lines.zip(lines.subList(1, lines.size))
            .map{(x, y) -> x + y}
            .zip(lines.subList(2, lines.size))
            .map{(x, y) -> x + y}
    total = sums.zip(sums.subList(1, sums.size)).count{(x, y) -> x < y}
    println("B: $total")


    // Below are my first attempts but I'm trying to learn and get better at Kotlin as these are very primitive answers
//  A
    var current = lines[0]
    total = 0
    for(i in lines.indices){
        if (lines[i] > current){
            total += 1
        }
        current = lines[i]
    }

    println("A: $total")

//  B
    val sums2 = mutableListOf<Int>()

    for(i in lines.indices){
        if (i < (lines.size - 2)){
            sums2.add(lines[i] + lines[i+1] + lines[i+2])
        }
    }

    current = sums2[0]
    total = 0
    for(i in sums2.indices){
        if (sums[i] > current){
            total += 1
        }
        current = sums2[i]
    }

    println("B: $total")


}