package utils

class Line (
   private val P_content: String,
   private var P_currChar: Char? = P_content[0],
   private var P_currX: Int = 0,
) {

   val tokenizedValues: MutableList<Token> = mutableListOf()

   fun nextChar() {
      this.P_currX++;

      this.P_currChar = if (this.P_currX < this.P_content.length) this.P_content[P_currX] else null
      if (this.P_currChar != null) Position.incX()
   }

   fun restart() {
      this.P_currX = 0;

      this.P_currChar = this.P_content[this.P_currX]
   }

   val xPos get() = this.P_currX
   val currChar get() = this.P_currChar
   val content get() = this.P_content
}
