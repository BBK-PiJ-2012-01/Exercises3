class IORectangle extends IOGeneric {
    static Rectangle getRectangle() {
        println "Enter the coords of two corners of the rectangle:"
        def corners = IOVector.getNVectors(2)
        
        if (corners[0].x > corners[1].x)
            corners[0].swapX(corners[1])
        else if (corners[0].x == corners[1].x)
            throw new BadInput("Corners can't have same x value")

        if (corners[0].y < corners[1].y)
            corners[0].swapY(corners[1])
        else if (corners[0].y == corners[1].y)
            throw new BadInput("Corners can't have same y value")
        
        return new Rectangle(corners[0], corners[1])
    }
}