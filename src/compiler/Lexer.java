package compiler;

import java.util.ArrayList;

public class Lexer {

    static String input;
    ArrayList<TranstionTable> tables;

    public Lexer(String input) {
        Lexer.input = input;
        tables = new ArrayList<>();
        tables.add(TranstionTable.whiteSpace());
        tables.add(TranstionTable.initSingleComment());
        tables.add(TranstionTable.initcomment());
        tables.add(TranstionTable.initChar());
        tables.add(TranstionTable.initString());
        tables.addAll(ReservedKeywords.keywords());
        tables.add(TranstionTable.initDigit());
        tables.add(TranstionTable.initIdentifiers());
    }

    public void setInput(String Input) {
        Lexer.input = Input;
        TranstionTable.column_no = 1;
        TranstionTable.line_no = 1;
    }

    public void add(TranstionTable table) {
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
            for (TranstionTable table : tables) {
                lexeme = table.match(input);
                if (lexeme != null) {
                    input = subString(lexeme.getLexeme().length(), input);
                    lexemes.add(lexeme);
                    break;
                }
            }
            if (lexeme == null) {
                lexemes.add(new Lexeme(TranstionTable.line_no, input.charAt(0) + "", "Not define", TranstionTable.column_no, Boolean.FALSE));
                TranstionTable.column_no++;
                input = subString(1, input);
            } else if (this.equal(lexeme.getToken(), "White Space")) {
                TranstionTable.column_no--;
                lexemes.remove(lexeme);
            } else if (equal(lexeme.getToken(), "comment")) {
                lexeme.setLexeme("/- ... -/");
            } else if (equal(lexeme.getToken(), "inline comment")) {
                lexeme.setLexeme("-- ...");
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
