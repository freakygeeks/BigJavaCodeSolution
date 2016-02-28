import java.awt.*;
import java.applet.*;

public class OOConway
             extends Applet {

   public static final int ROWS = 20;
   public static final int COLS = 20;
   public static final int IMG_ROWS = 600;
   public static final int IMG_COLS = 500;

   private Image img;
   private Graphics gImg;

   Cell Population [ ] [ ] = new Cell [ ROWS ] [ COLS ];

   Button Step, Restart;

   void initialize ( ) {
      int i, j;

      for ( i = 0 ; i < 20 ; i ++ )
         for ( j = 0 ; j < 20 ; j ++ )
                Population [ i ] [ j ].initialize ( );
   }

   void next_generation ( ) {
      int i, j;

      for ( i = 0; i < ROWS ; i ++ )
         for ( j = 0; j < COLS ; j++ )
             Population [ i ] [ j ].computeNextGen ( );

      for ( i = 0; i < ROWS ; i ++ )
         for ( j = 0; j < COLS ; j++ )
             Population [ i ] [ j ].updateGen ( );

    }

   public void init ( ) {
      int i, j, k, l;
      int rand;

      img = createImage(IMG_COLS,IMG_ROWS);
      gImg = img.getGraphics();
      for ( i = 0 ; i < ROWS ; i ++ )
         for ( j = 0 ; j < COLS ; j ++ )
            Population [ i ] [ j ] = new Cell ( );

      for ( i = 0 ; i < ROWS ; i ++ )
         for ( j = 0 ; j < COLS ; j ++ ){
            for ( k = -1 ; k <= 1 ; k ++ )
               for ( l = -1 ; l <= 1 ; l ++ )
                  if ( ( i + k >= 0 ) && 
                       ( i + k < ROWS ) &&
                       ( j + l >= 0 ) && 
                       ( j + l < COLS ) &&
                       ( ( k != 0 ) || ( l != 0 ) ) ){
                     Population [ i ] [ j ].setNeighbor ( 
                                            Population [ i + k] [ j + l ] );
                  }
         }
      initialize ( );

      Step = new Button ( " Step " );
      Restart = new Button ( " Restart " );

      add ( Step );
      add ( Restart );
   }

   public void paint ( Graphics g ) {
       update ( g );
   }

   public void update ( Graphics g ) {

       int i, j;
 
       gImg.setColor ( Color.black );

       gImg.fillRect ( 0, 0, IMG_COLS, IMG_ROWS );

       gImg.setColor ( Color.red );

       for ( i = 100; i <= IMG_ROWS; i = i + 25 )
           gImg.drawLine ( 1, i, IMG_COLS, i );

       for ( i = 1; i <= IMG_COLS ; i = i + 25 )
           gImg.drawLine ( i, 100, i, IMG_ROWS );
           
       for ( i = 0; i < ROWS ; i ++ )
           for ( j = 0; j < COLS ; j ++ )
                Population [ i ] [ j ].drawState ( gImg, 8 + 25 * i, 
                                                      108 + 25 * j );

       g.drawImage(img,0,0,this);
   }
   
   public boolean action ( Event e, Object o ) {
      if ( e.target == Step ){
          next_generation ( );
          repaint ( );
      }
      if ( e.target == Restart ) {
          initialize();
          repaint();
      }

      return false;
   }
}

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
