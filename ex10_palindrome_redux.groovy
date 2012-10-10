print "Enter string: "
String str = System.console().readLine().toLowerCase()

if (str.length() < 1)
    throw new BadInput("String needs to be at least 1 character long")
    
String condensed_str = ""

for (ch in str.getChars()) {
    if (ch.isLetter())
        condensed_str += (ch)
}

if (condensed_str.reverse() == condensed_str)
    println "That was indeed a relaxed palindrome!"
else
    println "Not a relaxed palindrome."