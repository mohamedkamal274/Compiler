/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author mohamedkamal
 */
public class transtionTable {

    private ArrayList<state> states = new ArrayList<>();
    private String token;
    static int line_no = 1;
    static int column_no = 1;

    public transtionTable(String token, int stateCount, int... acceptState) {
        this.token = token;
        Arrays.sort(acceptState);
        for (int i = 0; i <= stateCount; i++) {
            states.add(new state(i));
            if (Arrays.binarySearch(acceptState, i) >= 0) {
                states.get(i).acceptance = true;
            }
        }
        states.get(stateCount).errorState = true;
    }

    public Lexeme match(String input) {
        state stat = states.get(0);
        int columnNo = column_no;
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
            } else {
                column_no++;
            }
            System.out.println(ch + "-" + stat.num);
            x += ch;
            if (stat.isAcceptanceState() || stat.isErrorState()) {
                if (input.length() == counter + 1 || stat.nextState(input.charAt(counter + 1)) == null) {
                    System.out.println(x);
                    if (stat.isAcceptanceState()) {
                        return new Lexeme(line_no, x, this.token, columnNo, true);
                    }
                }
            }
            counter++;
        }
        System.out.println(x);
        return null;
    }

    public void put(int stateNum, Char ch, int nextState) {
        System.out.println(stateNum + " " + ch + " " + nextState);
        states.get(stateNum).nextState.put(ch, states.get(nextState));
    }

    public static transtionTable initcomment() {
        Char dot = Char.dot;
        Char slash = new Char('/');
        Char dash = new Char('-');
        Char newline = new Char('\n');
        transtionTable comment = new transtionTable("comment", 7, 6);
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

    public static transtionTable initDigit() {
        transtionTable digit = new transtionTable("digit", 4, 1, 3);
        Char digitChar = Char.digit;
        digit.put(0, digitChar, 1);
        digit.put(1, digitChar, 1);
        digit.put(1, Char.word, 4);
        digit.put(1, new Char('.'), 2);
        digit.put(2, digitChar, 3);
        digit.put(3, digitChar, 3);
        digit.put(3, Char.word, 4);
        digit.put(4, Char.word, 4);
        digit.put(4, Char.digit, 4);
        return digit;
    }

    public static transtionTable reservedWord(String keyword, String token) {
        transtionTable keyWordFa = new transtionTable(token, keyword.length() + 1, keyword.length());
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

    @Override
    public String toString() {
        return "transtionTable{" + "states=" + states + ", token=" + token + '}';
    }

}
