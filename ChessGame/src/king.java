public class king extends Piece {
    Coordinates kingPosition ;
    public String getName(){
        return "KING";
    }
    public king(String color,int XCoordinates,int YCoordinates){
        super(color);
        kingPosition=new Coordinates(XCoordinates, YCoordinates);
    }
    public boolean isLegalMove(Board board ,Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor) {
        boolean pass =false;
        if(Rules.oneSquareHorizontally(sourceCoordinate,destinationCoordinate))
            pass =true;
        else if (Rules.oneSquareVertically(sourceCoordinate,destinationCoordinate))
            pass=true;
        else if(Rules.oneSquareDiagonally(sourceCoordinate,destinationCoordinate))
            pass =true;
        return pass;
    }
    public boolean isClearWay(Board board , Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        return true;
    }
}
