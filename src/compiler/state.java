/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author mohamedkamal
 */
public class state {
    Boolean acceptance = false;
    Boolean errorState = false;
    HashMap<Char,state> nextState = new LinkedHashMap<>();
    int num;
    public state(int i){
        num = i;
    }
    public state nextState(char ch)
    {
        for (Map.Entry<Char, state> entry : nextState.entrySet()) {
            Char key = entry.getKey();
            state value = entry.getValue();
            if (key.match(ch))
            {
                return value;
            }
        }
        return null;
    }
    public Boolean isAcceptanceState()
    {
        return acceptance;
    }
    public Boolean isErrorState()
    {
        return errorState;
    }
    
    @Override
    public String toString() {
        return "state{" + "acceptance=" + acceptance + ", nextState=" + nextState.keySet() + '}';
    }
    
}

