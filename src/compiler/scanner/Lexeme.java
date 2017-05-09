/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.scanner;

/**
 *
 * @author mohamedkamal
 */
public class Lexeme {
    int line_no;
    String lexeme;
    String token;
    int lexeme_pos;
    Boolean matched;

    public Lexeme(int line_no, String lexeme, String token, int lexeme_pos, Boolean matched) {
        this.line_no = line_no;
        this.lexeme = lexeme;
        this.token = token;
        this.lexeme_pos = lexeme_pos;
        this.matched = matched;
    }

    public Lexeme() {
    }

    public int getLine_no() {
        return line_no;
    }

    public void setLine_no(int line_no) {
        this.line_no = line_no;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLexeme_pos() {
        return lexeme_pos;
    }

    public void setLexeme_pos(int lexeme_pos) {
        this.lexeme_pos = lexeme_pos;
    }

    public Boolean getMatched() {
        return matched;
    }

    public void setMatched(Boolean matched) {
        this.matched = matched;
    }

    @Override
    public String toString() {
        return "Lexeme{" + "line_no=" + line_no + ", lexeme=" + lexeme + ", token=" + token + ", lexeme_pos=" + lexeme_pos + ", matched=" + matched + '}';
    }
    
}
