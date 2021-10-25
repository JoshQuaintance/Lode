package fetcher

import java.io.File
import java.io.InputStream

fun fetchFile(filename: String): String {

    val inputStream: InputStream = File(filename).inputStream()

    return inputStream.bufferedReader().use { it.readText() }
}