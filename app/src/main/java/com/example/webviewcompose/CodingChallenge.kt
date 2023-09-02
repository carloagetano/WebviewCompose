package com.example.webviewcompose

/**
 * Count unique numbers
 * ex. [1, 2, 1, -2, -3] = 4
 */
fun main() {
    println(getUniqueCount(listOf(2, -2, 2, 3, 4, 1, -2)))
    println(getUniqueCount2(listOf(2, -2, 2, 3, 4, 1, -2)))
    println(getUniqueCount3(listOf(2, -2, 2, 3, 3, 4, 1, -2)))
}

fun getUniqueCount(numbers: List<Int>): Int = numbers.groupBy { it }.count()

fun getUniqueCount2(numbers: List<Int>): Int = numbers.toSet().size

fun getUniqueCount3(numbers: List<Int>): Int = numbers.distinct().size