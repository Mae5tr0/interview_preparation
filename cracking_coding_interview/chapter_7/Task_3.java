package chapter_7;

import structures.LinkedList;

import java.util.ArrayList;

/**
 * Jukebox
 *
 * Design a musical jukebox using object-oriented principles.
 *
 */
public class Task_3 {

    public static void main(String[] args) { }

    public static class Jukebox {
        ArrayList<Song> songs;

        public Song selectSong() {
            return null;
        }
    }

    public abstract static class Song {
        public abstract void play();
    }

    public class Playlist {
        private LinkedList<Song> queue;

        public Song getNextSongToPlay() {
            return queue.dequeue();
        }

        public void add(Song song) {
                queue.enqueue(song);
        }
    }

}