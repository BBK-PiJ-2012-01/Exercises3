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