// Closer to...what?!?!  The origin?

class Vector {
    double x, y
    
    Vector(double new_x, double new_y) {
        x = new_x
        y = new_y
    }
    
    Vector minus(Vector right) {
        return new Vector(x-right.x, y-right.y)
    }
    
    double length() {
        return (x**2 + y**2)**0.5
    }
    
    String getString() {
        return x + ", " + y
    }
    
    static Vector[] getShortestVectorsFromRef(def vectors, Vector ref) {
        if (vectors.size() < 1)
            throw BadInput("I need more vectors!")
            
        def vectors_clone = vectors.clone()
        def shortest = []
        double shortest_length
        Vector candidate_shortest
        
        while(vectors_clone.size() > 0) {
            candidate_shortest = vectors_clone.min{ (it - ref).length() }
            if (shortest.isEmpty()) {
                shortest.add(candidate_shortest)
                shortest_length = (candidate_shortest - ref).length()
                vectors_clone -= candidate_shortest
            } else if ((candidate_shortest - ref).length() - shortest_length < 1e-5) {
                shortest.add(candidate_shortest)
                vectors_clone -= candidate_shortest
            } else
                break
        }
        
        return shortest
    }
}


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

