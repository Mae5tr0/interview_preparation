package chapter_7;

import structures.HashMap;

/**
 *  Hash Table
 *
 *  Design and implement a hash table which uses chaining (linked lists) to handle collisions.
 *
 */
public class Task_12 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("abb", 12);
        map.put("abc", 14);
        map.put("cde", 15);

        System.out.println(map);
    }
}