public class Pawn extends Piece {
    public String getName(){
        return "Pawn";
    }
    public Pawn(String color){
        super(color);
    }
    public boolean isLegalMove(Board board ,Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor) {
       boolean pass =false;
        if(Rules.forwardVerticalOneSquare(sourceCoordinate,destinationCoordinate,playerColor) )
            pass = true;
        else if(Rules.forwardVerticalTwoSquare(sourceCoordinate,destinationCoordinate,playerColor))
            pass = true ;
        else if( !Validation.isEmptySquare(board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo) && !Validation.isThisMySoldiers(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.getColor(), board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo.getColor())){
           if(Rules.forwardDiagonalOneSquare(sourceCoordinate,destinationCoordinate,playerColor))
                pass =true;
        }
        return pass;
    }
    public boolean isClearWay(Board board , Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        boolean pass ;
        if(destinationCoordinate.getY() - sourceCoordinate.getY() == 2){
           pass = (ClearWay.upVerticalSquares(sourceCoordinate.getY(),destinationCoordinate,board) && (board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo==null));
        }
        else if(destinationCoordinate.getY() - sourceCoordinate.getY() ==-2)
           pass = (ClearWay.downVerticalSquares(sourceCoordinate.getY(),destinationCoordinate,board) && (board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo==null));
        else if ((Math.abs(destinationCoordinate.getY() - sourceCoordinate.getY()) == 1) && (destinationCoordinate.getX() - sourceCoordinate.getX()==0) )
            pass =(board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo==null);
        else
          pass =true;

        return pass;
    }
}
