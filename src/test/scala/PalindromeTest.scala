import org.scalatest._
import Matchers._
import scala.collection.mutable.LinkedHashMap
import getPalindromes._
import java.io._
import scala.Console

class PalindromeTest extends FlatSpec with Matchers {

  "getPalindromes" should "find all palindromes and add entry(start_location, palindrome_string) to palindrome_map" in {
    palindromeMap.getPalindromes("ABCBAHELLOHOWRACECARAREYOUILOVEUEVOLIIAMAIDOINGGOOD")
    info("finding palindromes in ABCBAHELLOHOWRACECARAREYOUILOVEUEVOLIIAMAIDOINGGOOD")
    info("palindrome_map should contain 11 entries, checking")
    info("elements in palindrome map: " + palindromeMap.palindrome_map.mkString(", "))
    palindromeMap.palindrome_map should have size (11)
  }

  "displayPalindromeMap" should "display all elements in Map" in {
    //val stream = new java.io.ByteArrayOutputStream()
    //Console.withOut(stream) {
      palindromeMap.displayPalindromeMap()
    //}
  }

  "notInPalindromeMap" should "return false when a string is contained in a longer palindrome" in {
    palindromeMap.notInPalindromeMap("BCB", 1) shouldBe false
  }
   
   "resetPalindromeMap" should "reset palindrome_map to size 0" in {
     palindromeMap.resetPalindromeMap() 
     palindromeMap.palindrome_map should have size (0)
   }

   "getPalindromes" should "find no palindrome with one character string" in {
     info("finding palindromes in A")
     palindromeMap.getPalindromes("A")
     palindromeMap.palindrome_map should have size (0)
   }
}
