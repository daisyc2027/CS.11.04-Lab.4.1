
import java.util.Scanner;

import static java.lang.Character.getNumericValue;

public class Main {


    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str){
            return str.length()%2 == 0 && str.charAt(0) != ')' && str.charAt(str.length()-1) != '(';
    }


    // 2. reverseInteger
    public static String reverseInteger(int a){
        String aAsString = String.valueOf(a);
        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i< aAsString.length(); i++){
            finalString.append(aAsString.length() - i);
        }
        return finalString.toString();
    }


    // 3. encryptThis
public static String encryptThis(String message){
        Scanner sc = new Scanner(message);
        StringBuilder newMessage = new StringBuilder();
        String currentWord;
//Am I allowed to use split this string into an array?
        while(sc.hasNext()){
            currentWord = sc.next();
            String middle;
            char secondLetter = currentWord.charAt(currentWord.length()-1);
            String lastLetter;
            if(currentWord.length() > 2) {
                middle = currentWord.substring(2, currentWord.length() - 1);
                lastLetter = String.valueOf(currentWord.charAt(1));
            }
            else{
                middle = "";
                lastLetter = "";
            }
            int firstLetter = currentWord.charAt(0);
            currentWord = String.valueOf(firstLetter) + secondLetter + middle + lastLetter;
            newMessage.append(currentWord);
            if(sc.hasNext()){
                newMessage.append(" ");
            }
        }
        return newMessage.toString();
    }

    // 4. decipherThis
    public static String decipherThis(String message){
        String[] words = message.split(" ");
        StringBuilder finalMessage = new StringBuilder();
        String currentWord = "";
        for (int i = 0; i<words.length; i++){
            currentWord = words[i];

            StringBuilder numberList = new StringBuilder();
            StringBuilder wordList = new StringBuilder();

            for(char c: currentWord.toCharArray()){
                if(Character.isDigit(c)){
                    numberList.append(c);
                } else{
                    wordList.append(c);
                }
            }

            char numberCode = (char) Integer.parseInt(numberList.toString());
            String wordLetters = wordList.toString();
            currentWord = numberCode + wordLetters;
//Hollegdoodya
            char secondLetter = currentWord.charAt(currentWord.length()-1);
            String lastLetter = "";
            String middle = "";
            if(currentWord.length()>2){
                middle = currentWord.substring(2, currentWord.length() - 1);
                lastLetter = String.valueOf(currentWord.charAt(1));
            }
            currentWord = String.valueOf(numberCode) + secondLetter + middle + lastLetter;
            finalMessage.append(currentWord);

            if(i != words.length-1){
                finalMessage.append(" ");
            }
        }

        return finalMessage.toString();
    }


}