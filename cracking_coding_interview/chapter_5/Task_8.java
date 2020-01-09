package chapter_5;

import java.util.Arrays;

/**
 * Draw Line
 *
 * A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored in one byte.
 * The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows).
 * The height of the screen, of course, can be derived from the length of the array and the width.
 * Implement a function that draws a horizontal line from (xl, y) to ( x2, y).
 *
 */
public class Task_8 {
    public static void main(String[] args) {
        byte[] screen = new byte[15];

        drawline(screen, 24, 12, 22, 3);

        printScreen(screen, 24);
    }

    public static void drawline(byte[] screen, int width, int x1, int x2, int y) {
        if (x1 < 0 | x1 >= x2 | x2 > width) throw new IllegalArgumentException("Line should be in 0 and " + width);
        int height = screen.length  / (width / 8) ;

        if (y < 0 | y > height) throw new IllegalArgumentException("Y should be between 0 and " + height);

        int currentByte = y * width / 8 + x1 / 8;
        int currentPosition = x1 % 8;

        int rest = x2 - x1;
        while (rest > 0) {
            int length = Math.min(8 - currentPosition, rest);
            screen[currentByte] = setBits(currentPosition, length);

            rest -= length;
            currentByte++;
            currentPosition = 0;
        }
    }

    private static byte setBits(int position, int length) {
        return (byte) (0xFF >> position & (0xFF << (8 - (position  + length))));
    }

    private static void printScreen(byte[] screen, int width) {
        int elementsInRow = width / 8;
        String[] row = new String[elementsInRow];

        for (int i = screen.length - 1; i >= 0; i--) {
            byte el = screen[i];
            row[i % elementsInRow] = Integer.toBinaryString(el & 255 | 256).substring(1);

            if (i % elementsInRow == 0) System.out.println(Arrays.toString(row));
        }
    }
}
