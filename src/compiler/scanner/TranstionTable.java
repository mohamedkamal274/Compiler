package compiler.scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class TranstionTable {

    private ArrayList<State> states = new ArrayList<>();
    private String token;
    static int line_no = 1;
    static int column_no = 1;

    public TranstionTable(String token, int stateCount, int... acceptState) {
        this.token = token;
        Arrays.sort(acceptState);
        for (int i = 0; i <= stateCount; i++) {
            states.add(new State(i));
            if (Arrays.binarySearch(acceptState, i) >= 0) {
                states.get(i).acceptance = true;
            }
        }
        setErrorState(stateCount);
    }

    public void setErrorState(int index) {
        states.get(index).errorState = true;
    }

    public Lexeme match(String input) {
        State stat = states.get(0);
        int columnNo = column_no;
        int lineNo = line_no;
        String x = "";
        int counter = 0;
        for (char ch : input.toCharArray()) {
            stat = stat.nextState(ch);
            if (stat == null) {
                return null;
            }
            if (ch == '\n') {
                line_no += 1;
                column_no = 1;
            }
            //System.out.println(ch + "-" + stat.num);
            x += ch;
            if (stat.isAcceptanceState() || stat.isErrorState()) {
                if (input.length() == counter + 1 || stat.nextState(input.charAt(counter + 1)) == null) {
                    column_no++;
                    //System.out.println(x);
                    if (stat.isAcceptanceState()) {

                        return new Lexeme(lineNo, x, this.token, columnNo, true);
                    } else if (stat.isErrorState()) {
                        return new Lexeme(lineNo, x, "Not define", columnNo, false);
                    }
                }
            }
            counter++;
        }
        //System.out.println(x);
        return null;
    }

    public void put(int stateNum, Char ch, int nextState) {
        //System.out.println(stateNum + " " + ch + " " + nextState);
        states.get(stateNum).nextState.put(ch, states.get(nextState));
    }

    public static TranstionTable initcomment() {
        Char dot = Char.dot;
        Char slash = new Char('/');
        Char dash = new Char('-');
        Char newline = new Char('\n');
        TranstionTable comment = new TranstionTable("comment", 7, 6);
        comment.put(0, slash, 1);
        comment.put(1, dash, 2);
        comment.put(2, dash, 3);
        comment.put(2, newline, 5);
        comment.put(2, dot, 4);
        comment.put(3, slash, 6);
        comment.put(3, newline, 2);
        comment.put(3, dot, 4);
        comment.put(4, dash, 3);
        comment.put(4, newline, 5);
        comment.put(4, dot, 4);
        comment.put(5, dash, 3);
        comment.put(5, newline, 5);
        comment.put(5, dot, 4);
        return comment;
    }

    public static TranstionTable initDigit() {
        TranstionTable digit = new TranstionTable("digit", 2, 1);
        Char digitChar = Char.digit;
        digit.put(0, digitChar, 1);
        digit.put(1, digitChar, 1);
        digit.put(1, Char.word, 2);
        digit.put(2, Char.word, 2);
        digit.put(2, Char.digit, 2);
        return digit;
    }

    public static TranstionTable initSingleComment() {
        TranstionTable comment = new TranstionTable("inline comment", 4, 2, 3);
        Char dash = new Char('-');
        comment.put(0, dash, 1);
        comment.put(1, dash, 2);
        comment.put(2, Char.dot, 3);
        comment.put(3, Char.dot, 3);
        return comment;
    }

    public static TranstionTable initIdentifiers() {
        TranstionTable identifiers = new TranstionTable("id", 4, 1, 2, 3);
        identifiers.put(0, Char.word, 1);
        identifiers.put(1, Char.word, 2);
        identifiers.put(1, Char.digit, 3);
        identifiers.put(2, Char.word, 2);
        identifiers.put(2, Char.digit, 3);
        identifiers.put(3, Char.digit, 3);
        identifiers.put(3, Char.word, 2);
        return identifiers;
    }

    public static TranstionTable reservedWord(String keyword, String token) {
        TranstionTable keyWordFa = new TranstionTable(token, keyword.length() + 2, keyword.length());
        int counter = 0;
        for (char ch : keyword.toCharArray()) {
            keyWordFa.put(counter, new Char(ch), counter + 1);
            counter++;
        }
        if (Char.word.match(keyword.charAt(0))) {
            keyWordFa.put(counter, Char.word, counter + 1);
            keyWordFa.put(counter + 1, Char.word, counter + 1);
        }
        return keyWordFa;
    }

    public static TranstionTable whiteSpace() {
        TranstionTable whiteSpace = new TranstionTable("White Space", 4, 1, 2, 3);
        Char tab = new Char('\t');
        Char space = new Char(' ');
        Char newline = new Char('\n');
        whiteSpace.put(0, tab, 1);
        whiteSpace.put(0, space, 2);
        whiteSpace.put(0, newline, 3);
        whiteSpace.put(1, tab, 1);
        whiteSpace.put(1, space, 2);
        whiteSpace.put(1, newline, 3);
        whiteSpace.put(2, tab, 1);
        whiteSpace.put(2, space, 2);
        whiteSpace.put(2, newline, 3);
        whiteSpace.put(3, tab, 1);
        whiteSpace.put(3, space, 2);
        whiteSpace.put(3, newline, 3);
        return whiteSpace;
    }

    public static TranstionTable initString() {
        TranstionTable string = new TranstionTable("String", 4, 2);
        Char doubleQouts = new Char('"');
        string.put(0, doubleQouts, 1);
        string.put(1, doubleQouts, 2);
        string.put(3, doubleQouts, 2);
        string.put(1, Char.dot, 3);
        string.put(3, Char.dot, 3);
        string.setErrorState(3);
        return string;
    }
    public static TranstionTable initChar() {
        TranstionTable charFa = new TranstionTable("String", 4, 3);
        Char singleQouts = new Char('\'');
        charFa.put(0, singleQouts, 1);
        charFa.put(1, Char.dot, 2);
        charFa.put(2, singleQouts, 3);
        charFa.setErrorState(2);
        return charFa;
    }

    @Override
    public String toString() {
        return "transtionTable{" + "states=" + states + ", token=" + token + '}';
    }

}