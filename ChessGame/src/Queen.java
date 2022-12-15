public class Queen extends Piece {
    public String getName(){
        return "Queen";
    }
    public Queen(String color){
        super(color);
    }
    public boolean isLegalMove(Board board ,Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor) {
        boolean pass =false;
        if(Rules.squaresHorizontally(sourceCoordinate,destinationCoordinate))
            pass =true;
        else if (Rules.squaresVertically(sourceCoordinate,destinationCoordinate))
            pass=true;
        else if(Rules.squaresDiagonally(sourceCoordinate,destinationCoordinate))
            pass =true;
         return pass;
    }
    public boolean isClearWay(Board board , Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        boolean pass =true;
        int countSquareXCoordinate = sourceCoordinate.getX();
        int countSquareYCoordinate = sourceCoordinate.getY();
        if(sourceCoordinate.getY()-destinationCoordinate.getY()==0) {
            if(sourceCoordinate.getX() < destinationCoordinate.getX())
                pass = ClearWay.upHorizontalSquares(countSquareXCoordinate,destinationCoordinate,board);
            else
                pass = ClearWay.downHorizontalSquares(countSquareXCoordinate,destinationCoordinate,board);
        }
        else if(sourceCoordinate.getX() - destinationCoordinate.getX()==0) {
            if(sourceCoordinate.getY() < destinationCoordinate.getY())
                pass = ClearWay.upVerticalSquares(countSquareYCoordinate,destinationCoordinate,board);
            else
                pass = ClearWay.downVerticalSquares(countSquareYCoordinate,destinationCoordinate,board);
        }
        else if((destinationCoordinate.getY() -sourceCoordinate.getY())/(destinationCoordinate.getX()-sourceCoordinate.getX())==1)
            pass = ClearWay.upRightDiagonalSquares(countSquareXCoordinate ,countSquareYCoordinate  ,destinationCoordinate ,board);
        else if((destinationCoordinate.getY()-sourceCoordinate.getY())/(destinationCoordinate.getX()-sourceCoordinate.getX())==-1) {
            if ((destinationCoordinate.getY() > sourceCoordinate.getY()) && (destinationCoordinate.getX() < sourceCoordinate.getX()))
                pass = ClearWay.upLeftDiagonalSquares(countSquareXCoordinate, countSquareYCoordinate, destinationCoordinate, board);
            else if ((destinationCoordinate.getY() < sourceCoordinate.getY()) && (destinationCoordinate.getX() < sourceCoordinate.getX()))
                pass = ClearWay.downLeftDiagonalSquares(countSquareXCoordinate, countSquareYCoordinate, destinationCoordinate, board);
            else if ((destinationCoordinate.getY() > sourceCoordinate.getY()) && (destinationCoordinate.getX() > sourceCoordinate.getX()))
                pass = ClearWay.downRightDiagonalSquares(countSquareXCoordinate, countSquareYCoordinate, destinationCoordinate, board);
        }
        return pass;
    }
}
