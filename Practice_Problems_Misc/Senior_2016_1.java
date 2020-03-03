package Practice_Problems_Misc;

import java.util.ArrayList;
import java.util.Scanner;

public class Senior_2016_1 {

    public static void main(String[] args) {
        String finalString = "";
        Scanner scan = new Scanner(System.in);
        for(int d = 0; d < 5; d++) {
            String[] data = scan.nextLine().split(", ");
            Card[] cards = new Card[data.length];
            for (int i = 0; i < data.length; i++) {
                cards[i] = new Card(data[i].charAt(0), data[i].charAt(1));
            }
            Card top = cards[0];
            Card[] hand = new Card[cards.length - 1];
            for (int i = 0; i < hand.length; i++) {
                hand[i] = cards[i + 1];
            }
            Card out = new Card('-', '0');
            for (int i = 0; i < hand.length; i++) {
                if (hand[i].getSuit() == top.getSuit() && hand[i].getValue() > top.getValue() && hand[i].getValue() < out.getValue()) {
                    out = hand[i];
                }
            }
            if (out.getValue() == 15) {
                for (int i = 0; i < hand.length; i++) {
                    if (hand[i].getSuit() == top.getSuit() && hand[i].getValue() < out.getValue()) {
                        out = hand[i];
                    }
                }
            }
            if (out.getValue() == 15) {
                Card tmp = new Card('-', '0');
                for (int i = 0; i < hand.length; i++) {
                    if (hand[i].getValue() < tmp.getValue()) tmp = hand[i];
                }
                ArrayList<Card> listToCheck = new ArrayList<>();
                for (int i = 0; i < hand.length; i++) {
                    if (hand[i].getValue() == tmp.getValue()) {
                        listToCheck.add(hand[i]);
                    }
                }
                if (getOfSuit(listToCheck, 'C') != null) out = getOfSuit(listToCheck, 'C');
                else if (getOfSuit(listToCheck, 'D') != null) out = getOfSuit(listToCheck, 'D');
                else if (getOfSuit(listToCheck, 'H') != null) out = getOfSuit(listToCheck, 'H');
                else if (getOfSuit(listToCheck, 'S') != null) out = getOfSuit(listToCheck, 'S');

            }
            finalString += out.print() + "\n";
        }
        System.out.println("\n" + finalString);
    }

    public static Card getOfSuit(ArrayList<Card> listToCheck, char suit){
        for(int i = 0; i < listToCheck.size(); i++){
            if(listToCheck.get(i).getSuit() == suit){
                return listToCheck.get(i);
            }
        }
        return null;
    }
}

class Card{

    private int value;
    private char suit;

    public Card(char a, char b){
        if(a=='A') value = 1;
        else if(a=='T') value = 10;
        else if(a=='J') value = 11;
        else if(a=='Q') value = 12;
        else if(a=='K') value = 13;
        else if(a=='-') value = 15;
        else value = Integer.parseInt("" + a);
        suit = b;
    }

    public int getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }

    public String print(){
        if(value == 1) return "A" + suit;
        else if(value == 10) return "T" + suit;
        else if(value == 11) return "J" + suit;
        else if(value == 12) return "Q" + suit;
        else if(value == 13) return "K" + suit;
        else return "" + value + suit;

    }
}