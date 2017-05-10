/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.parser;

/**
 *
 * @author Safa
 */
public class Output {
    
    String index;
    String rule;
    String input;
    String process;

    public String getIndex() {
        return index;
    }

    public String getRule() {
        return rule;
    }

    public String getInput() {
        return input;
    }

    public String getProcess() {
        return process;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setProcess(String process) {
        this.process = process;
    }
       
}
