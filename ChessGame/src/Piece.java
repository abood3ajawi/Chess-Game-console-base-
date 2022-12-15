public abstract class Piece {
    final String colorPiece;
    protected Piece(String color){
        colorPiece=color;
    }
    public abstract String getName();
    public String getColor(){
        return  colorPiece;
    }
    public abstract boolean isLegalMove(Board board ,Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor);
    public abstract boolean isClearWay(Board board , Coordinates sourceCoordinate, Coordinates destinationCoordinate);
}
