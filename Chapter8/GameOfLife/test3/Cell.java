import java.awt.*;

class Cell {
   boolean currentGen, nextGen;
   int numNeighbors = 0;
   Cell neighbors [ ] = new Cell [ 8 ];

   public void initialize ( ) {
       currentGen =  Math.random() > 0.5 ;
   }
   
   public void setNeighbor ( Cell n ) {
      neighbors [ numNeighbors ] = n;
      numNeighbors ++;
   }

   public void computeNextGen ( ) {
      int i;
      int aliveNeighbors = 0;

      for ( i = 0 ; i < numNeighbors ; i ++ )
          if ( neighbors [ i ].isAlive ( ) )
              aliveNeighbors ++;

      if ( currentGen )
         if ( ( aliveNeighbors == 2 ) || ( aliveNeighbors == 3 ) )
            nextGen = true;
         else
            nextGen = false;
      else
         if ( aliveNeighbors == 3 )
            nextGen = true;
         else
            nextGen = false;
   }
 
   public void updateGen ( ) {
      currentGen = nextGen;
   }

   public boolean isAlive ( ) {
      return currentGen;
   }

   public void drawState ( Graphics g, int x, int y ) {
      if ( currentGen )
         g.setColor ( Color.green );
      else
         g.setColor ( Color.black );

      g.drawOval ( x, y, 10, 10 );
   }
}
