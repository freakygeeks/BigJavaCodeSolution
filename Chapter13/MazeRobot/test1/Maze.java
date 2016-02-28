

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
        
        public Maze()
        {       
                FileReader txt = null;
                Scanner file = null;
                try
                {
                        txt = new FileReader("input.txt");
                        file = new Scanner(txt);
                        readmaze(txt);  
                }
                catch( IOException e )
                {
                }
                finally
                {
                        if( file != null )
                        {
                                file.close();
                        }
                        if( txt != null )
                        {
                                try {
                                        txt.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }
        
        private void readmaze(FileReader file) throws IOException
        {
                int i, j;
                StringBuilder sb = new StringBuilder();
                String currentLine = null;
                BufferedReader br = new BufferedReader( file );
                while( ( currentLine = br.readLine() ) != null )
                {
                        sb.append( currentLine );
                }
                String data = sb.toString();
                System.out.println( "Data: " + data );
                for(i = 0; i < 11; i++)
                {
                        for(j = 0; j < 11; j++)
                        {
                                ver[i][j] = data.charAt(i*11+j);  
                                System.out.print(ver[i][j]);
                        }
                        System.out.println();
                        
                }
                
        }
        
        public position findb()
        {
                int i, j;
                
                position entrance;
                
                for(i = 0; i < 11; i++)
                {
                        for(j = 0; j < 11; j++)
                        {
                                if(ver[i][j] == 'o')
                                {
                                        entrance = new position(i, j);
                                        return entrance;
                                }
                                
                        }
                        
                }
                System.err.println("No entrance found. Some maze you got here, buddy.");
                System.exit(1);
                return(entrance = new position());
        }
		
        public position finde()
        {
                int i, j;
                
                position exit;
                
                for(i = 0; i < 11; i++)
                {
                        for(j = 0; j < 11; j++)
                        {
                                if(ver[i][j] == 'x')
                                {
                                        exit = new position(i, j);
                                        return exit;
                                }
                                
                        }
                        
                }
                System.err.println("No exit found. Now you're just evil.");
                System.exit(1);
                return(exit = new position());
        }
        
        private char[][] ver = new char[11][11];
        
        public static final int POINT_ENTRANCE = 0;
        public static final int POINT_SPACE = 1;
        public static final int POINT_WALL = 2;
        public static final int POINT_EXIT = 3;
        
        public int CheckPos(int x, int y)
        {
                if(x < 0 || x > 10 || y < 0 || y > 10)
                {
                        System.err.println("Out of bounds. You've fallen into Valhala.");
                        return -1; 
                }
        
                if(ver[y][x] == 'o')
                        return POINT_ENTRANCE;
                else if (ver[y][x] == ' ')
                        return POINT_SPACE;
                else if (ver[y][x] == '*')
                        return POINT_WALL;
                else if (ver[y][x] == 'x')
                        return POINT_EXIT;
                else
                        System.err.println("Not valid Character. Get that guy outa here.");
                        return -2;
        }
}
