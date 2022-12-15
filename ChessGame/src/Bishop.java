public class Bishop extends Piece {
    public String getName(){
        return "BISHOP";
    }
    public Bishop(String color){
        super(color);
    }
    public boolean isLegalMove(Board board,Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor) {
        return Rules.squaresDiagonally(sourceCoordinate,destinationCoordinate);
    }
    public boolean isClearWay(Board board , Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        boolean pass =true;
        int countSquareXCoordinate = sourceCoordinate.getX();
        int countSquareYCoordinate = sourceCoordinate.getY();
            if((destinationCoordinate.getY() > sourceCoordinate.getY()) && (destinationCoordinate.getX() > sourceCoordinate.getX()))
                pass = ClearWay.upRightDiagonalSquares(countSquareXCoordinate, countSquareYCoordinate, destinationCoordinate, board);
            if ((destinationCoordinate.getY() > sourceCoordinate.getY()) && (destinationCoordinate.getX() < sourceCoordinate.getX()))
                pass = ClearWay.upLeftDiagonalSquares(countSquareXCoordinate, countSquareYCoordinate, destinationCoordinate, board);
            else if ((destinationCoordinate.getY() < sourceCoordinate.getY()) && (destinationCoordinate.getX() < sourceCoordinate.getX()))
                pass = ClearWay.downLeftDiagonalSquares(countSquareXCoordinate, countSquareYCoordinate, destinationCoordinate, board);
            else if ((destinationCoordinate.getY() < sourceCoordinate.getY()) && (destinationCoordinate.getX() > sourceCoordinate.getX()))
                pass = ClearWay.downRightDiagonalSquares(countSquareXCoordinate, countSquareYCoordinate, destinationCoordinate, board);

        return pass;
    }
}
