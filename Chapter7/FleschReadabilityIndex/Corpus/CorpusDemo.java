import java.io.*;

public class CorpusDemo {
    public static void main(String[] args) {
        
        try {
            Corpus corp = new Corpus(args[0]);
            System.out.println(corp.getFleschIndex());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding: " + e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }     
    }
}