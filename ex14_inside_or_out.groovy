Rectangle r = IORectangle.getRectangle()
MyVector v = IOVector.getVector()

switch (r.getPosition(v)) {
    case Rectangle.POS.IN:
        println "It is inside!"
        break
    case Rectangle.POS.OUT:
        println "It is outside!"
        break
    case Rectangle.POS.BORDER:
        println "It is on the rectangle's border!"
        break
}