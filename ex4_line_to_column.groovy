print "Enter string: "
String str = System.console().readLine()

void printReplacingSpaceWithNewline(String str) {
    char ch = str[0]
    if (ch == ' ')
        print '\n'
    else
        print ch
}

println (("="*10) + "  Using for-loop:  " + ("="*10))
for (character in str) {
    //println character
    printReplacingSpaceWithNewline(character)
}

print '\n'
println (("="*10) + "  Using while-loop:  " + ("="*10))

int index = 0
while(index < str.size()) {
    //println str[index]
    printReplacingSpaceWithNewline(str[index])
    index++
}
print '\n'