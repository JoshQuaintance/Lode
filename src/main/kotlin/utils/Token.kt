package utils

class Token(
    private val P_content: Any?,
    val type: String,

) {
    override fun toString(): String {
        return "(${this.P_content.toString()}, ${this.type})"
    }
}