package compiler.scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class ReservedKeywords {

    public static HashMap<String, String> reservedWords = new HashMap<>();

    static {
        reservedWords.put(";", "SemiColon");
        reservedWords.put("!", "not");
        reservedWords.put(",", "Comma");
        reservedWords.put("true", "Boolean");
        reservedWords.put("false", "Boolean");
        reservedWords.put(".txt", "extension");
        reservedWords.put("BackedValue", "BackedValue");
        reservedWords.put("TerminateThisNow", "TerminateThisNow");
        reservedWords.put("Pattern", "Class");
        reservedWords.put("DerivedFrom", "Inheritance");
        reservedWords.put("TrueFor", "Condition");
        reservedWords.put("Else", "Condition");
        reservedWords.put("Ity", "Ity");
        reservedWords.put("Sity", "Sity");
        reservedWords.put("Cwq", "Cwq");
        reservedWords.put("CwqSequence", "CwqSequence");
        reservedWords.put("Ifity", "Ifity");
        reservedWords.put("Sifity", "Sifity");
        reservedWords.put("Valueless", "Valueless");
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
        reservedWords.put("%", "Arithmetic Operation");
        reservedWords.put("<<", "Arithmetic Operation");
        reservedWords.put(">>", "Arithmetic Operation");
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
        /*        reservedWords.put("--", "Comment");
        reservedWords.put("-/", "Comment");
        reservedWords.put("/- ", "Comment");*/
        reservedWords.put("require", "Inclusion");
        reservedWords.put("{", "Braces");
        reservedWords.put("}", "Braces");
        reservedWords.put("[", "Braces");
        reservedWords.put("]", "Braces");
        reservedWords.put(")", "Braces");
        reservedWords.put("(", "Braces");
        reservedWords.put("->", "Access Operator");
        reservedWords.put("=", "Assignment operator");
        reservedWords.put("public", "Access Modifers");
        reservedWords.put("private", "Access Modifers");
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