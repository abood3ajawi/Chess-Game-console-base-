public class knight extends Piece  {
    public String getName(){
        return "KNIGHT";
    }
    public knight(String color){
        super(color);
    }
    public boolean isLegalMove(Board board ,Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor) {
        return Rules.lPattern(sourceCoordinate,destinationCoordinate);
    }
    public boolean isClearWay(Board board , Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        return true;
    }
}
