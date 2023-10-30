import kotlin.math.ceil

fun main(args: Array<String>) {
    println("Hello World!")

    val original = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val row = 2
    val column = 4

    val hTempList = List(row) { mutableListOf<Pair<Int, Int>>() }
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


    val svTempList = sTempList.map {
        shMap(row, it)
    }


    println("分屏横向滚动中间态：$svTempList")

    var svResult = emptyList<List<Pair<Int, Int>>>()

    svTempList.onEach {
        svResult = if (svResult.isEmpty()) {
            it
        } else {
            svResult.zip(it) { a, b -> a.plus(b) }
        }
    }

    println("分屏排序后：${svResult.flatten()}")

    /*val result = MutableList(original.size) { 0 }

    hTempList.flatten().onEach {
        result[it.first] = it.second
    }

    println(result)*/

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    // println("Program arguments: ${args.joinToString()}")
}

private fun shMap(row: Int, mutableList: MutableList<Pair<Int, Int>>): List<List<Pair<Int, Int>>> {
    val hTempList = List(row) { mutableListOf<Pair<Int, Int>>() }
    mutableList.onEachIndexed { index, pair ->
        val rowIndex = index % row
        val columnList = hTempList[rowIndex]
        columnList.add(pair)
    }
    return hTempList
}