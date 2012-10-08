class Calculator {
    double num1, num2
    static def operands = ["Add", "Subtract", "Multiply", "Divide"]

    operateFromMenu() {
        print "Type the first number: "
        
        num1