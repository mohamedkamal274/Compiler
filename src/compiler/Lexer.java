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
        tables.add(transtionTable.initChar());
        tables.add(transtionTable.initString());
        tables.addAll(reservedKeywords.keywords());
        tables.add(transtionTable.initDigit());
        tables.add(transtionTable.initIdentifiers());
    }

    public void setInput(String Input) {
        Lexer.input = Input;
        transtionTable.column_no = 1;
        transtionTable.line_no = 1;
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
                lexemes.add(new Lexeme(transtionTable.line_no, input.charAt(0)+"" ,"Not define" , transtionTable.column_no, Boolean.FALSE));
                transtionTable.column_no++;
                input = subString(1, input);
            } else if (this.equal(lexeme.getToken(),"White Space")) {
                transtionTable.column_no--;
            }
        }
        return lexemes;
    }

    public boolean equal(String x1, String x2) {
        if (x1.length() != x2.length()) {
            return false;
        }
        for (int i = 0; i < x1.length(); i++) {
            if (x1.charAt(i) != x2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
