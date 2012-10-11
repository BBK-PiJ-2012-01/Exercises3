print "Enter string: "
String str = System.console().readLine().toLowerCase().replaceAll(",","")
       

// Find the position of the decimal point.
int number_of_decimal_points = str.getChars().count('.')
int point_position = str.length()
def digit_map = [:]
for (i in 0..9) {
    digit_map[i as String] = i as BigDecimal
}
BigDecimal num = 0

if (number_of_decimal_points > 1)
    throw new BadInput(str + " has too many decimal points")
else if (number_of_decimal_points == 1) {
    point_position = str.getChars().findIndexOf{ it == ('.' as char) }
    println "decimal at position: " + point_position
    str -= '.'//str.drop(point_position)
    println "str is now: " + str
}

if (str.length() < 1)
    throw new BadInput("String was just a \'.\'")
    
for (index in 0..str.length()-1) {
    if (!str[index].isNumber())
        throw new BadInput(str + " contained a non-number character")
    num += digit_map[str[index]] * 10**(str.length()-index-1)
}
num *= 10**(point_position-str.length()) as BigDecimal
    
IOGeneric.printResult(num as String)

