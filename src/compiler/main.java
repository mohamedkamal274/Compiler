/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javafx.print.Collation;

/**
 *
 * @author mohamedkamal
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        transtionTable x = transtionTable.reservedWord("Kamal","Class");
        System.out.println(x.match("Kamalaa"));
    } 
}
