/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author mohamedkamal
 */
public class reservedKeywords {

    static HashMap<String, String> x = new HashMap<>();

    static {
        x.put("Pattern", "Class");
        x.put("DerivedFrom", "Inheritance");
        x.put("TrueFor", "Condition");
        x.put("Else", "Condition");
        x.put("Ity", "Integer");
        x.put("Sity", "SInteger");
        x.put("Cwq", "Character");
        x.put("CwqSequence", "String");
        x.put("Ifity", "Float");
        x.put("Sifity", "SFloat");
        x.put("Valueless", "Void");
        x.put("Logical", "Boolean");
        x.put("BreakFromThis", "Break");
        x.put("Whatever", "Loop");
        x.put("Respondwith", "Return");
        x.put("Srap", "Struct");
        x.put("Scan", "Switch");
        x.put("Conditionof", "Switch");
        x.put("@", "Stat Symbol");
        x.put("$", "End Symbol");
        x.put("+", "Arithmetic Operation");
        x.put("-", "Arithmetic Operation");
        x.put("*", "Arithmetic Operation");
        x.put("/", "Arithmetic Operation");
        x.put("&&", "Logic operators");
        x.put("||", "Logic operators");
        x.put("~", "Logic operators");
        x.put("==", "relational operators");
        x.put("<", "relational operators");
        x.put(">", "relational operators");
        x.put("!=", "relational operators");
        x.put("<=", "relational operators");
        x.put(">=", "relational operators");
        x.put("^", "Line Delimiter");
        x.put("#", "Token Delimiter");
        x.put("--", "Comment");
        x.put("-/", "Comment");
        x.put("/- ", "Comment");
        x.put("Require", "Inclusion");
        x.put("{", "Braces");
        x.put("}", "Braces");
        x.put("[", "Braces");
        x.put("]", "Braces");
        x.put("->", "Access Operator");
        x.put("=", "Assignment operator");
    }

    public ArrayList<transtionTable> keywords() {
        ArrayList<transtionTable> transtionTableKeyword = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(x.keySet());
        keys.sort(String::compareTo);
        Collections.reverse(keys);
        keys.forEach((String keyword) -> {
            transtionTableKeyword.add(transtionTable.reservedWord(keyword, x.get(keyword)));
        });
        return transtionTableKeyword;
    }
}
