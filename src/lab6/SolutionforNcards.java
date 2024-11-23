package lab6;

import java.io.*;
import java.util.*;
 
public class SolutionforNcards{

    public static Queue<Integer> solution(int n){

        Queue<Integer> cards = new LinkedList<Integer>();
        Queue<Integer> discard = new LinkedList<Integer>();
        //******************** Write your code here ********************//
        // Step 1: Initialize the deck of cards
        for(int i = 1; i <=n; i++){
            cards.offer(i);
        }
        while(!cards.isEmpty()){
            // Step 2: Shuffle the deck of cards
            discard.offer(cards.poll());

            if(!cards.isEmpty()){
            }
        }
        while(!discard.isEmpty()){
            cards.offer(discard.poll());
        }
    






        //**************************************************************//
        return cards;

    }

}
