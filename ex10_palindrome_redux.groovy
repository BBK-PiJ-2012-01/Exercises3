print "Enter string: "
String str = System.console().readLine()

if (str.length() < 1)
    throw new BadInput("String needs to be at least 1 character long")
    
