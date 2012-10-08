class IOGeneric {
    /*
    *    Generic user input/output class used in many exercises.
    */
    static int getInteger(){
        int num
        try {
            String str = System.console().readLine()
            num = Integer.parseInt(str)
        } catch(all) {
            throw new BadInput()
        }
        return num
    }
    
    static double getDouble(){
        double num
        try {
            String str = System.console().readLine()
            num = Double.parseDouble(str)
        } catch(all) {
            throw new BadInput()
        }
        return num
    }
    

    static void printResult(String result) {
        println '-'.multiply( result.length() )
        println result
        println '-'.multiply( result.length() )
    }
    
    static int chooseFromList(def lst) {
        // Returns list index of chosen item
        for (item in lst) {
            println "["+item[0]+"]" + item[1..item.size()-1]
        }
        String[] first_letters = lst.collect{it[0].toLowerCase()}
        String str = System.console().readLine().toLowerCase()[0]
        
        if (str in first_letters)
            return first_letters.findIndexOf{it==str}
        else
            throw new BadInput()
            
    }
    
    static def chooseFromMap(def map) {
        int index = chooseFromList(map.keySet())
        return map.values().toList()[index]
    }
}