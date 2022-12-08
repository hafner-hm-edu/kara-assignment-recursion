package edu.hm.hafner.kara;

import static de.i8k.karalight.Kara.*;

/**
 * KaraLight: solution of assignment 17.
 *
 * @author Ullrich Hafner
 */
public class Assignment17 {
    /**
     * Entrypoint for Kara: this method is called once if you press the 'Ausführen' button in KaraLight.
     *
     * @param unused
     *         this parameter is not used by KaraLight
     */
    public static void main(final String... unused) {
        int length = computeLength();

        sierpinski(0, 0, length, length);
    }

    private static void sierpinski(final int x, final int y, final int breite, final int hoehe) {
        if (breite > 2 && hoehe > 2) {
            int b = breite / 3;
            int h = hoehe / 3;
            fillRectangle(x + b, y + h, b, h);
            for (int k = 0; k < 9; k++) {
                if (k != 4) {
                    int i = k / 3;
                    int j = k % 3;
                    sierpinski(x + i * b, y + j * h, b, h);
                }
            }
        }
    }

    private static void down(final boolean isWalkingToTheRight) {
        turn(isWalkingToTheRight);
        turn(isWalkingToTheRight);
    }

    private static void turn(final boolean isWalkingToTheRight) {
        if (isWalkingToTheRight) {
            turnRight();
        }
        else {
            turnLeft();
        }
        move();
    }

    private static void moveKara(final int numberOfSteps) {
        for (int i = numberOfSteps; i > 0; i--) {
            move();
        }
    }

    private static void movePosition(final int x, final int y) {
        if (x < 0) {
            turnAround();
            moveKara(-x);
            turnAround();
        }
        else {
            moveKara(x);
        }
        if (y < 0) {
            turnLeft();
            moveKara(-y);
            turnRight();
        }
        else {
            turnRight();
            moveKara(y);
            turnLeft();
        }
    }

    private static void fillRectangle(final int x, final int y,
            final int width, final int height) {
        movePosition(x, y);
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                putLeaf();
                move();
            }
            down(row % 2 == 0);
        }
        turnAround();
        move();
        movePosition(-x - width, -y - height);
    }

    private static void turnAround() {
        turnRight();
        turnRight();
    }

    private static int computeLength() {
        int length = 0;
        while (!isOnLeaf()) {
            if (length == 0) {
                putLeaf();
            }
            move();
            length++;
        }
        pickLeaf();

        return length;
    }
}
