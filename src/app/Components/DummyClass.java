/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Components;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public class DummyClass {

    private int lineNo;
    private boolean matchability;
    private String role;

    public static List<Object> getDummyData() {
        List<Object> data = new ArrayList<>();
        data.add(new DummyClass(1, true, "My role"));
        data.add(new DummyClass(2, false, "role X"));
        data.add(new DummyClass(10, true, "Mohamed"));
        return data;
    }

    public DummyClass() {
        this(0, false, "");
    }

    public DummyClass(int lineNo, boolean matchability, String role) {
        this.lineNo = lineNo;
        this.matchability = matchability;
        this.role = role;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public boolean isMatchability() {
        return matchability;
    }

    public void setMatchability(boolean matchability) {
        this.matchability = matchability;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
