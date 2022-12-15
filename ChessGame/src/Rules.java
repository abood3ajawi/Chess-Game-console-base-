import java.util.Objects;

public class Rules {
    static public boolean  forwardVerticalOneSquare(Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor){
        return (destinationCoordinate.getY() - sourceCoordinate.getY() == (playerColor.equals("white") ? 1 : -1)) && (sourceCoordinate.getX() == destinationCoordinate.getX());
    }
    static public boolean  oneSquareHorizontally(Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        return (sourceCoordinate.getY() == destinationCoordinate.getY()) && (Math.abs(destinationCoordinate.getX() - sourceCoordinate.getX()) == 1);
    }
    static public boolean  oneSquareVertically(Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        return (sourceCoordinate.getX() == destinationCoordinate.getX()) && (Math.abs(destinationCoordinate.getY() - sourceCoordinate.getY()) == 1);
    }
    static public boolean  forwardVerticalTwoSquare(Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor){
        return (destinationCoordinate.getY() - sourceCoordinate.getY() == (Objects.equals(playerColor, "white") ? 2 : -2)) && (sourceCoordinate.getY() == (Objects.equals(playerColor, "white") ? 1 : 6)) && (sourceCoordinate.getX() == destinationCoordinate.getX());
    }
    static public boolean  oneSquareDiagonally(Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        return (((destinationCoordinate.getX() - sourceCoordinate.getX() == 1) || (destinationCoordinate.getX() - sourceCoordinate.getX() == -1)));

    }
    static public boolean  forwardDiagonalOneSquare(Coordinates sourceCoordinate, Coordinates destinationCoordinate,String playerColor){
        return (destinationCoordinate.getY() - sourceCoordinate.getY() == (Objects.equals(playerColor, "white") ? 1 : -1)) && ((destinationCoordinate.getX() - sourceCoordinate.getX() == 1) || (destinationCoordinate.getX() - sourceCoordinate.getX() == -1));
    }
    static public boolean  squaresHorizontally(Coordinates sourceCoordinate, Coordinates destinationCoordinate ){
        return sourceCoordinate.getY() == destinationCoordinate.getY();
    }
    static public boolean  squaresVertically(Coordinates sourceCoordinate, Coordinates destinationCoordinate ){
        return sourceCoordinate.getX() == destinationCoordinate.getX();
    }
    static public boolean  squaresDiagonally(Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        boolean pass =false;
        if((destinationCoordinate.getY() -sourceCoordinate.getY() ==0) || (destinationCoordinate.getX()-sourceCoordinate.getX()==0)) return false;
        int slope = (destinationCoordinate.getY() -sourceCoordinate.getY())/(destinationCoordinate.getX()-sourceCoordinate.getX());
        if(slope == 1 || slope ==-1)
            pass=true;
        return pass;
    }
    static public boolean  lPattern(Coordinates sourceCoordinate, Coordinates destinationCoordinate){
        boolean pass =false;
        if((Math.abs(destinationCoordinate.getY()-sourceCoordinate.getY()) ==2 )) {
            if (Math.abs(destinationCoordinate.getX() - sourceCoordinate.getX()) == 1 )
                pass = true;
        }
        else if (Math.abs(destinationCoordinate.getX()-sourceCoordinate.getX()) ==2 ) {
            if(Math.abs(destinationCoordinate.getY()-sourceCoordinate.getY())==1)
                pass=true;
            }
        return pass;
    }

}
