print "Enter string: "
String str = System.console().readLine()

print "Enter character to search for: "
char ch_to_count = System.console().readLine()[0]

println "I found " + str.getChars().count(ch_to_count) + " " + ch_to_count + "\'s."