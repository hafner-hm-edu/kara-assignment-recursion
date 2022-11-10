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
        // Beispielcode, kann entfernt werden
        if (isOnLeaf()) {
            pickLeaf();
        }
        else {
            putLeaf();
        }
    }
}
