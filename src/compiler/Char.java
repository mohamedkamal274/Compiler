/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author mohamedkamal
 */
public class Char {

    char ch;
    Boolean special;
    public static final Char dot = new Char('.', true);
    public static final Char word = new Char('w', true);
    public static final Char digit = new Char('d', true);
    
    public Char(char ch){
        this(ch,false);
    }
    public Char(char ch, Boolean special) {
        this.ch = ch;
        this.special = special;
    }

    public Boolean match(char ch) {
        if (special)
        {
            switch (this.ch){
                case '.':
                    return this.matchDot(ch);
                case 'w':
                    return this.matchWord(ch);
                case 'd':
                    return this.matchDigit(ch);
            }
        }
        return this.ch == ch;
    }

    public boolean matchDot(char ch) {
        return (ch != '\n'); 
    }

    public boolean matchWord(char ch) {
        return ((ch >= 'A' && ch <= 'Z') || (ch >= 'A' && ch <= 'Z') || ch == '_');
    }

    public boolean matchDigit(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    @Override
    public String toString() {
        return "Char{" + "ch=" + ch + ", special=" + special + '}';
    }
    
}
