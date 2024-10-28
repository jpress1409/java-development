package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("How many players are there?");
        int numPlayers = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for person " + (i + 1) + ": ");
            String name = scan.nextLine();

            Player[] player = new Player[numPlayers];
            Hand[] hand = new Hand[numPlayers];

            player[i] = new Player(name);
            hand[i] = new Hand();

            hand[i].deal(deck.deal());
            hand[i].deal(deck.deal());




            System.out.println(player[i] + "'s hand.");
            for(Player players : player){

            }

        }
    }
}
