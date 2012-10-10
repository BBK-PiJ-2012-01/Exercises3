print "Enter string: "
String str = System.console().readLine()

if (str.length() < 1)
    throw new BadInput("String needs to be at least 1 character long")

// I want to create the shortest-possible palindromes,
// eg. abcb should become abcba, not abcbbcba.  To do
// this I find the largest palindrome starting from the
// end of the string.
// NB. There is always a palindrome that's one-character long.
String longest_palindrome
for (start in 0..str.length()-1) {
    palindrome = str[start..str.length()-1]

    if (str.reverse() == str)
        break
}

int chs_need_to_copy = str.length()-palindrome.length()

if (chs_need_to_copy > 0)
    palindrome = str[0..chs_need_to_copy-1] + palindrome + str[chs_need_to_copy-1..0]

IOGeneric.printResult(palindrome)