class RoundingMixin {
    public BigDecimal precision(int n) {
        return setScale(n, BigDecimal.ROUND_HALF_DOWN)
    }
    
    public BigDecimal trunc(int n) {
        return setScale(n, BigDecimal.ROUND_DOWN)
    }
}

BigDecimal.mixin RoundingMixin

class CashTill {
    static BigDecimal[] notes = [50, 20, 10, 5]
    static BigDecimal[] coins = [2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01]
    BigDecimal change_to_give
    
    void sale(BigDecimal amount, BigDecimal cash_given) {
        // First check that amount and cash_given are multiples
        // of pennies
        amount = checkValidValue(amount)
        cash_given = checkValidValue(cash_given)
        
        change_to_give = cash_given - amount
        if (change_to_give < 0)
            throw new BadInput("Given " + cash_given + ", needed " + amount)
            
        def notes_needed = reduceWithCurrency(CashTill.notes)
        def coins_needed = reduceWithCurrency(CashTill.coins)
        
        if (!notes_needed.isEmpty()) {
            println "Here are your notes..."
            printMap(notes_needed)
        }
        
        if (!coins_needed.isEmpty()) {
            println "Here are your coins:"
            printMap(coins_needed)
        }
        
        if (notes_needed.isEmpty() && coins_needed.isEmpty())
            println "You gave me exact change."
    }
        
    def reduceWithCurrency(BigDecimal[] currency_list) {
        int quantity_needed
        def currency_needed = [:]
        
        for (value in currency_list) {
            quantity_needed = (change_to_give/value).intValue()
            if (quantity_needed > 0) {
                currency_needed[value] = quantity_needed
                change_to_give -= value * quantity_needed
            }
        }
        return currency_needed
    }
    
    def printMap(def map) {
        for (item in map) {
            if (item.value != 0)
                println item.value + " x "  + item.key
        }
    }
    
    BigDecimal checkValidValue(BigDecimal value) {
        if (value < 0)
            throw new BadInput(value)
        return value.precision(2)
    }
}

c = new CashTill()

print "Enter the amount of the sale: "
BigDecimal amount = IOGeneric.getDouble()
print "Enter the cash given: "
BigDecimal cash_given = IOGeneric.getDouble()

c.sale(amount, cash_given)