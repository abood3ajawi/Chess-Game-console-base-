public class CharCoordinateConverter {
    static int getCoordinatesInt(char coordinate){
       int b=0;
       char[] coordinateX = {'a','b','c','d','e','f','g','h'};
       char[] coordinateY = {'1','2','3','4','5','6','7','8'};
       for (char x : coordinateX) {
          if(x==coordinate)
             return b;
          b++;
       }
       for (char y : coordinateY) {
          if(y==coordinate)
             return Character.getNumericValue(coordinate)-1;
       }
       return -1;
   }
}
