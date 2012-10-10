/*
 * OK, so I complicated this.  I didn't need to create an intersection
 * rectangle but by doing so I can test if the point is on the intersection's
 * border.  So at least I've added functionality!
*/

Rectangle r1 = IORectangle.getRectangle()
r1.name = "First rectangle"
Rectangle r2 = IORectangle.getRectangle()
r2.name = "Second rectangle"

Rectangle intersection = r1.intersection(r2)
IORectangle.printRectangle(intersection, "Overlap rectangle")
println "Now enter the vector to test for inclusion in these rectangles:"

MyVector v = IOVector.getVector()
def pos

for (test_rect in [intersection, r1, r2]) {
    pos = test_rect.getPosition(v)
    if (pos != Rectangle.POS.OUT) {
        IORectangle.printPosition(pos, test_rect.name)
        break
    }
}