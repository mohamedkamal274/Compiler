
package compiler.parser;

import java.util.ArrayList;

/**
 *
 * @author Asmaa
 */
public class StringHandler {
    
    //split the input
    public static String[] split(String input)
        {
            String[] s = new String[1000];
            int pos = 0;
            int counter = 0;
            
            for (int i = 0; pos < input.length(); i++, counter++)
            {
                //split the input by space from specific postion to two parts
                s[i] = split(input,' ', pos);
                
                pos += s[i].length() + 1;
            }
            //make another list to get the input after splitting
            String[] result = new String[counter];
            for (int i = 0; i < counter; i++)
            {
                result[i] = s[i];
            }
            //return new function 
            return result;
        }

    //split input by using specific character
    public static String[] split(String input,char c)
        {
            String[] s = new String[1000];
            int pos = 0;
            int counter = 0;
           
            for (int i = 0; pos < input.length(); i++, counter++)
            {
                //split input string by using specific char start from specific position
                s[i] = split(input, c, pos);
                
                //position increase by the string length and start from position +1
                pos += s[i].length() + 1;
                
            }
            String[] result = new String[counter];
            for (int i = 0; i < counter; i++)
            {      
                result[i] = s[i];
            }
            return result;
        }
    //split the input from specific position using specific character
     public static String split(String input, char splitchar, int startposition)
        {
            String splitedstring = null;
            //start from start position to the input length
            for (int i = startposition; i < input.length(); i++)
            {
                //if input character is equal to split value 
             
                if (input.charAt(i) == splitchar)
                {
                    //split the input start from start position to the the full length - this poistion
                    splitedstring = input.substring(startposition, i);
                    break;
                }
                
                if (i == input.length() - 1)
                {
                    splitedstring = input.substring(startposition, i + 1);
                }
            }
            return splitedstring;
        }
       public static Boolean Hassemicolon(String input)
        {
            //check if the input last character has a semicolon or not
            if (input.charAt(input.length() - 1) == ';')
            {
                return true;
            }
            else
                return false;
        }
       
        public static Boolean isCorrectID(String input)
        {
            char c;
           
            for(int i = 0;i<input.length();i++)
            {
                c = input.charAt(i);
                if(i==0 && c =='_')
                    continue;
               
                if((isDigit(c) && i!=0 ))
                {
                    if(!isCapitalChar(c)&&!isSmallChar(c)&&!isDigit(c)&&c!='_')
                    {
                        return false;
                    }
                    
                    return true;
                }
                else
                {
                    if(!isCapitalChar(c)&&!isSmallChar(c)&&c!='_')
                            return false;
                }
               
            }
            return true;
        }
        public static Boolean isDigit (char c)
        {
            char[] array = new char[]{'0','1','2','3','4','5','6','7','8','9'}; 
            for(int i = 0;i<array.length;i++)
            {
                if(c == array[i])
                {
                    return true;
                }
            }
            return false;   
        }
        
        //check if the input charcter is small letter or not
         public static Boolean isSmallChar(char c)
        {
            if (97 <= (int)c && 122 >= (int)c)
            {
                return true;
            }
            else return false;
        }


        //check if the input character is capital letter or not 
        public static Boolean isCapitalChar(char c)
        {
            if (65 <= (int)c && 90 >= (int)c)
            {
                return true;
            }
            else return false;
        }
        
public static Boolean isNumber(String input){
    boolean flag=true;
    
    for(int i=0;i<input.length();i++)
    {
        char c=input.charAt(i);
        if (!(48 <= (int)c && 57 >= (int)c)&&46!=(int)c){
            flag=false;
        }
    }
    
    return flag;
}

public static String copyStack (stack s)
        {
            String copied = "";
            ArrayList<String> getElement = new ArrayList<String>();  
            ArrayList<String> reversedElement = new ArrayList<String>();
            while(!s.isEmpty())
            {
                getElement.add(s.pop());
            }
            reversedElement = reverseStringArrayList(getElement);
            for(int i=0;i<reversedElement.size();i++)
            {
                copied +=reversedElement.get(i)+" ";
                s.push(reversedElement.get(i));
            }
            return copied;
        }
        public static ArrayList<String> reverseStringArrayList (ArrayList <String> array)
        {
            ArrayList<String> reversedArray = new ArrayList<String>();
            for (int i=0,j=array.size()-1;i<array.size();i++,j--)
            {
                reversedArray.add(i,array.get(j));
            }
            
            return reversedArray;
        }
        
        public static String copyInputStack (stack s)
        {
            String copied = "";
            ArrayList<String> getElement = new ArrayList<String>(); 
             ArrayList<String> reversedElement = new ArrayList<String>();
            while(!s.isEmpty())
            {
                getElement.add(s.pop());
            }
            reversedElement = reverseStringArrayList(getElement);
           for(int i=0;i<getElement.size();i++)
            {
                copied +=getElement.get(i)+" ";
            }
            for(int i=0;i<reversedElement.size();i++)
            {
                s.push(reversedElement.get(i));
            }
           
            return copied;
        }

}
