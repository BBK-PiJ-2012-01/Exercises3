class MyVector {
    double x, y
    static enum BOOL {
        TRUE, BORDER, FALSE
    }
    
    MyVector(double new_x, double new_y) {
        x = new_x
        y = new_y
    }
    
    MyVector minus(MyVector right) {
        return new MyVector(x-right.x, y-right.y)
    }
    
    double length() {
        return (x**2 + y**2)**0.5
    }
    
    String getString() {
        return x + ", " + y
    }
    
    static MyVector[] getShortestVectorsFromRef(def vectors, MyVector ref) {
        if (vectors.size() < 1)
            throw BadInput("I need more vectors!")
            
        def vectors_clone = vectors.clone()
        def shortest = []
        double shortest_length
        MyVector candidate_shortest
        
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
    
    void swapY(MyVector other) {
        double temp = other.y
        other.y = y
        y = temp
    }
    
    int[] getQuadrants() {
        def quadrants = []
        if (x >= 0) {
            if (y >= 0)
                quadrants.add(1)
            if (y <= 0)
                quadrants.add(4)
        }
        if (x <= 0) {
            if (y >= 0)
                quadrants.add(2)
            if (y <= 0)
                quadrants.add(3)
        }
        return quadrants
    }
    
    void swapX(MyVector other) {
        double temp = other.x
        other.x = x
        x = temp
    }
}