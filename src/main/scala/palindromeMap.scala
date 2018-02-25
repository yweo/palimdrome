package getPalindromes

import scala.collection.mutable.LinkedHashMap
import scala.io.StdIn.readLine

object palindromeMap {
  
  var palindrome_map = scala.collection.mutable.LinkedHashMap[Int, String]()
  
  /**
   * @param str The string to look for palindrome
   */
  def getPalindromes(str: String) = {
    for(i <- str.length to 2 by -1){
      var j = 0
      for(sList <- str.sliding(i)){
        if(sList.startsWith(sList) == sList.endsWith(sList) && sList == sList.reverse)
          if(notInPalindromeMap(sList, j)) palindrome_map += (j -> sList)
        j += 1
      }
    }   
  }
  
  /**
   *  @param str The string to check if it is contained in palindrome_map
   *  @param location The start index of the string to be checked
   *  @return Returns Boolean: true, the string is not contained in palindrome_map
   */
  def notInPalindromeMap(str: String, location: Int) : Boolean = {
    for((k, v) <- palindrome_map){
      if (location >= k && str.length + location <= k + v.length) return false
    }
    true
  }
  
  def displayPalindromeMap() = {
    if(palindrome_map.size == 0)
      println("no palindrome in the string") 
    else 
      for((k, v) <- palindrome_map) println(v + "," + k + "," + (v.length))
  }
  
  def resetPalindromeMap() = {
    palindrome_map.clear
  }

  def main(args: Array[String]){
    while (true){
    var s = readLine("Please type a string to look for palindromes:  ")
    println("\nYour input: " + s + "\nPalindromes:")
    resetPalindromeMap()
    getPalindromes(s)
    displayPalindromeMap()
    }
    //getPalindromes("ABCBAHELLOHOWRACECARAREYOUILOVEUEVOLIIAMAIDOINGGOOD")
    //displayPalindromeMap()
  } 
}
