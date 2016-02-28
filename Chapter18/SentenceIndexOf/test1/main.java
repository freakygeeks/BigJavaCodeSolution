import java.util.*; 
import java.io.*; 
import java.util.Scanner; 

class main 
{  
   public main(){}    
    public static void main(String args[]) 
    { 
       Scanner in = new Scanner(System.in); 

       System.out.println("Please enter a word or sentence: "); 
       String theirsentence = in.nextLine(); 
       Sentence sentence = new Sentence(theirsentence); 
        
       System.out.println("Please enter a substring to be searched for: "); 
       String thesubstring = in.nextLine(); 
        
       int _position = -1; 
        
       _position = sentence.indexOf(thesubstring); 
        
       if(_position > -1) 
          System.out.println("The substring was found at position: " + _position); 
       else 
          System.out.println("The substring was not found."); 
    } 
} 

class Sentence 
{ 
   private String _sentence; 
   private String _thesubstring; 
   private int _currentposition; 
   private boolean _found; 
    
   public Sentence(String sentence) 
   { 
      _sentence = sentence; 
      _thesubstring = ""; 
      _currentposition = 0; 
      _found = false; 
   } 
   public int indexOf(String thesubstring) 
   { 
      int _possiblefind = -1; 
       
      if(_thesubstring == "") 
         _thesubstring = thesubstring; 
      if(_currentposition == _sentence.length()) 
      { 
         _currentposition--; 
         return -1; 
      } 
      if((_sentence.charAt(_currentposition) == thesubstring.charAt(0)) || (_sentence.charAt(_currentposition) == _thesubstring.charAt(0))) 
      { 
         if((_sentence.charAt(_currentposition) != thesubstring.charAt(0)) && (_sentence.charAt(_currentposition) == _thesubstring.charAt(0))) 
            thesubstring = _thesubstring; 
         if(thesubstring.length() == 1) 
         { 
            _currentposition--; 
            return _currentposition + 1; 
         } 
         _currentposition++; 
         _possiblefind = indexOf(thesubstring.substring(1, thesubstring.length())); 
         if(_found) 
         { 
            _currentposition--; 
            return _possiblefind; 
         } 
         if(_possiblefind > -1) 
         { 
            if(thesubstring.length() == _thesubstring.length()) 
               _found = true; 
            if(_possiblefind == _currentposition + 1) 
            { 
               _currentposition--; 
               return _currentposition + 1; 
            } 
            else 
            { 
               _currentposition--; 
               return _possiblefind; 
            } 
         } 
         else 
         { 
            _currentposition--; 
            return -1; 
         } 
      } 
      else 
      { 
         _currentposition++; 
         _possiblefind = indexOf(_thesubstring); 
         if(_possiblefind > -1) 
         { 
            _found = true; 
            _currentposition--; 
            return _possiblefind; 
         } 
      } 
      _currentposition--; 
      return -1; 
   } 
} 