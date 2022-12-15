import java.util.Scanner;

public class Controller {
    private boolean turn ;
    private int numberOFMovement=0;
    private static king wightKing ;
    private static king blackKing ;
     static boolean[] isKingsMoved={false,false};
     static boolean[] isWhitRookMoved={false,false};
     static boolean[] isBlackRookMoved={false,false};

    public static void setWightKing(king wightKing) {
        Controller.wightKing = wightKing;
    }

    public static king getBlackKing() {
        return blackKing;
    }

    public static void setBlackKing(king blackKing) {
        Controller.blackKing = blackKing;
    }
    public static king getWightKing() {
        return wightKing;
    }


    public int getNumberOFMovement() {
        return numberOFMovement;
    }

    public void increaseNumberOfMovements() {
        this.numberOFMovement ++;
    }
    public boolean getTurn() {
        return turn;
    }
    Controller(){
        turn =true;
    }
    public void changeTurn() {
        this.turn = !turn;
    }
    public boolean canMove(Board board,Coordinates sourceCoordinate, Coordinates destinationCoordinate, Player player){
        boolean pass =false;
        if(!Validation.isEmptySquare(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo)) {
            if(Validation.isThisMySoldiers(player.getColor(), board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.getColor())){
                if(Validation.isEmptySquare(board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo) || !Validation.isThisMySoldiers(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.getColor(), board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo.getColor())){
                    if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.isLegalMove( board,sourceCoordinate, destinationCoordinate, player.getColor())) {
                        if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.isClearWay( board,sourceCoordinate, destinationCoordinate))
                           pass=true;
                        else
                            System.out.println("your way is not clear "+ board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.getName()+"! "+"try again "+player.getName());
                    }
                    else
                        System.out.println("illegal move according to piece "+ board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.getName()+" rule! try again "+player.getName() );
                }
                else
                    System.out.println(" you are try kill your "+ board.getSquare()[destinationCoordinate.getY()][destinationCoordinate.getX()].pointTo.getName()+"! "+"try again "+player.getName());
            }
            else
                System.out.println(" You are moving your opponent's piece! try again " + player.getName());
        }
        else
            System.out.println("you are try to move empty square! try again " + player.getName());
        return pass;
    }
   public boolean checkMate(Board board,Coordinates sourceCoordinate, Coordinates kingDestination, Player player){
       boolean pass =false;
               if(!Validation.isThisMySoldiers(player.getColor(), board.getSquare()[kingDestination.getY()][kingDestination.getX()].pointTo.getColor()))
                   if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.isLegalMove( board,sourceCoordinate, kingDestination, player.getColor()))
                       if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.isClearWay( board,sourceCoordinate, kingDestination))
                           pass=true;
       return pass;
   }
   static boolean isUpgradable(Board board,Coordinates sourceCoordinate,Coordinates destinationCoordinate){
        boolean pass =false;
       if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.getColor().equals("white") && destinationCoordinate.getY()==7)
           pass =true;
       else if(board.getSquare()[sourceCoordinate.getY()][sourceCoordinate.getX()].pointTo.getColor().equals("black") && destinationCoordinate.getY()==0)
           pass =true;

        return pass;
   }
    public static boolean doCastling(Board board ,Player player){
        boolean pass = false;
        Scanner in = new Scanner(System.in);
        System.out.println("castling ? (yes,no)");
        String castling = in.nextLine();
        if(castling.equals("yes"))
        {
            System.out.println("1.0-0-0 2.0-0");
            castling = in.nextLine();
            if(castling.equals("1")) {
                if (!Controller.isKingsMoved[0] && player.getColor().equals("black") && !Controller.isBlackRookMoved[0]) {
                    if (ClearWay.downHorizontalSquares(board.getSquare()[7][0].coordinates.getX(), board.getSquare()[7][4].coordinates, board)) {
                        board.getSquare()[7][3].pointTo = board.getSquare()[7][0].pointTo;
                        board.getSquare()[7][2].pointTo = board.getSquare()[7][4].pointTo;
                        board.getSquare()[7][0].pointTo = null;
                        board.getSquare()[7][4].pointTo = null;
                        Controller.isKingsMoved[0]=true;
                        Controller.blackKing.kingPosition.setY(7);
                        Controller.blackKing.kingPosition.setX(2);
                        pass=true;
                    }
                    else System.out.println("way is not clear" + player.getName());
                }
                else if (!Controller.isKingsMoved[1] && player.getColor().equals("white") && !Controller.isWhitRookMoved[0]) {
                    if (ClearWay.downHorizontalSquares(board.getSquare()[0][0].coordinates.getX(), board.getSquare()[0][4].coordinates, board)) {
                        board.getSquare()[0][3].pointTo = board.getSquare()[0][0].pointTo;
                        board.getSquare()[0][2].pointTo = board.getSquare()[0][4].pointTo;
                        board.getSquare()[0][0].pointTo = null;
                        board.getSquare()[0][4].pointTo = null;
                        Controller.isKingsMoved[0]=true;
                        Controller.wightKing.kingPosition.setY(0);
                        Controller.wightKing.kingPosition.setX(2);
                        pass=true;
                    }
                    else System.out.println("way is not clear" + player.getName());
                }
                else System.out.println("you can not castling" + player.getName());
            }
            else if(castling.equals("2")) {
                if (!Controller.isKingsMoved[1] && player.getColor().equals("black") && !Controller.isBlackRookMoved[1]) {
                    if (ClearWay.downHorizontalSquares(board.getSquare()[7][7].coordinates.getX(), board.getSquare()[7][4].coordinates, board)) {
                        board.getSquare()[7][5].pointTo = board.getSquare()[7][7].pointTo;
                        board.getSquare()[7][6].pointTo = board.getSquare()[7][4].pointTo;
                        board.getSquare()[7][4].pointTo = null;
                        board.getSquare()[7][7].pointTo = null;
                        Controller.isKingsMoved[1]=true;
                        Controller.blackKing.kingPosition.setY(7);
                        Controller.blackKing.kingPosition.setX(6);
                        pass=true;
                    }
                    else System.out.println("way is not clear" + player.getName());
                }
                else if (!Controller.isKingsMoved[1] && player.getColor().equals("white") && !Controller.isWhitRookMoved[1]) {
                    if (ClearWay.downHorizontalSquares(board.getSquare()[0][7].coordinates.getX(), board.getSquare()[0][4].coordinates, board)) {
                        board.getSquare()[0][5].pointTo = board.getSquare()[0][7].pointTo;
                        board.getSquare()[0][6].pointTo = board.getSquare()[0][4].pointTo;
                        board.getSquare()[0][4].pointTo = null;
                        board.getSquare()[0][7].pointTo = null;
                        Controller.isKingsMoved[1]=true;
                        Controller.wightKing.kingPosition.setY(0);
                        Controller.wightKing.kingPosition.setX(6);
                        pass=true;
                    }
                    else System.out.println("way is not clear" + player.getName());
                }
                else System.out.println("you can not castling" + player.getName());
            }
        }
        return pass;
    }



}
