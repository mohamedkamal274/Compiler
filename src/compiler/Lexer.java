package compiler;

import java.util.ArrayList;


public class Lexer {
    
    static String input;
    ArrayList<transtionTable> tables;

    public Lexer(String input) {
        this.input = Lexer.input;;
        tables = new ArrayList<>();
    }
    public void add(transtionTable table)
    {
        tables.add(table);
    }
    
    public ArrayList<Lexeme> lexerAnlyzer(){
        
        return null;
    }
}
