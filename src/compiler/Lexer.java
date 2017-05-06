package compiler;

import java.util.ArrayList;

public class Lexer {

    static String input;
    ArrayList<transtionTable> tables;

    public Lexer(String input) {
        Lexer.input = input;
        tables = new ArrayList<>();
        tables.add(transtionTable.whiteSpace());
        tables.add(transtionTable.initSingleComment());
        tables.add(transtionTable.initcomment());
        tables.addAll(reservedKeywords.keywords());
        tables.add(transtionTable.initDigit());
        tables.add(transtionTable.initIdentifiers());
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

    public ArrayList<Lexeme> lexicalAnalyzer() {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        while (input.length() != 0) {
            Lexeme lexeme = null;
            for (transtionTable table : tables) {
                lexeme = table.match(input);
                if (lexeme != null) {
                    input = subString(lexeme.getLexeme().length(), input);
                    lexemes.add(lexeme);
                    break;
                }
            }
            if (lexeme == null) {
                lexemes.add(new Lexeme(transtionTable.line_no, "Not define", input.charAt(0)+"" , transtionTable.column_no, Boolean.FALSE));
                transtionTable.column_no++;
                input = subString(1, input);
            }
        }
        return lexemes;
    }
}
