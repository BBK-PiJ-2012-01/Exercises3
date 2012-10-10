class IOVector extends IOGeneric {
    static Vector getVector() {
        print "   Type coords as \"x, y\" (eg. \"1, 3\"): "
        String str = System.console().readLine()
        def coords = str.split(",")
        if (coords.size() != 2)
            throw new BadInput("Only enter the projections onto two axes")
            
        Vector result
        try {
            result = new Vector(coords[0] as double, coords[1] as double)
        } catch(all) {
            throw BadInput(str)
        }
        
        return result
    }
    
    static Vector[] getNVectors(int n) {
        def vectors = []
        if (n<1)
            throw BadInput("Must ask for at least 1 vectors")
        for (i in 1..n) {
            vectors.add(getVector())
        }
        
        return vectors
    }
    
    static void printVector(Vector v, String msg) {
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


println "Enter reference point - "
Vector reference = IOVector.getVector()
println "\nEnter three other points - "
println "ref is: " + reference.getString()
Vector[] input_vectors = IOVector.getNVectors(3)

def shortest_vectors = Vector.getShortestVectorsFromRef(input_vectors, reference)


if (shortest_vectors.size() == 1)
    IOVector.printVector(shortest_vectors[0], "Closest point was: ")
else
    IOVector.printVectors(shortest_vectors, "These " + shortest_vectors.size() + " were the closest:")

