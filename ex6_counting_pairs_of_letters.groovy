print "Enter short string to search for: "
String short_str = System.console().readLine()

print "Enter long string to search in: "
String long_str = System.console().readLine()

int difference_in_lengths = long_str.length() - short_str.length()
if (difference_in_lengths < 0)
    throw new BadInput("Short string longer than long string")
    
if (short_str.length() < 1)
    throw new BadInput("Short string is too short")
    
int count = 0
char s_ch, l_ch
for (long_str_offset in (0..difference_in_lengths)) {
    boolean match = true
    for (short_str_index in 0..short_str.length()-1) {
        //s_ch = 
        if (short_str[short_str_index] != long_str[long_str_offset+short_str_index]) {
            match = false
            break
        }
    }
    if (match)
        count++
}


println "Found short string " + count + " times in long string."
/*
 * NB. I interpretted the problem so that 'aa' would be found twice in 'aaa',
 * since the exercise didn't prohibit reusing characters.
 */