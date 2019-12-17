package chapter_7;


import java.util.ArrayList;

/**
 *
 */
public class Task_11 {
    public static void main(String[] args) { }

    class FileSystem {
        Item root;

        public FileSystem() {
            this.root = new Folder("", null);
        }

        Item get(String path) {
            return root.get(path);
        }
    }

    abstract class Item {
        Item parent;
        String name;

        public Item(String name, Item parent) {
            this.name = name;
            this.parent = parent;
        }

        public abstract int size();
        public abstract Item get(String path);
    }

    class File extends Item {
        private int size;

        // metadata
        // size, restriction and etc.

        public File(String name, Item parent) {
            super(name, parent);
        }

        public int size() {
            return size;
        }

        public Item get(String path) {
            return this;
        }
    }

    class Folder extends Item {
        ArrayList<Item> items;

        public Folder(String name, Item parent) {
            super(name, parent);
        }

        public int size() {
            int totalSize = 0;

            for (Item item : items) {
                totalSize += item.size();
            }
            return totalSize;
        }

        public void createFolder() {

        }

        public void createFile() {

        }

        // /fadsfa/sdfas/dfasf
        public Item get(String path) {


            return null;
        }

        // metadata
        // restrictions
    }
}