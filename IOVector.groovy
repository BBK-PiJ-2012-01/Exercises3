class IOVector extends IOGeneric {
    static MyVector getVector() {
        print "   Type coords as \"x, y\" (eg. \"1, 3\"): "
        String str = System.console().readLine()
        def coords = str.split(",")
        if (coords.size() != 2)
            throw new BadInput("Only enter the projections onto two axes")
            
        MyVector result
        //try {
            result = new MyVector(coords[0] as double, coords[1] as double)
        //} catch(all) {
        //    throw new BadInput(str)
        //}
        
        return result
    }
    
    static MyVector[] getNVectors(int n) {
        def vectors = []
        if (n<1)
            throw new BadInput("Must ask for at least 1 vectors")
        for (i in 1..n) {
            vectors.add(getVector())
        }
        
        return vectors
    }
    
    static void printVector(MyVector v, String msg) {
        printResult(msg + v.getString())
    }
    
    static void printVectors(def vs, String msg) {
        println "-"*msg.length()
        println msg
        for (v in vs) {
            println "\t" + v.getString()
        }
        println "-"*msg.length()
    }
}