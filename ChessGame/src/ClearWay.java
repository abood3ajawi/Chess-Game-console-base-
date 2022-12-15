public class ClearWay {
    static public boolean upVerticalSquares(int countSquareYCoordinate, Coordinates destinationCoordinate , Board board){
        boolean pass = true;
        while (countSquareYCoordinate < destinationCoordinate.getY()) {
            countSquareYCoordinate++;
            if(countSquareYCoordinate ==destinationCoordinate.getY()) break;
            if(board.getSquare()[countSquareYCoordinate][destinationCoordinate.getX()].pointTo!=null) {
                pass=false;
                break;
            }
        }
        return pass;
    }
    static public boolean downVerticalSquares(int countSquareYCoordinate, Coordinates destinationCoordinate , Board board){
        boolean pass = true;
        while (countSquareYCoordinate > destinationCoordinate.getY()) {
            countSquareYCoordinate--;
            if(countSquareYCoordinate ==destinationCoordinate.getY()) break;
            if (board.getSquare()[countSquareYCoordinate][destinationCoordinate.getX()].pointTo != null) {
                pass = false;
                break;
            }
        }
        return pass;
    }
    static public boolean upHorizontalSquares(int countSquareXCoordinate, Coordinates destinationCoordinate , Board board){
        boolean pass = true;
        while (countSquareXCoordinate < destinationCoordinate.getX()) {
            countSquareXCoordinate++;
            if(countSquareXCoordinate ==destinationCoordinate.getX()) break;
            if(board.getSquare()[destinationCoordinate.getY()][countSquareXCoordinate].pointTo!=null) {
                pass=false;
                break;
            }
        }
        return pass;
    }
    static public boolean downHorizontalSquares(int countSquareXCoordinate, Coordinates destinationCoordinate , Board board){
        boolean pass = true;
        while (countSquareXCoordinate > destinationCoordinate.getX()) {
            countSquareXCoordinate--;
            if(countSquareXCoordinate ==destinationCoordinate.getX()) break;
            if(board.getSquare()[destinationCoordinate.getY()][countSquareXCoordinate].pointTo!=null) {
                pass=false;
                break;
            }
        }
        return pass;
    }
    static public boolean  upRightDiagonalSquares(int sourceXCoordinate,int sourceYCoordinate, Coordinates destinationCoordinate , Board board){
        boolean pass =true;
      while (destinationCoordinate.getX()>sourceXCoordinate && destinationCoordinate.getY()>sourceYCoordinate){
          sourceXCoordinate++;
          sourceYCoordinate++;
          if(sourceXCoordinate ==destinationCoordinate.getX()) break;
          if(board.getSquare()[sourceYCoordinate][sourceXCoordinate].pointTo != null){
              pass= false;
              break;
          }
      }
        return pass;
    }
    static public boolean  upLeftDiagonalSquares(int sourceXCoordinate,int sourceYCoordinate, Coordinates destinationCoordinate , Board board){
        boolean pass =true;
        while (sourceXCoordinate>destinationCoordinate.getX() && sourceYCoordinate<destinationCoordinate.getY() ){
            sourceXCoordinate--;
            sourceYCoordinate++;
            if(sourceXCoordinate ==destinationCoordinate.getX()) break;
            if(board.getSquare()[sourceYCoordinate][sourceXCoordinate].pointTo != null){
                pass= false;
                break;
            }
        }
        return pass;
    }
    static public boolean  downRightDiagonalSquares(int sourceXCoordinate,int sourceYCoordinate, Coordinates destinationCoordinate , Board board){
        boolean pass =true;
        System.out.println(sourceXCoordinate>destinationCoordinate.getX());

        while (sourceXCoordinate<destinationCoordinate.getX() && sourceYCoordinate>destinationCoordinate.getY() ){
            sourceXCoordinate++;
            sourceYCoordinate--;
            if(sourceXCoordinate ==destinationCoordinate.getX()) break;
            if(board.getSquare()[sourceYCoordinate][sourceXCoordinate].pointTo != null){
                pass= false;
                break;
            }
        }
        return pass;
    }
    static public boolean  downLeftDiagonalSquares(int sourceXCoordinate,int sourceYCoordinate, Coordinates destinationCoordinate , Board board){
        boolean pass =true;
        while (sourceXCoordinate>destinationCoordinate.getX() && sourceYCoordinate>destinationCoordinate.getY() ){
            sourceXCoordinate--;
            sourceYCoordinate--;
            if(sourceXCoordinate ==destinationCoordinate.getX()) break;
            if(board.getSquare()[sourceYCoordinate][sourceXCoordinate].pointTo != null){
                pass= false;
                break;
            }
        }
        return pass;
    }

}
