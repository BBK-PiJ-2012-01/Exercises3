println "Enter reference point - "
MyVector reference = IOVector.getVector()
println "\nEnter three other points - "
println "ref is: " + reference.getString()
MyVector[] input_vectors = IOVector.getNVectors(3)

def shortest_vectors = MyVector.getShortestVectorsFromRef(input_vectors, reference)


if (shortest_vectors.size() == 1)
    IOVector.printVector(shortest_vectors[0], "Closest point was: ")
else
    IOVector.printVectors(shortest_vectors, "These " + shortest_vectors.size() + " were the closest:")