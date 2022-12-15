public class Rook extends Piece{

    public String getName(){
        return "ROOK";
    }
    public Rook(String color){
        super(color);
    }
    public boolean isLegalMove(Board board ,Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor) {
       boolean pass = false ;
       if(Rules.squaresHorizontally(sourceCoordinate,destinationCoordinate))
           pass =true;
       else if (Rules.squaresVertically(sourceCoordinate,destinationCoordinate))
           pass=true;
       return pass;
    }
    public boolean isClearWay(Board board , Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        boolean pass =true;
        int countSquareXCoordinate = sourceCoordinate.getX();
        int countSquareYCoordinate = sourceCoordinate.getY();
        if(sourceCoordinate.getY()-destinationCoordinate.getY()==0) {
            if(sourceCoordinate.getX() < destinationCoordinate.getX()) {
                pass = ClearWay.upHorizontalSquares(countSquareXCoordinate,destinationCoordinate,board);
            }
            else{
                pass = ClearWay.downHorizontalSquares(countSquareXCoordinate,destinationCoordinate,board);
            }
        }
        else if(sourceCoordinate.getX() - destinationCoordinate.getX()==0) {
            if(sourceCoordinate.getY() < destinationCoordinate.getY()){
                pass = ClearWay.upVerticalSquares(countSquareYCoordinate,destinationCoordinate,board);
            }
            else {
                pass = ClearWay.downVerticalSquares(countSquareYCoordinate,destinationCoordinate,board);
            }
        }
        return pass;
    }
}
