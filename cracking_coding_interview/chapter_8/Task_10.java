package chapter_8;

import java.util.*;

/**
 * Paint Fill
 *
 * Implement the "paint fill" function that one might see on many image editing programs.
 * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
 * fill in the surrounding area until the color changes from the original color.
 *
 */
public class Task_10 {
    enum Color {
        Black(0), White(1), Red(2), Yellow(3), Green(4);

        private final int value;

        Color(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }


    public static void main(String[] args) {
        Color[][] screen = new Color[10][10];
        for (Color[] row : screen) {
            Arrays.fill(row, Color.Black);
        }
        screen[7][0] = Color.White;
        screen[7][1] = Color.White;
        screen[7][2] = Color.White;
        screen[7][3] = Color.White;
        screen[8][3] = Color.White;
        screen[9][3] = Color.White;
        printScreen(screen);

        fill(screen, 8, 2, Color.Green);
        System.out.println("==============================");

        printScreen(screen);
    }

    public static void fill(Color[][] screen, int r, int c, Color newColor) {
        if (screen[r][c] == newColor) return;

        fill(screen, r, c, screen[r][c], newColor);
    }

    public static void fill(Color[][] screen, int r, int c, Color oldColor, Color newColor) {
        int rows = screen.length;
        int columns = screen[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= columns || screen[r][c] != oldColor) return;

        screen[r][c] = newColor;
        fill(screen, r + 1, c, oldColor, newColor); // down
        fill(screen, r, c + 1, oldColor, newColor); // right
        fill(screen, r - 1, c, oldColor, newColor); // up
        fill(screen, r, c - 1, oldColor, newColor); // left
    }

    private static void printScreen(Color[][] screen) {
        for (Color[] row : screen) {
            System.out.println(Arrays.toString(row));
        }
    }
}
