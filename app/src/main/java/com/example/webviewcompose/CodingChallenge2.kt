package com.example.webviewcompose

/**
 * Check if string is a palindrome: Ex. "hello" - false, "abba" - true
 */
fun main() {
    println(isPalindrome("hello"))
    println(isPalindrome("radar"))
    println(isPalindrome("abba"))
}

fun isPalindrome(input: String): Boolean {
    return input == input.reversed()
}