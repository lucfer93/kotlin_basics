package tictactoe

fun main() {

    var playerXHasWon = false
    var playerOHasWon = false
    var draw = false
    var gameOver = false
    var gameStateIsImpossible = false
    var xTurns = 0
    var oTurns = 0

    val input = "_________"
    val inputArray = input.toCharArray()
    val chunkedInputList = input.chunked(3)
    var totalCharArraysList = mutableListOf<CharArray>()


    println("---------")
    for (i in 0..2) {
        val charArrayFromInput = chunkedInputList[i].toCharArray()
        totalCharArraysList.add(charArrayFromInput)
        print("| ")
        print("${charArrayFromInput[0]} ${charArrayFromInput[1]} ${charArrayFromInput[2]} ")
        print("| ")
        println()
    }
    println("---------")


    while (!gameOver) {
        println("Enter the coordinates: ")
        val promptedCoordinates = readLine()!!.split(" ")
        val coordinatesAsInts = mutableListOf<Int>()

        try {
            for (i in promptedCoordinates.indices) {
                coordinatesAsInts.add(promptedCoordinates[i].toInt())
            }
            if (coordinatesAsInts[0] !in 1..3 || coordinatesAsInts[1] !in 1..3) {
                println("Coordinates should be from 1 to 3!")
                continue
            }

            if (totalCharArraysList[promptedCoordinates[0].toInt() - 1][promptedCoordinates[1].toInt() - 1] == '_') {
                if (xTurns == oTurns) {
                    totalCharArraysList[promptedCoordinates[0].toInt() - 1][promptedCoordinates[1].toInt() - 1] = 'X'
                    xTurns += 1
                } else if (oTurns + 1 == xTurns){
                    totalCharArraysList[promptedCoordinates[0].toInt() - 1][promptedCoordinates[1].toInt() - 1] = 'O'
                    oTurns += 1
                }
            } else {
                if (totalCharArraysList[promptedCoordinates[0].toInt() - 1][promptedCoordinates[1].toInt() - 1] != '_') {
                    println("This cell is occupied! Choose another one!")
                }
            }
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
        }

        println("---------")

        for (i in totalCharArraysList.indices) {
            print("| ")
            print("${totalCharArraysList[i][0]} ${totalCharArraysList[i][1]} ${totalCharArraysList[i][2]} ")
            print("| ")
            println()
        }

        println("---------")

        if (totalCharArraysList[0][0] == 'X' && totalCharArraysList[0][1] == 'X' && totalCharArraysList[0][2] == 'X') {
            playerXHasWon = true
        }
        if (totalCharArraysList[1][0] == 'X' && totalCharArraysList[1][1] == 'X' && totalCharArraysList[1][2] == 'X') {
            playerXHasWon = true
        }
        if (totalCharArraysList[2][0] == 'X' && totalCharArraysList[2][1] == 'X' && totalCharArraysList[2][2] == 'X') {
            playerXHasWon = true
        }
        if (totalCharArraysList[0][0] == 'X' && totalCharArraysList[1][0] == 'X' && totalCharArraysList[2][0] == 'X') {
            playerXHasWon = true
        }
        if (totalCharArraysList[0][1] == 'X' && totalCharArraysList[1][1] == 'X' && totalCharArraysList[2][1] == 'X') {
            playerXHasWon = true
        }
        if (totalCharArraysList[0][2] == 'X' && totalCharArraysList[1][2] == 'X' && totalCharArraysList[2][2] == 'X') {
            playerXHasWon = true
        }
        if (totalCharArraysList[0][0] == 'X' && totalCharArraysList[1][1] == 'X' && totalCharArraysList[2][2] == 'X') {
            playerXHasWon = true
        }
        if (totalCharArraysList[0][2] == 'X' && totalCharArraysList[1][1] == 'X' && totalCharArraysList[2][0] == 'X') {
            playerXHasWon = true
        }
        if (totalCharArraysList[0][0] == 'O' && totalCharArraysList[0][1] == 'O' && totalCharArraysList[0][2] == 'O') {
            playerOHasWon = true
        }
        if (totalCharArraysList[1][0] == 'O' && totalCharArraysList[1][1] == 'O' && totalCharArraysList[1][2] == 'O') {
            playerOHasWon = true
        }
        if (totalCharArraysList[2][0] == 'O' && totalCharArraysList[2][1] == 'O' && totalCharArraysList[2][2] == 'O') {
            playerOHasWon = true
        }
        if (totalCharArraysList[0][0] == 'O' && totalCharArraysList[1][0] == 'O' && totalCharArraysList[2][0] == 'O') {
            playerOHasWon = true
        }
        if (totalCharArraysList[0][1] == 'O' && totalCharArraysList[1][1] == 'O' && totalCharArraysList[2][1] == 'O') {
            playerOHasWon = true
        }
        if (totalCharArraysList[0][2] == 'O' && totalCharArraysList[1][2] == 'O' && totalCharArraysList[2][2] == 'O') {
            playerOHasWon = true
        }
        if (totalCharArraysList[0][0] == 'O' && totalCharArraysList[1][1] == 'O' && totalCharArraysList[2][2] == 'O') {
            playerOHasWon = true
        }
        if (totalCharArraysList[0][2] == 'O' && totalCharArraysList[1][1] == 'O' && totalCharArraysList[2][0] == 'O') {
            playerOHasWon = true
        }

        if (totalCharArraysList[0][0] != '_' && totalCharArraysList[0][1] != '_' && totalCharArraysList[0][2] != '_' &&
            totalCharArraysList[1][0] != '_' && totalCharArraysList[1][1] != '_' && totalCharArraysList[1][2] != '_' &&
            totalCharArraysList[2][0] != '_' && totalCharArraysList[2][1] != '_' && totalCharArraysList[2][2] != '_' &&
            !playerXHasWon && !playerOHasWon
        ) {
            draw = true
        }

        if (playerXHasWon && playerOHasWon) {
            gameStateIsImpossible = true
        }

        var xCounter = 0
        var oCounter = 0
        var underscoreCounter = 0

        for (i in inputArray) {
            when (i) {
                'X' -> xCounter++
                'O' -> oCounter++
                '_' -> underscoreCounter++
            }
        }

        if (xCounter in oCounter..oCounter + 1 || xCounter in oCounter - 1..oCounter) {
            //
        } else {
            gameStateIsImpossible = true
        }

        if (gameStateIsImpossible) {
            playerXHasWon = false
            playerOHasWon = false
            draw = false
            gameOver = false
            println("Impossible")
        }

        if (playerXHasWon) {
            println("X wins")
            break
        }

        if (playerOHasWon) {
            println("O wins")
            break
        }

        if (draw) {
            println("Draw")
            break
        }

        if (gameOver) {
            println("Game not finished")
        }
    }
}
