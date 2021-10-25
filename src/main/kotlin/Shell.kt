import lexer.lexer

fun shell() {

    while (true) {
        print(">> ")

        val line = readLine();

        if (line != null) {
            lexer(line)
        }
    }
}