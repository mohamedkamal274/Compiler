package compiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javafx.print.Collation;


public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lexer lex = new Lexer("@ {public#Person{\n"
                + "Ity#x^\n"
                + "Ity#G() {\n"
                + "Whatever (counter<num){\n"
                + "} }} $"
                + "x='--sdads'"  );
        //char t = '--sdadd';
        lex.lexicalAnalyzer().forEach(System.out::println);
        //System.out.println(transtionTable.initChar().match("'9'"));
    }
}
