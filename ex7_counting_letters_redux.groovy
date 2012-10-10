print "Enter string: "
String str = System.console().readLine()


char ch_to_count

def search_cache = []

while (true) {
    print "Enter character to search for: "
    ch_to_count = IOGeneric.getChar()
    
    if (ch_to_count in search_cache)
        break
    
    println "I found " + str.getChars().count(ch_to_count) + " \'" + ch_to_count + "\'s."
    search_cache.add(ch_to_count)
}

println "I quit because you kept asking about \'" + ch_to_count + "\'."