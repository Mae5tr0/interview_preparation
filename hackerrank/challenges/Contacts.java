package challenges;

public class Contacts {
    static class Tries {
        private Node root;

        public void add(String s) {
            if (s == null || s.length() == 0) return;
            root = put(root, s, 0);
        }

        private Node put(Node node, String key, int d) {
            char current = key.charAt(d);
            if (node == null) node = new Node(current);

            if (current < node.c) node.left = put(node.left, key, d);
            else if (current > node.c) node.right = put(node.right, key, d);
            else if (d + 1 < key.length()) node.mid = put(node.mid, key, d + 1);
            else node.word = true;

            return node;
        }

        public int partial(String prefix) {
            if (prefix == null || prefix.length() == 0) return 0;

            Node prefixNode = get(root, prefix, 0);
            if (prefixNode == null) return 0;

            return words(prefixNode.mid) + (prefixNode.word ? 1 : 0);
        }

        private Node get(Node node, String prefix, int d) {
            if (node == null) return null;

            char current = prefix.charAt(d);
            if (current < node.c) return get(node.left, prefix, d);
            else if (current > node.c) return get(node.right, prefix, d);
            else if (d + 1 < prefix.length()) return get(node.mid, prefix, d + 1);
            else return node;
        }

        private int words(Node node) {
            if (node == null) return 0;

            return words(node.left) + words(node.mid) + words(node.right) + (node.word ? 1 : 0);
        }

        private class Node {
            private char c;
            private Node left, mid, right;
            private boolean word = false;

            public Node(char c) {
                this.c = c;
            }
        }
    }

    public static void main(String[] args) {
        Tries tr = new Tries();

        tr.add("hack");
        tr.add("hackerrank");
        tr.add("");


        System.out.println(tr.partial("hac")); // 2
        System.out.println(tr.partial("hak")); // 0
        System.out.println(tr.partial(""));
    }

//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        Tries tr = new Tries();
//
//        for (int nItr = 0; nItr < n; nItr++) {
//            String[] opContact = scanner.nextLine().split(" ");
//
//            String op = opContact[0];
//            String contact = opContact[1];
//
//            if (op.equals("add")) {
//                tr.add(contact);
//            }
//            if (op.equals("find")) {
//                System.out.println(tr.partial(contact));
//            }
//        }
//
//        scanner.close();
//    }
}
