 // Fig. 24.14: TicTacToeServerTest.java
 // Tests the TicTacToeServer.
 import javax.swing.JFrame;

 public class TicTacToeServerTest
 {
    public static void main( String args[] )
    {
       TicTacToeServer application = new TicTacToeServer();
       application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       application.execute();
  } // end main
} // end class TicTacToeServerTest