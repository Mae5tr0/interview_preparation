package chapter_7;

import java.util.ArrayList;

/**
 * Deck of Cards
 *
 * Design the data structures for a generic deck of cards.
 * Explain how you would subclass the data structures to implement blackjack.
 *
 */
public class Task_1 {

    public static void main(String[] args) { }

    private static class Deck<T extends Card> {
        private ArrayList<T> cards;

        private void shuffle() {}
    }

    private static abstract class Card {}

    private static abstract class Hand<T extends Card> {}
}