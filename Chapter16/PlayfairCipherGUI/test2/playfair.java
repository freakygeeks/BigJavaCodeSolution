import java.util.Scanner;


public class playfair {

private String KeyWord=new String();
private String Key=new String();
private char matrix_arr[][]= new char[5][5];

public void setKey(String k)
{
// This function will take the input key from the user
// Then it'll remove duplication of letters from the key
// Will add it to the private KeyWord for matrix generation

String K_adjust=new String();
boolean flag = false;

K_adjust = K_adjust + k.charAt(0);

for(int i=1; i<k.length();i++)
{
for(int j=0;j<K_adjust.length(); j++)
{	
if(k.charAt(i)==K_adjust.charAt(j))
{
flag = true;
}
}

if(flag == false)
K_adjust = K_adjust + k.charAt(i);

flag = false;
}

KeyWord=K_adjust;
}

public void KeyGen()
{
// This function adjust the alphabetical letters adding the
// KeyWord on the beginning of them & then it calls the matrix function

boolean flag=true;
char current;

Key=KeyWord;

for ( int i=0 ; i<26 ; i++)
{
current=(char)(i+97);

if(current=='j')
continue;

for(int j=0 ; j< KeyWord.length() ; j++ )
{
if (current == KeyWord.charAt(j))
{
flag=false;
break;
}
}

if(flag)
Key=Key+current;

flag=true;
}

System.out.println(Key);
matrix ();

}

private void matrix ()
{
int counter=0;

for (int i=0 ; i<5 ;i++)
{
for (int j=0 ; j<5 ; j++)
{
matrix_arr[i][j]=Key.charAt(counter);
System.out.printf("%s ",matrix_arr[i][j]);

counter++;
}

System.out.println("\n");
}
}

private String format(String old_text)
{
// This function is to adjust the Text to encrypt
// It changes all the 'j' letters to 'i' & add 'x' character
// between repeatable pairs.

int i = 0;
int j = 0;
int len = 0;
String text = new String();
len = old_text.length();

//System.out.println(old_text);
/*** Change all j's into i's *****/
for (int tmp = 0; tmp < len; tmp++)
{
if (old_text.charAt(tmp) == 'j')
{
text = text + 'i';
}
else
text = text+old_text.charAt(tmp);
}
/**********************************/
len = text.length();
/*** Assign 'x' to letters that repeat in a diagram ***/
for (i = 0; i < len; i = i + 2) //run for half of string length
{ 
if (text.charAt(i+1) == text.charAt(i)) //if char = previous char
{
text = text.substring(0, i+1) + 'x' + text.substring(i+1);
}
else //not a repeat character, move along
{}
}
return text;
}

private String [] Divid2Pairs (String new_string)
{
String Original = format(new_string);

int size= Original.length();

if(size%2!=0)
{
size++;
Original = Original+'x';
}

String x[]= new String[size/2];

int counter=0;

for ( int i=0 ; i<size/2 ;i++)
{
x[i]=Original.substring(counter, counter+2);
System.out.println(x[i]);
counter=counter+2;
}

return x;
}

public int[] GetDiminsions(char letter)
{
int []key=new int[2];

if ( letter == 'j')
letter='i';

for (int i=0 ; i<5 ;i++)
{
for (int j=0 ; j<5 ; j++)
{
if(matrix_arr[i][j] == letter)
{
key[0]=i;
key[1]=j;
break;
}
}

}

return key;
}

public String Encript(String Source)
{ 
System.out.println("Encription Start");

String src_arr[]=Divid2Pairs(Source);

String Code=new String();

char one;
char two;

int part1[]=new int[2];
int part2[]=new int[2];

//start on pair by pair
for (int i=0 ; i< src_arr.length ;i++ )
{
one = src_arr[i].charAt(0);//get first char
two = src_arr[i].charAt(1);//get second char

part1 = GetDiminsions(one);//get position of the first char
part2 = GetDiminsions(two);//get position of the second char

//check for special cases
if(part1[0]==part2[0])//same row
{
if (part1[1]<4)
part1[1]++;
else
part1[1]=0;

if(part2[1]<4)
part2[1]++;
else
part2[1]=0;

}

else if (part1[1]==part2[1]) //same column
{
if (part1[0]<4)
part1[0]++;
else
part1[0]=0;

if(part2[0]<4)
part2[0]++;
else
part2[0]=0;
}
else
{
int temp=part1[1];
part1[1]=part2[1];
part2[1]=temp;
}

Code= Code + matrix_arr[part1[0]][part1[1]] + matrix_arr[part2[0]][part2[1]];
}
System.out.println(Code);
return Code;
}

public String Decript (String Code)
{
System.out.println("Decription Start");

String Original=new String();

String src_arr[]=Divid2Pairs(Code);

char one;
char two;

int part1[]=new int[2];
int part2[]=new int[2];


//start on pair by pair
for (int i=0 ; i< src_arr.length ;i++ )
{
one = src_arr[i].charAt(0);//get first char
two = src_arr[i].charAt(1);//get second char

part1 = GetDiminsions(one);//get position of the first char
part2 = GetDiminsions(two);//get position of the second char

//check for special cases
if(part1[0]==part2[0])//same row
{
if (part1[1]>0)
part1[1]--;
else
part1[1]=4;

if(part2[1]>0)
part2[1]--;
else
part2[1]=4;
}

else if (part1[1]==part2[1]) //same column
{
if (part1[0]>0)
part1[0]--;
else
part1[0]=4;

if(part2[0]>0)
part2[0]--;
else
part2[0]=4;
}
else
{
int temp=part1[1];
part1[1]=part2[1];
part2[1]=temp;
}


Original =Original + matrix_arr[part1[0]][part1[1]] + matrix_arr[part2[0]][part2[1]];
}

System.out.println(Original);
return Original;
}
/**
* @param args
*/
public static void main(String[] args) {
// TODO Auto-generated method stub

playfair x=new playfair();

Scanner sc = new Scanner(System.in);

System.out.println("Enter a lower case keyword:");
String keyword = sc.next();
x.setKey(keyword);
x.KeyGen();

System.out.println("To Encrypt enter 1 \nTo Decript enter 2\nTesting both enter anything else:");
int choosen_value = sc.nextInt();

if(choosen_value==1)
{	
System.out.println("Enter a lower case word to encrypt:");
String key_input = sc.next();
String Encripted= x.Encript(key_input);
}
else if(choosen_value==2)
{
System.out.println("Enter a lower case word to decrypt:");
String decripted = sc.next();

x.Decript(decripted);	
}
else
{
System.out.println("Enter a lower case word to encrypt & decrypt:");
String key_input = sc.next();

String Encripted= x.Encript(key_input);
x.Decript(Encripted);
}
}
}
