import kotlin.math.ceil

fun main(args: Array<String>) {
    println("Hello World!")

    val original = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val row = 3
    val column = 5

    val hTempList = List(3) { mutableListOf<Pair<Int, Int>>() }
    val vTempList = List(ceil(original.size / column.toFloat()).toInt()) { mutableListOf<Pair<Int, Int>>() }


    original.onEachIndexed { index, i ->
        val rowIndex = index % row
        val columnList = hTempList[rowIndex]
        columnList.add(Pair(index, i))
    }
    println("横向滚动：$hTempList")


    original.onEachIndexed { index, i ->
        val columnIndex = index / column
        val rowList = vTempList[columnIndex]
        rowList.add(Pair(index, i))
    }

    println("纵向滚动：$vTempList")


    val sTempList = List(ceil(original.size / (column * row).toFloat()).toInt()) { mutableListOf<Pair<Int, Int>>() }

    original.onEachIndexed { index, i ->
        val screenIndex = index / (column * row)
        val screenList = sTempList[screenIndex]
        screenList.add(Pair(index, i))
    }

    println("分屏：$sTempList")



    sTempList.map {

    }

    /*val result = MutableList(original.size) { 0 }

    hTempList.flatten().onEach {
        result[it.first] = it.second
    }

    println(result)*/

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    // println("Program arguments: ${args.joinToString()}")
}