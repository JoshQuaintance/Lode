import fetcher.fetchFile

fun main(args: Array<String>) {
    val flags = args.filter { it.startsWith('-') }

    if (args.isEmpty() || !args[0].endsWith(".lode")) {

        shell()

    } else {
        fileInput()
    }
}

// If a file is given
fun fileInput() {
//
//    println(fetchFile(fileArg).split('\n'))

}

fun test() {
    // Run some tests here
}

