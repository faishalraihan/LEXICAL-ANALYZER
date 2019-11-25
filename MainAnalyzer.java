/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faishal Raihan
 */
import java.util.Scanner;
import java.util.*;

public class MainAnalyzer {

    public static void main(String[] args) {
        Stack<String> lexical = new Stack<String>();
        Stack<String> token = new Stack<String>();
        Scanner sc = new Scanner(System.in);
        String lex = sc.nextLine();
        int i = 0;
        //Tahap 1
        while (i < lex.length()) {
            if(lex.charAt(i) == ' '){
                i++;
            }else if ((lex.charAt(i) == 'p' || lex.charAt(i) == 'q' || lex.charAt(i) == 'r' || lex.charAt(i) == 's') && i == lex.length()- 1){
                token.push("1");
                break;
            }else if ((lex.charAt(i) == 'p' || lex.charAt(i) == 'q' || lex.charAt(i) == 'r' || lex.charAt(i) == 's')&& lex.charAt(i+1) == ' ') {
                token.push("1");
                //System.out.println(token.get(i));
                i++;
            } else if (lex.charAt(i) == 'n' && lex.charAt(i + 1) == 'o' && lex.charAt(i + 2) == 't' && lex.charAt(i + 3) == ' ') {
                token.push("2");
                //System.out.println(token.get(i));
                i = i + 3;
            } else if (lex.charAt(i) == 'a' && lex.charAt(i + 1) == 'n' && lex.charAt(i + 2) == 'd' && lex.charAt(i + 3) == ' ') {
                token.push("3");
                //System.out.println(token.get(i));
                i = i + 3;
            } else if (lex.charAt(i) == 'o' && lex.charAt(i + 1) == 'r' && lex.charAt(i + 2) == ' ') {
                token.push("4");
                //System.out.println(token.get(i));
                i = i + 2;
            } else if (lex.charAt(i) == 'x' && lex.charAt(i + 1) == 'o' && lex.charAt(i + 2) == 'r' && lex.charAt(i + 3) == ' ') {
                token.push("5");
                //System.out.println(token.get(i));
                i = i + 3;
            } else if (lex.charAt(i) == 'i' && lex.charAt(i + 1) == 'f' && lex.charAt(i + 2) == ' ') {
                token.push("6");
                //System.out.println(token.get(i));
                i = i + 2;
            } else if (lex.charAt(i) == 'i' && lex.charAt(i + 1) == 'f' && lex.charAt(i + 2) == 'f' && lex.charAt(i + 3) == ' ') {
                token.push("8");
                //System.out.println(token.get(i));
                i = i + 3;
            } else if (lex.charAt(i) == 't' && lex.charAt(i + 1) == 'h' && lex.charAt(i + 2) == 'e' && lex.charAt(i + 3) == 'n' && lex.charAt(i + 4) == ' ') {
                token.push("7");
                //System.out.println(token.get(i));
                i = i + 4;
            } else if (lex.charAt(i) == '(' && lex.charAt(i + 1) == ' ') {
                token.push("9");
                //System.out.println(token.get(i));
                i++;
            } else if (lex.charAt(i) == ')') {
                token.push("10");
                //System.out.println(token.get(i));
                i++;
            }else{
                token.push("Error");
                break;
            }
        }
        //display token
        System.out.print("Hasil Token: ");
        for (int j = 0; j < token.size(); j++) {
            System.out.print(token.get(j) + " ");
        }
        
        //Tahap 2
        int y = 0;
        lexical.push("#");
        while(!lexical.isEmpty()){
            if(token.get(y) == "Error"){
                System.out.println("Tidak Valid");
                break;
            }else if(token.get(y) == "1"){
                if(lexical.peek().equals("#")&& y == token.size()-1){
                        lexical.pop();
                        break;
                }else if(y != token.size()-1){
                    if(token.get(y+1).equals("3") || token.get(y+1).equals("4") || token.get(y+1).equals("5") || token.get(y+1).equals("8") || token.get(y+1).equals("9") || token.get(y+1).equals("7") || token.get(y+1).equals("10") ){
                        y++;
                    }else{
                        System.out.println("Tidak Valid1");
                        break;
                        }
                }else if(y == token.size() -1 && !lexical.peek().equals("#")){
                    System.out.println("Tidak Valid");
                    break;
                }
                
                    
            }else if(token.get(y) == "2"){
                if(y != token.size()-1){
                   if(token.get(y+1).equals("1") || token.get(y+1).equals("9")){
                      y++;
                    }else{
                        System.out.println("Tidak Valid2");
                        break;
                    }
                }else{
                   System.out.println("Tidak Valid3");
                   break;
                }
            }else if(token.get(y) == "3"){
                if(y != token.size()-1){
                   if(token.get(y+1).equals("1") || token.get(y+1).equals("9") || token.get(y+1).equals("2")){
                      y++;
                    }else{
                        System.out.println("Tidak Valid4");
                        break;
                    }
                }else{
                   System.out.println("Tidak Valid5");
                   break;
                }
            }else if(token.get(y) == "4"){
                if(y != token.size()-1){
                   if(token.get(y+1).equals("1") || token.get(y+1).equals("9")){
                      y++;
                    }else{
                        System.out.println("Tidak Valid6");
                        break;
                    }
                }else{
                   System.out.println("Tidak Valid7");
                   break;
                }
            }else if(token.get(y) == "5"){
                if(y != token.size()-1){
                   if(token.get(y+1).equals("1") || token.get(y+1).equals("9")){
                      y++;
                    }else{
                        System.out.println("Tidak Valid8");
                        break;
                    }
                }else{
                   System.out.println("Tidak Valid9");
                   break;
                }
            }else if(token.get(y) == "6"){
                lexical.push("if");
                if(y != token.size()-1){
                    if(token.get(y+1).equals("1") || token.get(y+1).equals("9")){
                      y++;
                    }else{
                           System.out.println("Tidak Valid9");
                           break;
                        }
                }else{
                    System.out.println("Tidak Valid10");
                    break;
                    }
            }else if(token.get(y) == "7"){
                if(y != token.size()-1){
                   if(lexical.peek() == "if"){
                       lexical.pop();
                   }
                    if(token.get(y+1).equals("1") || token.get(y+1).equals("9")){
                      y++;
                    }else{
                            System.out.println("Tidak Valid11");
                            break;
                        }
                }else{
                    System.out.println("Tidak Valid12");
                    break;
                    }
            }else if(token.get(y) == "8"){
                 if(y != token.size()-1){
                   if(token.get(y+1).equals("1") || token.get(y+1).equals("9")){
                      y++;
                    }else{
                        System.out.println("Tidak Valid8");
                        break;
                    }
                }else{
                   System.out.println("Tidak Valid9");
                   break;
                }
            }else if(token.get(y) == "9"){
                lexical.push("(");
                 if(y != token.size()-1){
                   if(token.get(y+1).equals("1") || token.get(y+1).equals("9")){
                      y++;
                    }else{
                        System.out.println("Tidak Valid8");
                        break;
                    }
                }else{
                   System.out.println("Tidak Valid9");
                   break;
                }
            }else if(token.get(y) == "10"){
               if(y != token.size()-1){
                        if(lexical.peek() == "("){
                        lexical.pop();
                        }
                        if(token.get(y+1).equals("3") ||token.get(y+1).equals("4") || token.get(y+1).equals("5") || token.get(y+1).equals("8") || token.get(y+1).equals("10") || token.get(y+1).equals("7")){
                            y++;
                        }else{
                            System.out.println("Tidak Valid17");
                            break;
                        }
               }else if(y == token.size() - 1 && lexical.peek() == "("){
                   lexical.pop();
                   if(y == token.size() - 1 && lexical.peek() == "("){
                       System.out.println("Tidak Valid90");
                       break;
                   }
               }else if( y == token.size()-1 && lexical.peek() == "#"){
                    lexical.pop();
                    break;
                
            }else if(y == token.size() - 1 && lexical.peek() != "#"){
                   System.out.println("Tidak Valid");
                   break;
            }
        }
            //System.out.println(lexical.peek());
    }
        //System.out.println(lexical.peek());
      
        if(lexical.isEmpty()){
                System.out.println("Valid");
            }   
         
    }
}
