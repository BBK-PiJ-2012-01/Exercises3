class Rectangle {
    MyVector upLeft, downRight
    static enum POS {   
        IN, OUT, BORDER
    }
    String name = ""
    
    Rectangle(MyVector new_upLeft, MyVector new_downRight) {
        upLeft = new_upLeft
        downRight = new_downRight
    }
    
    double getHeight() {
        return upLeft.y - downRight.y
    }
    
    double getWidth() {
        return downRight.x - upLeft.x
    }
    
    double getArea() {
        return getHeight()*getWidth()
    }
    
    double getPerimeter() {
        return 2*getHeight()*getWidth()
    }
    
    MyVector getUpRight() {
        return new MyVector(downRight.x, upLeft.y)
    }
    
    MyVector getDownLeft() {
        return new MyVector(upLeft.x, downRight.y)
    }
    
    POS getPosition(MyVector v) {
        int[] downRight_quadrants = (v - downRight).getQuadrants()
        int[] upLeft_quadrants = (v - upLeft).getQuadrants()
        
        if (2 in downRight_quadrants && 4 in upLeft_quadrants) {
            if (downRight_quadrants.size() + upLeft_quadrants.size() > 2)
                return POS.BORDER
            else
                return POS.IN
        } else 
            return POS.OUT
    }
    
    Rectangle intersection(Rectangle other) {
        def key_points = [upLeft, downRight, other.upLeft, other.downRight]
        double[] y_coords = key_points*.y.sort()
        double[] x_coords = key_points*.x.sort()
        
        MyVector int_upLeft = new MyVector(x_coords[1], y_coords[2])
        MyVector int_downRight = new MyVector(x_coords[2], y_coords[1])
        
        double mid_x = (x_coords[2]-x_coords[1])/2 + x_coords[1]
        double mid_y = (y_coords[2]-y_coords[1])/2 + y_coords[1]
        MyVector midpoint = new MyVector(mid_x, mid_y)
        
        Rectangle rect_intersection = new Rectangle(int_upLeft, int_downRight)
        rect_intersection.name = "Overlap of " + name + " and " + other.name
        
        if (rect_intersection.getPosition(midpoint) != POS.IN)
            throw new InvalidIntersection()
        
        return rect_intersection
    }
}
    
class InvalidIntersection extends Exception {
    InvalidIntersection() {
        println "======= There is no intersection. ======="
    }
}