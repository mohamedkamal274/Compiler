/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Safa
 */
public class ParseTable {
    
     ArrayList<String> terminal = new ArrayList<String>() {{
    add("{");
    add("^");
    add("#");
    add("id");
    add("}");
    add("public");
    add("private");
    add(",");
    add("[");
    add("]");
    add("==");
    add("Ity");
    add("CwqSequence");
    add("Sity");
    add("Ifity");
    add("Sifity");
    add("Valueless");
    add("Logical");
    add("(");
    add(")");
    add("TrueFor");
    add("BackedValue");
    add("Whatever");
    add("@");
    add("$");
    add("TerminateThisNow");
    add("+");
    add("_");
    add("*");
    add("/");
    add("<<");
    add(">>");
    add("/-");
    add("-/");
    add("%");
    add("<=");
    add(">=");
    add(">");
    add("<");
    add("=");
    add("!=");
    add("&&");
    add("||");
    add("STR");
    add("--");
    add("true");
    add("false");
    add("intConstant");
    add("charConstant");
    add(".txt");
    add(";");
    add("!");
    add("require");
    add("Else");
}};
     ArrayList<String> Nonterminal = new ArrayList<String>() {{
    add("program");
    add("startSymbols");
    add("endSymbols");
    add("AccessModifiersType");
    add("fieldDecl");
    add("methodDecl");
    add("block");
    add("varDecl");
    add("type");
    add("statement");
    add("assign");
    add("lValue");
    add("methodCall");
    add("methodArg");
    add("TrueForStmt");
    add("whatEverStmt");
    add("respondWithStmt");
    add("terminalThisStatment");
    add("expr");
    add("binOp");
    add("arithOp");
    add("relOp");
    add("eqOp");
    add("condOp");
    add("constant");
    add("boolConstant");
    add("requireCommand");
    add("Fname");
    add("Comment");
    add("varDecl*");
    add("expr*");
    add("exprCommonPart");
    add("fieldDeclCommonPart");
    add("statementCommonPart");
    add("LvalueCommonPart");
    add("methodDeclOption");
}};
     
     String[][] parseTable = new String[][]{
        {      "-",             "{",  "^",  "#",  "id",  "}",  "public",                                                              "private",                                                        ",",        "[",  "]",  "==",            "Ity",                "CwqSequence",                         "Sity",                        "Ifity",                         "Sifity",                   "Valueless",              "Logical",                                              "(",  ")",   "TrueFor","BackedValue","Whatever",                 "@",                          "$", "TerminateThisNow","+", "_", "*",  "/", "<<",  ">>", "/-",  "-/", "%","<=",">=",">","<","=","!=","&&","||","STR","--","true","false","intConstant","charConstant",".txt",";","!","require","Else" ,":"},
        { "program",            "-",  "-",  "-",  "-",   "-","AccessModifiersType # id { fieldDecl ^ methodDecl } } endSymbols","AccessModifiersType # id { fieldDecl ^ methodDecl } } endSymbols",     "-",         "-",  "-",   "-",             "-",                      "-",                               "-",                            "-",                              "-",                         "-",                     "-",                                                "-",  "-",     "-",       "-",         "-",     "startSymbols { Comment ^ program",            "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "requireCommand ^ program",     "-"  ,"-"},
        { "startSymbols",       "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                        "-",         "-",  "-",   "-",             "-",                      "-",                                "-",                           "-",                              "-",                         "-",                     "-",                                               "-",  "-",     "-",       "-",         "-",                       "@",                         "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "endSymbols",         "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                        "-",         "-",  "-",   "-",             "-",                      "-",                                "-",                           "-",                              "-",                         "-",                      "-",                                              "-",  "-",     "-",       "-",         "-",                       "-",                         "$",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "AccessModifiersType","-",  "-",  "-",  "-",   "-",    "public",                                                                "private",                                                    "-",         "-",  "-",  "-",             "-",                      "-",                                "-",                           "-",                              "-",                         "-",                      "-",                                              "-",  "-",     "-",       "-",         "-",                       "-",                         "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "fieldDecl",          "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                        "-",         "-",  "-",  "-","type # id fieldDeclCommonPart", "type # id fieldDeclCommonPart", "type # id fieldDeclCommonPart","type # id fieldDeclCommonPart","type # id fieldDeclCommonPart","type # id fieldDeclCommonPart","type # id fieldDeclCommonPart",                   "-",  "-",     "-",       "-",         "-",                       "-",                         "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "methodDecl",         "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                        "-",         "-",  "-", "-","type # id ( methodDeclOption ) block","type # id ( methodDeclOption ) block","type # id ( methodDeclOption ) block","type # id ( methodDeclOption ) block","type # id ( methodDeclOption ) block","type # id ( methodDeclOption ) block","type # id ( methodDeclOption ) block",  "-",  "-",     "-",       "-",         "-",                       "-",                         "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "block",              "{ varDecl ^ statement }",  "-",  "-",  "-",   "-",    "-",                                                                                                             "-",         "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "varDecl",            "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                        "-",         "-",  "-", "-",    "type # id varDecl*",        "type # id varDecl*",              "type # id varDecl*",        "type # id varDecl*",        "type # id varDecl*",            "type # id varDecl*",         "type # id varDecl*",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "type",               "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                        "-",         "-",  "-", "-",    "Ity",         "CwqSequence",                                        "Sity",                         "Ifity",                     "Sifity",                        "Valueless",                "Logical",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "statement",          "-",  "-",  "-",  "id statementCommonPart ^",   "-",    "-",                                                "-",                                                        "-",         "-",   "-", "-",    "-",               "-",                                            "-",                              "-",                          "-",                              "-",                        "-",                                               "-",  "-",     "TrueForStmt ^",  "respondWithStmt", "whatEverStmt ^",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "assign",             "-",  "-",  "-",  "lValue = expr ^",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "lValue",             "-",  "-",  "-",  "id LvalueCommonPart",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "methodCall",         "-",  "-",  "-",  "id ( methodArg ) ^",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "methodArg",          "-",  "-",  "-",  "expr",   "-",    "-", "-",  "-", "-",   "-",   "-","-","-","-", "-", "-", "-",  "-", "expr",  "",     "-",       "-",         "-",                     "-",                          "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "expr",   "expr",       "expr",          "expr",        "-", "-","expr",   "-",     "-"  ,"-"},
        { "TrueForStmt",        "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                         "-",         "-",   "-", "-",               "-",                    "-",                                 "-",                           "-",                         "-",                                  "-",                    "-",                                              "-",  "-",     "TrueFor ( expr ) statement Else statement",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "whatEverStmt",       "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                       "-",           "-",   "-", "-",               "-",                    "-",                                  "-",                         "-",                          "-",                              "-",                        "-",                                              "-",  "-",     "-",    "-",    "Whatever ( expr ) statement",            "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "respondWithStmt",    "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "BackedValue # expr ^",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        {"terminalThisStatment","-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",               "-",                                            "-",                              "-",                          "-",                              "-",                        "-",                                               "-",  "-",     "-",  "-", "-",     "-",  "-",       "TerminateThisNow",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-","-","-","-","-", "-","-", "-",     "-"  ,"-"},
        { "expr",               "-",  "-",  "-",  "id exprCommonPart expr*",   "-",    "-",         "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "( expr ) expr*",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "constant expr*",   "constant expr*",       "constant expr*",          "constant expr*",        "-", "-","! expr expr*",   "-",     "-"  ,"-"},
        { "binOp",              "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "eqOp",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "arithOp", "arithOp", "arithOp",  "arithOp",  "arithOp",  "arithOp",   "-",  "-",  "arithOp", "relOp", "relOp","relOp","relOp","-","eqOp",  "condOp", "condOp", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "arithOp",            "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "+", "_", "*",  "/",  "<<",  ">>",   "-",  "-",  "%", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "relOp",              "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "<=", ">=",">","<","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "eqOp",               "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "==",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","!=",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "condOp",             "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                        "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "&&", "||", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "constant",           "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "boolConstant",   "boolConstant",       "intConstant",          "charConstant",        "-", "-","-",   "-",     "-"  ,"-"},
        { "boolConstant",       "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "true",   "false",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "requireCommand",     "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "require ( Fname .txt ) ^",     "-"  ,"-"},
        { "Fname",              "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "STR",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "Comment",            "-",  "",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "/- -/",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "--",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "varDecl*",           "-",  "",  "-",  "-",   "-",    "-",                                                                       "-",                                                        ", type # id varDecl*",        "-",   "-", "-",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "expr*",              "-",  "",  "-",  "-",   "",    "-",                                                                       "-",     "-",  "-",   "", "binOp expr expr*",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "-",  "",     "-",       "-",         "-",     "-",  "-",       "-",         "binOp expr expr*", "binOp expr expr*", "binOp expr expr*",  "binOp expr expr*",  "binOp expr expr*",  "binOp expr expr*",   "-",  "-",  "binOp expr expr*", "binOp expr expr*", "binOp expr expr*","binOp expr expr*","binOp expr expr*","binOp expr expr*","binOp expr expr*",  "binOp expr expr*", "binOp expr expr*", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "exprCommonPart",     "-",  "",  "-",  "-",   "-",    "-",                                                                       "-",     "-",  "[ expr ]",   "", "",    "-",       "-",      "-",           "-",     "-",       "-",       "-",     "( methodArg ) ^",  "",     "-",       "-",         "-",     "-",  "-",       "-",         "", "", "",  "",  "",  "",   "-",  "-",  "", "", "","","","","",  "", "", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "fieldDeclCommonPart","-",  "",  "-",  "-",   "-",    "-",                                                                       "-",     ", fieldDecl",  "[ intConstant ]",   "-", "-",    "-",       "-",     "-",   "-",     "-",       "-",       "-",     "-",  "",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","= constant","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "statementCommonPart","-",  "",  "-",  "-",   "-",    "-",                                                                       "-",                                                          "-",      "[ expr ] = expr ^",   "-", "-",               "-",                    "-",                            "-",                        "-",                              "-",                    "-",                           "-",                                                      "( methodArg ) ^",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","= expr ^","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "LvalueCommonPart",   "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                           "-",      "[ expr ]",   "", "-",    "-",       "-",      "-",   "-",     "-",       "-",       "-",     "-",  "-",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"},
        { "methodDeclOption",   "-",  "-",  "-",  "-",   "-",    "-",                                                                       "-",                                                        "-",  "-",   "-", "-",    "fieldDecl",       "fieldDecl",      "fieldDecl",   "fieldDecl",     "fieldDecl",       "fieldDecl",       "fieldDecl",     "-",  "",     "-",       "-",         "-",     "-",  "-",       "-",         "-", "-", "-",  "-",  "-",  "-",   "-",  "-",  "-", "-", "-","-","-","-","-",  "-", "-", "-",  "-",  "-",   "-",       "-",          "-",        "-", "-","-",   "-",     "-"  ,"-"}
      
     };
     /*
     this function use to check  terminal or not
     * take one parameter string Data type
     **/
     public boolean findTerminal(String input){
         for(String e :terminal){
         if(e.equals(input))
             return true;
     }
         return false;
     }
     /*
     this function use to check  Non terminal or not
     * take one parameter string Data type
     **/
     public boolean findNonTerminal(String input){
         for(String e :Nonterminal){
         if(e.equals(input)){
             return true;
         }
     }
         return false;
     }
     
    
     /*
     this function use to return rule match with non terminal & terminal
     * take two paramater String Data type
     * * first  non terminal second terminal 
     **/
     public String findRule(String nonTerminal,String terminal){
         for(int i=0;i<parseTable.length;i++){
             for(int j=0;j<parseTable[i].length;j++){
                 if(nonTerminal.equals(parseTable[i][0])&& terminal.equals(parseTable[0][j]))
                 {
                     return parseTable[i][j];
                 }
             }
         }
         return "-";
     }
      /*
     this function use to return input stack after entering all input 
     * take two paramter input meaning stack will use in LL(1)
     & code is consider of input enter from user
     * * first  input second code 
     **/
     public stack initInputStack(stack input,String code)
     {
         input.push(":");
         String []token=StringHandler.split(code,'~');
         
         for(int i=token.length-1;i>-1;i--)
         {
                          
             String []token2=StringHandler.split(token[i]);
             
             for(int k=token2.length-1;k>-1;k--)
             {
                 input.push(token2[k]);
             }
                        
         }
         
         return input;
     }
     
     /* use to initilization process stack 
     meaning put : as $ in end of stack 
     take one paramter stack process
     **/
     public stack initProcessStack(stack process){
         process.push(":");
         return process;
     }
     
         
      public Output setOutput(String index,String parsingPop,String inputPop,String rule) {
        Output setObject =  new Output();
        setObject.setIndex(index);
        setObject.setProcess(parsingPop);
        setObject.setInput(inputPop);
        setObject.setRule(rule);    
        return setObject;
       
    }
      
    public String ReadFile(String path) throws  IOException{
        // System.out.println("in file" );
            FileInputStream in = null;
            String fileData="";
            try {
                try{
         in = new FileInputStream(path);
                }catch(FileNotFoundException e){
                    return "";
                }
         int c;
         while ((c = in.read()) != -1) {
             char x=(char)c;
           fileData+=x;
         }
      }finally {
         if (in != null) {
            in.close();
         }
      }
           // System.out.println("fileData :- " +fileData);
         return fileData;
     }
      
    /* LL 1 Parsing Algorithm  
     -- Taking Program Content as Argument
     -- Output the Input is Accepted or not
     */
    public ArrayList<Output> topDownAlgorithm(String program) throws IOException
        {
           // program=Require(program);
            ArrayList<Output> parsing = new ArrayList<>();
           program = program.replace("\n", " ").replace("\r", " ");
           // System.out.println(program);
           
            
            String []input=StringHandler.split(program);
            
            String path="";
            
           /* if(input[0].equals("require")){
                 path=input[2]+input[3];
                 String fileData=ReadFile(path);
                 ArrayList<Output> ReguireFile=this.topDownAlgorithm(fileData);
                 for(int i=0;i<ReguireFile.size();i++){
                    parsing.add(ReguireFile.get(i));
                 }
            }*/
            
            
             int step=parsing.size()+1;
            String parsingPop = "", inputPop = "" ,rule="";
            boolean findNonTerm,findTerm;
            int error = 0;
            String[] ruleArray;
            stack inputStack = new stack();
            stack parsingStack = new stack();
            
            inputStack = initInputStack(inputStack,program); 
            parsingStack=initProcessStack(parsingStack);
            
            // push Start Symbol
            parsingStack.push(parseTable[1][0]);
           
           //pop element to check
            parsingPop = parsingStack.pop();
            inputPop = inputStack.pop(); 
            
            while (true)
            {
                if(inputPop.equals("-")){
                    inputPop = "_";
            }
                findNonTerm = findNonTerminal(parsingPop);
                findTerm = findTerminal(inputPop);
             
                if(inputPop.equals("require")&&parsingPop.equals("require")){
                    
                 String braket=inputStack.pop();
                 //System.out.println("first braket "+braket);
                 String nameFile=inputStack.pop();
                 //System.out.println("name file "+nameFile);
                 String extention=inputStack.pop();
                // System.out.println("extention "+ extention);
                 path=nameFile+extention;
                 //System.out.println(" path "+path);
                 
                 inputStack.push(extention);
                 inputStack.push(nameFile);
                 inputStack.push(braket);
                 
                 String fileData=ReadFile(path);
                 if(!fileData.equals("")){
                 ArrayList<Output> RequireFile=this.topDownAlgorithm(fileData);
                 
                 for(int i=0;i<RequireFile.size();i++){
                     Output output=RequireFile.get(i);                     
                     output.setIndex(i+step+"");
                    parsing.add(RequireFile.get(i));
                 }
                 step=parsing.size()+1;
                 }   
                }

                if ( findNonTerm )
                {
                    if (findTerm == false && !inputPop.equals(":")) // if find ID String
                      {
                        //here if it was ID
                        if(parsingPop.equals("Fname"))
                                  inputPop = "STR";
                        else if(StringHandler.isCorrectID(inputPop))
                                    inputPop = "id";
                        else if(StringHandler.isNumber(inputPop))
                            inputPop = "intConstant";
                        else if(inputPop.charAt(0)=='\'')
                            inputPop = "charConstant";
                    }
                    //here we replace the rule
                    rule = findRule(parsingPop,inputPop);
                    if (rule != "-")
                    {
                        parsing.add(setOutput(Integer.toString(step++),StringHandler.copyStack(parsingStack)+parsingPop,inputPop+StringHandler.copyInputStack(inputStack),parsingPop+" --> "+rule));

                    

                        ruleArray=StringHandler.split(rule);
                        for (int i = ruleArray.length-1; i >= 0; i--)
                        {
                            parsingStack.push(ruleArray[i]);
                        }
                        
                    }
                    else
                    {
                        // if there's not exist a rule
                        parsing.add(setOutput(Integer.toString(step++),StringHandler.copyStack(parsingStack)+parsingPop,inputPop+StringHandler.copyInputStack(inputStack),"Syntax Error in "+inputPop));
                        error++;
                    }
                } else if(!findNonTerm && !parsingPop.equals(":")){  // If the top of parsing stack is Terminal
                    if (findTerm == false && !inputPop.equals(":")) // if find String
                      {
                        //here if it was ID
                        if(parsingPop.equals("id")){
                            if(StringHandler.isCorrectID(inputPop))
                                inputPop = "id";
                        }
                        else if(parsingPop.equals("intConstant")){
                            if(StringHandler.isNumber(inputPop))
                            inputPop = "intConstant";
                        }else if(parsingPop.equals("charConstant")){
                            inputPop = "charConstant";
                        }
                    }else if (parsingPop.equals("--") || parsingPop.equals("/-")){ // Ignore Comment
                            for (int i=0 ;;i++){
                                if (inputPop.equals("^") || inputPop.equals("-/")){
                                    inputStack.push(inputPop);
                                    break;
                                }
                                    inputPop = inputStack.pop(); 
                         }
                            inputPop = parsingPop;
                        }
                    if (inputPop.equals(parsingPop))
                        {
                              parsing.add(setOutput(Integer.toString(step++),StringHandler.copyStack(parsingStack)+parsingPop,inputPop+StringHandler.copyInputStack(inputStack),"Matched"));
                             //  System.out.println("Matched Terminal :( "+inputPop+" )");
                               inputPop = inputStack.pop(); 
                        }
                    else{
                            parsing.add(setOutput(Integer.toString(step++),StringHandler.copyStack(parsingStack)+parsingPop,inputPop+StringHandler.copyInputStack(inputStack),"Syntax Error in "+inputPop));

                             error++;
                    }
                           
                    }
                else
                {
                    //here Wrong in rule
                    parsing.add(setOutput(Integer.toString(step++),StringHandler.copyStack(parsingStack)+parsingPop,inputPop+StringHandler.copyInputStack(inputStack),"Syntax Error in "+inputPop));

                    //System.out.println("Error in parsing because rule is "+ rule);
                    error++;
                }
                parsingPop = parsingStack.pop();
               
                if (inputPop.equals(":")|| parsingPop.equals(":"))
                {
                    break;
                }
            } //End While
            
           if(inputPop.equals(":") && parsingPop.equals(":") && error == 0)
                {
                 parsing.add(setOutput(Integer.toString(step++),StringHandler.copyStack(parsingStack)+parsingPop,inputPop+StringHandler.copyInputStack(inputStack),"Accepted"));

                // System.out.println("Input is Accepted");   
                }
            else
            {
              parsing.add(setOutput(Integer.toString(step++),StringHandler.copyStack(parsingStack)+parsingPop,inputPop+StringHandler.copyInputStack(inputStack),"Not Accepted"));
            // System.out.println("Input is not Accepted");   
            }
           return parsing;
        }//End of Algorithm

  /*  public static void main(String[] args) throws IOException {
        ParseTable test = new ParseTable();
       // test.topDownAlgorithm("@ { -- require ( E:\\test .txt )  ***");
        for( Output pt : test.topDownAlgorithm(""){
            
            System.out.println(pt.getIndex() + "   |    " + pt.getProcess() + "    |     " + pt.getInput() + "    |      " + pt.getRule());
        }
      //  test.topDownAlgorithm("require ( E:\\test .txt ) ^ @ { ^ public # person { Ity # x ^ Ity # x { Ity # x ^ amal = safaa ^ ^ } } } $");
        
      /*  if(StringHandler.isNumber("11s1.")){
            System.out.println("true");
        }else
            System.out.println("false");
    } */
          
}