import java.util.Scanner
private const val player1="X"
private const val player2="O"
private var currentPlayer=""
private var gameBoard = GameBoard(0)
private var answer = ""
fun main() {
    var scanner=Scanner(System.`in`)
    println("Please print the size of the board:")
    val size = scanner.nextLine().toInt()
    gameBoard = GameBoard(size)
    gameBoard.displayBoard()
    while (!gameBoard.gameIsOver){
        takeTurns()
        println("$currentPlayer's turn")
        println("Enter row number")
        var row = scanner.nextLine().toInt()
        println("Enter column number")
        var col = scanner.nextLine().toInt()
        gameBoard.placeSign(row-1,col-1,currentPlayer)
        if(gameBoard.gameIsOver){
            println("Would you like to play again? Type y for yes or n for no:")
            answer =scanner.nextLine()
            if (isPlayingAgain(answer)){
                gameBoard.resetGame()
            }
        }
    }
}
fun takeTurns(){
    currentPlayer = if (player1 == currentPlayer){
        player2
    }else{
        player1
    }
}
fun isPlayingAgain(answer:String):Boolean{
    return (answer.equals("y",true) || answer.equals("yes",true))
}