package compiler;

import java.util.ArrayList;

public class Lexer {

    static String input;
    ArrayList<transtionTable> tables;

    public Lexer(String input) {
        this.input = Lexer.input;
        tables = new ArrayList<>();
    }

    public void add(transtionTable table) {
        tables.add(table);
    }

    public String subString(int start, String text) {
        String subText = "";
        for (int i = start; i < text.length(); i++) {
            subText += text.charAt(i);
        }
        return subText;
    }

    public ArrayList<Lexeme> lexerAnlyzer() {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        while (input.length() != 0) {
            Lexeme lexeme;
            for (transtionTable table : tables) {
                lexeme = table.match(input);
                if (lexeme != null) {
                    input = subString(lexeme.getLexeme().length(), input);
                    lexemes.add(lexeme);
                }
            }
        }
        return lexemes;
    }
}
