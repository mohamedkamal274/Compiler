package compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class State {
    Boolean acceptance = false;
    Boolean errorState = false;
    HashMap<Char,State> nextState = new LinkedHashMap<>();
    int num;
    public State(int i){
        num = i;
    }
    public State nextState(char ch)
    {
        for (Map.Entry<Char, State> entry : nextState.entrySet()) {
            Char key = entry.getKey();
            State value = entry.getValue();
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

