package utils

class Position (
    private var x: Int = 0,
    private var y: Int = 0,
) {

    val getX get() = this.x
    val getY get() = this.y

    companion object {
        private var x = 0
        private var y = 0

        val getX get() = this.x
        val getY get() = this.y

        fun incX() = this.x++
        fun incY() = this.y++

        fun reset() {
            this.x = 0
            this.y = 0
        }

        override fun toString(): String{
            return "row $y, column $x"
        }


    }
}