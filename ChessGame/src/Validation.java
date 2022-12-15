public class Validation {
    static public boolean isThisMySoldiers(String playerColor,String pieceColor){
        return playerColor.equals(pieceColor);
    }
    static public boolean isEmptySquare(Piece piece){
        return piece == null;
    }


}
