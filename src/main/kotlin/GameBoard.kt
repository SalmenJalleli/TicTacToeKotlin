import kotlin.math.pow

class GameBoard(private val n:Int){
    private val empty="___"
    private var board = Array(n){Array(n){empty}}
    private var moveCounter = 0
    var gameIsOver=false
    fun resetBoard (){
        board = Array(n){Array(n){empty}}
    }
    fun displayBoard(){
        println()
        board.forEach {
            row -> row.forEach {
                element -> if (element==empty){
                    print("|$element|")
                }else{
                    print("| $element |")
                }
            }
            println()
        }
        println()
    }
    fun placeSign(x:Int, y:Int, move:String){
        if(!gameIsOver
            && board[x][y]==empty
            && isPositionValid(x,y)){
            moveCounter++
            board[x][y]=move
            displayBoard()
            gameIsOver = isWinningMove(x,y,move) || isDraw()
            if (gameIsOver && !isDraw()){
                println("We have a winner!")
            }else if (isDraw()){
                println("That's a tie!")
            }
        }
    }
    private fun isPositionValid(x:Int, y:Int):Boolean{
        return ((x in 0..<n) && (y in 0..<n))
    }
    fun resetGame(){
        resetBoard()
        gameIsOver=false
        moveCounter=0
    }
    private fun isWinningMove(x:Int,y:Int,move:String):Boolean{
        //check the rows
        for(i in 0..<n){
            if (board[x][i]!==move)
                break
            if (i==n-1)
                return true
        }
        //check the columns
        for (i in 0..<n){
            if(board[i][y]!==move){
                break
            }
            if (i==n-1)
                return true
        }
        //check the diagonal
        if (x==y){
            for(i in 0..<n){
                if (board[i][i]!=move)
                    break
                if (i==n-1)
                    return true
            }
        }
        //check antidiagonal move
        if ((x+y)==n-1){
            for(i in 0..<n){
                if (board[i][(n-1)-i]!==move)
                    break
                if(i==n-1)
                    return true
        }
        }
        return false
    }
    fun isDraw():Boolean {
         return ((n.toDouble().pow(2)).toInt()-1==moveCounter)
    }
}