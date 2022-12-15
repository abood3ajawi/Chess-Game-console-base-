import java.util.Scanner;
public class ChessGame {
    private final Player player1 ;
    private final Player player2 ;
    private final Controller judgment ;
    private final Board board ;
    private final Piece[] blackPieces = new Piece[16];
    private final Piece[] whitePieces = new Piece[16];
    public ChessGame(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the white player name:");
        String whitePlayer = in.nextLine();
        System.out.print("Enter the black player name:");
        String blackPlayer = in.nextLine();
        player1 = new Player(whitePlayer,"white");
        player2 = new Player(blackPlayer,"black");
        String white="white";
        String black="black";
        blackPieces[0] = new Rook(black);
        whitePieces[0] = new Rook(white);
        blackPieces[1] = new knight(black);
        whitePieces[1] = new knight(white);
        blackPieces[2] = new Bishop(black);
        whitePieces[2] = new Bishop(white);
        blackPieces[3] = new Queen(black);
        whitePieces[3] = new Queen(white);
        blackPieces[5] = new Bishop(black);
        whitePieces[5] = new Bishop(white);
        blackPieces[6] = new knight(black);
        whitePieces[6] = new knight(white);
        blackPieces[7] = new Rook(black);
        whitePieces[7] = new Rook(white);
        blackPieces[4] = new king(black,4,7);
        whitePieces[4] = new king(white,4,0);
        Controller.setBlackKing((king) blackPieces[4]);
        Controller.setWightKing((king)whitePieces[4]);
        for (int i =8;i<16;i++){
            whitePieces[i] = new Pawn(black);
            blackPieces[i] = new Pawn(white);
        }
        board = new Board(whitePieces, blackPieces);
        judgment= new Controller();
    }
    public void play(Player player){
       if(player.getColor().equals("black") && !Controller.getKingsMoved()[0] && (!Controller.getBlackRookMoved()[0]||!Controller.getBlackRookMoved()[1])) {
           if(Controller.doCastling(board,player))
               return;
       }
       else if(player.getColor().equals("white")&&  !Controller.getKingsMoved()[1] && (!Controller.getWhitRookMoved()[0]||!Controller.getWhitRookMoved()[1])) {
           if(Controller.doCastling(board,player))
               return;

       }
        Coordinates[] coordinate;
        do {
            coordinate = player.input(board);
        } while (!judgment.canMove(board, coordinate[0], coordinate[1], player));
        System.out.println(Controller.getBlackKing());
        player.move(coordinate[0],coordinate[1],board);

        if(Controller.getWightKing()==null || Controller.getBlackKing()==null)
            return;

        if(judgment.checkMate(board,coordinate[1],(player.getColor().equals("white")?Controller.getBlackKing().kingPosition:Controller.getWightKing().kingPosition),player)){
            System.out.println("CheckMate "+(player.getColor().equals(player1.getColor())?player2.getName():player1.getColor()));
        }
    }
    public void start(){
        while (true) {
            board.chessBoardSimulator();
            if (judgment.getTurn()) {
                play(player1);
                System.out.println(Controller.getWightKing());
                if(Controller.getBlackKing() == null) {
                    System.out.println(player1.getName()+" Win!");
                    break;
                }

            }
            else {
                play(player2);
                System.out.println(Controller.getWightKing());
                if(Controller.getWightKing() == null) {
                    System.out.println(player2.getName()+" Win!");
                    break;
                }
            }
            judgment.changeTurn();
            if(judgment.getNumberOFMovement() >50)
            {
                System.out.println("draw!!!!!!!!!!!!!!");
            }
            judgment.increaseNumberOfMovements();
        }
    }
}
