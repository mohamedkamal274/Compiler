package compiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class ReservedKeywords {

    static HashMap<String, String> reservedWords = new HashMap<>();

    static {
        reservedWords.put("Pattern", "Class");
        reservedWords.put("DerivedFrom", "Inheritance");
        reservedWords.put("TrueFor", "Condition");
        reservedWords.put("Else", "Condition");
        reservedWords.put("Ity", "Integer");
        reservedWords.put("Sity", "SInteger");
        reservedWords.put("Cwq", "Character");
        reservedWords.put("CwqSequence", "String");
        reservedWords.put("Ifity", "Float");
        reservedWords.put("Sifity", "SFloat");
        reservedWords.put("Valueless", "Void");
        reservedWords.put("Logical", "Boolean");
        reservedWords.put("BreakFromThis", "Break");
        reservedWords.put("Whatever", "Loop");
        reservedWords.put("Respondwith", "Return");
        reservedWords.put("Srap", "Struct");
        reservedWords.put("Scan", "Switch");
        reservedWords.put("Conditionof", "Switch");
        reservedWords.put("@", "Stat Symbol");
        reservedWords.put("$", "End Symbol");
        reservedWords.put("+", "Arithmetic Operation");
        reservedWords.put("-", "Arithmetic Operation");
        reservedWords.put("*", "Arithmetic Operation");
        reservedWords.put("/", "Arithmetic Operation");
        reservedWords.put("&&", "Logic operators");
        reservedWords.put("||", "Logic operators");
        reservedWords.put("~", "Logic operators");
        reservedWords.put("==", "relational operators");
        reservedWords.put("<", "relational operators");
        reservedWords.put(">", "relational operators");
        reservedWords.put("!=", "relational operators");
        reservedWords.put("<=", "relational operators");
        reservedWords.put(">=", "relational operators");
        reservedWords.put("^", "Line Delimiter");
        reservedWords.put("#", "Token Delimiter");
        reservedWords.put("--", "Comment");
        reservedWords.put("-/", "Comment");
        reservedWords.put("/- ", "Comment");
        reservedWords.put("Require", "Inclusion");
        reservedWords.put("{", "Braces");
        reservedWords.put("}", "Braces");
        reservedWords.put("[", "Braces");
        reservedWords.put("]", "Braces");
        reservedWords.put(")", "Braces");
        reservedWords.put("(", "Braces");
        reservedWords.put("->", "Access Operator");
        reservedWords.put("=", "Assignment operator");
    }

    public static ArrayList<TranstionTable> keywords() {
        ArrayList<TranstionTable> transtionTableKeyword = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(reservedWords.keySet());
        keys.sort(String::compareTo);
        Collections.reverse(keys);
        keys.forEach((String keyword) -> {
            transtionTableKeyword.add(TranstionTable.reservedWord(keyword, reservedWords.get(keyword)));
        });
        return transtionTableKeyword;
    }
}