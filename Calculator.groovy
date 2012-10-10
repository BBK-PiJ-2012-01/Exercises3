class Calculator {
    private static def operands = [
                            Add:{a, b -> a+b}, 
                            Subtract:{a, b -> a-b}, 
                            Multiply:{a, b -> a*b}, 
                            Divide:{a, b -> a/b}
                            ]
    private static def algebra = [
                            "+":operands["Add"],
                            "-":operands["Subtract"],
                            "*":operands["Multiply"],
                            "/":operands["Divide"]
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
    
    void operateFromAlgebra() {
        print "Enter algebra: "
        String str = System.console().readLine()
        def occurances = [:]
        for (algebra_item in Calculator.algebra) {
            occurances[algebra_item.key] = str.count(algebra_item.key)
        }
        //int[] occurances = algebra.keySet().collect{ str.count(it) }
        if ([1, 0].collect{ occurances.values().count(it) } != [1, 3])
            throw new BadInput(str)
        String op_string = occurances.collect{ if(it.value == 1) return it.key }.sort()[-1]
        
        int operand_position_in_str = str.getChars().findIndexOf{it==(op_string as char)}
        double num1 = str[0..operand_position_in_str-1].toDouble()
        double num2 = str[operand_position_in_str+1..str.size()-1].toDouble()
        
        println num1 + " " + op_string + " " + num2 + " = " + Calculator.algebra[op_string](num1, num2)
        
    }
    
}