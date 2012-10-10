class BadInput extends Exception {
    BadInput(def value) {
        println "======= Input error: \"" + value + "\" ======="
    }
    
    BadInput() {
        println "Bad input given!"
    }
}