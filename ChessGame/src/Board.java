public class Board {


    private final Square[][] square  =  new Square[8][8];

    public Square[][] getSquare() {
        return square;
    }
  public Board(Piece[] whitePieces,Piece[] blackPieces){
      square[7][0] = new Square(new Coordinates(7,0) , blackPieces[0]);
      square[0][0] = new Square(new Coordinates(0,0) , whitePieces[0]);
      square[7][1] = new Square(new Coordinates(7,1) , blackPieces[1]);
      square[0][1] = new Square(new Coordinates(0,1) , whitePieces[1]);
      square[7][2] = new Square(new Coordinates(7,2) , blackPieces[2]);
      square[0][2] = new Square(new Coordinates(0,2) , whitePieces[2]);
      square[7][3] = new Square(new Coordinates(7,3) , blackPieces[3]);
      square[0][3] = new Square(new Coordinates(0,3) , whitePieces[3]);
      square[7][5] = new Square(new Coordinates(7,5) , blackPieces[5]);
      square[0][5] = new Square(new Coordinates(0,5) , whitePieces[5]);
      square[7][6] = new Square(new Coordinates(7,6) , blackPieces[6]);
      square[0][6] = new Square(new Coordinates(0,6) , whitePieces[6]);
      square[7][7] = new Square(new Coordinates(7,7) , blackPieces[7]);
      square[0][7] = new Square(new Coordinates(0,7) , whitePieces[7]);
      square[7][4] = new Square(new Coordinates(7,4) , blackPieces[4]);
      square[0][4] = new Square(new Coordinates(0,4) , whitePieces[4]);
    for (int i =1;i<7;i++){
     for (int j = 0 ;j<8 ;j++) {
         int count= j+8;
         if(i==6)
             square[i][j] = new Square(new Coordinates(i, j), whitePieces[count]);
         else if(i==1)
             square[i][j] = new Square(new Coordinates(i, j),  blackPieces[count]);
         else
             square[i][j] = new Square(new Coordinates(i, j),  null);
     }
    }
  }
  public void chessBoardSimulator(){
      char[] coordinateX = {'a','b','c','d','e','f','g','h'};
      for (int i =7;i>=0;i--){
          System.out.print((i+1)+" ");
          for (int j = 0 ;j<8 ;j++) {
              System.out.printf("%13s|", (getSquare()[i][j].pointTo!=null?(getSquare()[i][j].pointTo.getName()+"("+getSquare()[i][j].pointTo.getColor()+")"):""));
          }
          System.out.println();
          System.out.println("##################################################################################################################");
      }
      for (char c : coordinateX) {
          System.out.printf("%13s", c);
      }
      System.out.println();
  }
}

