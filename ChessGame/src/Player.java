import java.util.Scanner;
public class Player {
    private final String name;
    private final String color ;
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public String getName(){
        return name ;
    }
    public String getColor(){
        return color ;
    }
    public Coordinates[] input(Board board){
        Scanner in = new Scanner(System.in);
        Coordinates sourceCoordinate;
        Coordinates destinationCoordinate ;

        while (true){

            System.out.print("Enter next move "+name+"("+color+")"+" :");
            String nextMove = in.nextLine();
            if(nextMove.length() != 10){
                System.out.println("invalid Input try again "+name+" !");
                continue;
            }

            int sourceXCoordinates =CharCoordinateConverter.getCoordinatesInt(nextMove.substring(5,7).charAt(0));
            int sourceYCoordinates =CharCoordinateConverter.getCoordinatesInt(nextMove.substring(5,7).charAt(1));
            int destinationXCoordinates =CharCoordinateConverter.getCoordinatesInt(nextMove.substring(8,10).charAt(0));
            int destinationYCoordinates =CharCoordinateConverter.getCoordinatesInt(nextMove.substring(8,10).charAt(1));


            sourceCoordinate = new Coordinates(sourceXCoordinates,sourceYCoordinates);
            destinationCoordinate = new Coordinates(destinationXCoordinates,destinationYCoordinates);
            if(!sourceCoordinate.isValid() && !destinationCoordinate.isValid())
            {
                System.out.println("invalid Input try again "+name+" !");
                continue;
            }
                break;
        }
        return new Coordinates[]{sourceCoordinate,destinationCoordinate};

    }
    public Piece promotion(Piece piece){
        Scanner in = new Scanner(System.in);
        System.out.print("choose number of piece you want to replace with pawn (1.queen 2.rook 3.bishop 4.knight) :");
        int number = Integer.parseInt(in.nextLine());
        if(number==1)
            piece = new Queen(piece.getColor());
        else if (number==2)
            piece = new Rook(piece.getColor());
        else if(number==3)
            piece =new Bishop(piece.getColor());
        else if(number==4)
            piece =new knight(piece.getColor());
        return piece ;
    }

    public void move(Coordinates sourceCoordinate, Coordinates destinationCoordinate,Board board){
        if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo instanceof king) {
            ((king)board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo).kingPosition.setY(destinationCoordinate.getY());
            ((king)board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo).kingPosition.setX(destinationCoordinate.getX());
            if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].equals("black"))
                Controller.isKingsMoved[0] =true;
            else
                Controller.isKingsMoved[1] =true;
        }
        else if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo instanceof Rook)
        {
           if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.getColor().equals("black")) {
               if(sourceCoordinate.getY() ==7 && sourceCoordinate.getX()==0)
               Controller.isBlackRookMoved[0]=true;
               else if(sourceCoordinate.getY() ==7 && sourceCoordinate.getX()==7)
                   Controller.isBlackRookMoved[1]=true;
            }
           else {
               if(sourceCoordinate.getY() ==0 && sourceCoordinate.getX()==0)
                   Controller.isWhitRookMoved[0]=true;
               else if(sourceCoordinate.getY() ==0 && sourceCoordinate.getX()==7)
                   Controller.isWhitRookMoved[1]=true;
           }
        }
         if(board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo instanceof king) {
            if (board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo.getColor().equals("white"))
                Controller.wightKing = null;
            else
                Controller.blackKing = null;
        }
        else if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo instanceof Pawn)
        {
            if(Controller.isUpgradable(board,sourceCoordinate,destinationCoordinate))
            {
                board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo=promotion(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo);
            }
            else if(Controller.isUpgradable(board,sourceCoordinate,destinationCoordinate))
            {
                board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo=promotion(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo);
            }
        }
        board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo = board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo;
        board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo =null;
    }
}
