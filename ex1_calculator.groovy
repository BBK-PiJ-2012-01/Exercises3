
class FPU {

    static int test() { return 5 }
    /*
    // This doesn't work!  Perhaps because it is statically
    // defining operands using static methods that are in
    // the process of being defined.
    
    static def operands = [
                    "Add":FPU.add, 
                    "Subtract":FPU.subtract, 
                    "Multiply":FPU.multiply, 
                    "Divide":FPU.divide
                  ]
    */            
    
    static double add(double left, double right) {
        return left + right
    }
    
    static double subtract(double left, double right) {
        return left - right
    }
    
    static double multiply(double left, double right) {
        return left * right
    }
    
    static double divide(double left, double right) {
        return left/right
    }
    
    static def getOperands() {
       return 
    }
}

class Calculator {
    private static def operands = [
                            Add:{a, b -> a+b}, 
                            Subtract:{a, b -> a-b}, 
                            Multiply:{a, b -> a*b}, 
                            Divide:{a, b -> a/b}
                            ]
    private static def algebra = [
                            "*":operands["Add"]
                            ]
    
    void operateFromMenu() {
        print "Type the first number: "
        double num1 = IOGeneric.getDouble()
        print "Type the second number: "
        double num2 = IOGeneric.getDouble()
        
        println "Which operand would you like to apply?"
        
        def operand = IOGeneric.chooseFromMap(Calculator.operands)
        println "Result is: " + operand(num1, num2)
        
    }
    
}

Calculator calc = new Calculator()
calc.operateFromMenu()