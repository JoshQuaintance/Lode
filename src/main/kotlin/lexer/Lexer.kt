package lexer

import utils.Line
import utils.Position
import utils.Token

fun lexer(input: String) {

    Position.reset()
    var temp = ""
    val line = Line(input)

    while (line.currChar != null) {

        // If it's a space then tokenize everything in temp
        if (line.currChar in listOf(' ', ';')) {
            parseTemp(temp, line)

            line.nextChar()
            temp = ""
            continue
        }

        if (line.currChar == '"') {
            line.tokenizedValues.add(scanStringLiteral(line))

            line.nextChar()
            continue
        }

        temp += line.currChar
        line.nextChar()
        
    }

    if (temp != "") {
        parseTemp(temp, line)
    }

    println(line.tokenizedValues)

}

fun parseTemp(tempStr: String, line: Line) {
    if (tempStr.isEmpty())
        return

    if (tempStr[0].isDigit()) {
        line.tokenizedValues.add(scanNumber(tempStr))
        return
    }

    throw Error("Value '${tempStr}' isn't referenced || $Position")
}

fun scanNumber(str: String): Token {
    if (str.count { it == '.'} > 1) {

        throw Error("Too much decimal point at $Position")

    }

    if (str.endsWith('f'))
        return Token(str.toFloat(), "Float")

    if (str.count { it == '.' } == 1)
        return Token(str.toDouble(), "Double")

    return Token(str.toInt(), "Int")


}

fun scanStringLiteral(line: Line): Token {
    var scannedString = ""

    line.nextChar()

    while (line.currChar !in listOf('"', '\n', null)) {
        scannedString += line.currChar
        line.nextChar()
    }

    if (line.currChar in listOf('\n', null)) {
        // TODO Change into SyntaxError
        throw Error("Unterminated String Literal! || Change Me!!")
    }

    return Token('"' + scannedString + '"', "String")

}