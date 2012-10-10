class IORectangle extends IOGeneric {
    static Rectangle getRectangle() {
        println "Enter the coords of two opposing corners of the rectangle:"
        def corners = IOVector.getNVectors(2)
        
        if (corners[0].x > corners[1].x)
            corners[0].swapX(corners[1])
        else if (corners[0].x == corners[1].x)
            throw new BadInput("Corners can't have same x value.  Are you sure they are opposing?")

        if (corners[0].y < corners[1].y)
            corners[0].swapY(corners[1])
        else if (corners[0].y == corners[1].y)
            throw new BadInput("Corners can't have same y value.  Are you sure they are opposing?")
        
        return new Rectangle(corners[0], corners[1])
    }
    
    static void printPosition(Rectangle.POS position, String name="rectangle") {
        switch (position) {
            case Rectangle.POS.IN:
                printResult("It is inside the " + name)
                break
            case Rectangle.POS.OUT:
                printResult("It is outside the " + name)
                break
            case Rectangle.POS.BORDER:
                printResult("It is on the border of the " + name)
                break
        }
    }
    
    static void printRectangle(Rectangle r, String name="Rectangle") {
        String msg = name + " is between " + r.upLeft.getString() + " and " + r.downRight.getString()
        printResult(msg)
    }
}