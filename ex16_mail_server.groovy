//import org.codehaus.groovy.reflection.ParameterTypes

class IOMail {
    static char[] acceptable_chars = "_.@".getChars()

    static String getEmailFromString(String str) {
        // Remove trailing and leading spaces
        str = str.trim()
        
        // Check there's only one @
        String[] elements = str.split("@")
        if (elements.size() != 2)
            return ""
            
        // Check that both elements (username and domain) are
        // longer than 0 characters
        if (elements[0].length() < 1 || elements[1].length() < 1)
            return ""
            
        // Check that all remaining characters are acceptable
        for (ch in str.getChars()) {
            if (!ch.isLetter() && !(ch in acceptable_chars) && !ch.isDigit())
                return ""    
        }
        
        return str
    }
    
    static void printEmail(MailCMD session) {
        println "from: " + session.from_address        
        println "to: " + session.to_address
        println session.data
    }
}
        
        
        

class MailCMD {
    String from_address="", to_address="", data=""
    boolean running
    
    def commands
                    
    MailCMD() {
        commands = ["MAIL FROM:":{setMailFrom(it)},
                    "RPCT TO:":{setMailTo(it)},
                    "DATA":{setData()},
                    "SEND":{send()},
                    "QUIT":{quit()}]
    }
    
    void run() {
        running = true
        println "Welcome to My Mail Server!"
        boolean cmd_found
        String input_cmd
        while(running) {
            print ">>> "
            input_cmd = System.console().readLine()
            cmd_found = false
            for (cmd in commands) {
                if (input_cmd.startsWith(cmd.key)) {
                    cmd_found = true
                    if (cmd.key.endsWith(":"))
                        cmd.value(input_cmd.split(":")[1])
                    else
                        cmd.value()
                    break
                }
            }
            if (!cmd_found)
                println "Invalid command."
        }
        println "Bye!"
    }
    
    void quit() {
        running = false
    }
    
    void send() {
            if (from_address=="" || to_address=="" || data=="") {
                println "Not enough data set."
                return
            }
            println "Sending email..."
            IOMail.printEmail(this)
            println "...done!"
    }
    
    void setMailFrom(String email_str) {
        from_address = IOMail.getEmailFromString(email_str)
        if (from_address == "")
            println "Invalid email address"
        else
            println "OK"
    }
    
    void setMailTo(String email_str) {
        to_address = IOMail.getEmailFromString(email_str)
        if (to_address == "")
            println "Invalid email address"
        else
            println "OK"
    }
    
    void setData() {
        String input_line
        def input_lines = []
        
        while(true) {
            input_line = System.console().readLine()
            if (input_line == ".")
                break
            input_lines.add(input_line)
        }
        
        data = input_lines.join("\n")
    }
}     

MailCMD mail = new MailCMD()
mail.run()