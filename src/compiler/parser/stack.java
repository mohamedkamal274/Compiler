package compiler.parser;

import java.util.ArrayList;

public class stack {
	private ArrayList<String> my_stacck = new ArrayList<String>();
	
	public void push (String elem){
		my_stacck.add(elem);
	}
	public String pop(){
		 if (my_stacck.size() >= 1){
                    String positionInArray = my_stacck.get(my_stacck.size() - 1);
                    my_stacck.remove(my_stacck.size() - 1);
                    return positionInArray;
        }

        else {
            return null;
        }
	}

    public boolean isEmpty() {
         if (my_stacck.size() == 0){
             return true;
         }
         else
            return false;
        
    }
	
}
