package org.dominik.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
class DiamondDecorationTest {

    @Test
    public void boxedTextDecorationTest() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");
        decoration = new DiamondDecoration(decoration, true);

        assertEquals("""
                   **
                  ****
                 ******
                * Ahoj *
                 ******
                  ****
                   **""", decoration.decorate());
    }

    @Test
    public void boxedTextDecorationEvenTest() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Cus");
        decoration = new DiamondDecoration(decoration, true);

        assertEquals("""
                   *
                  ***
                 *****
                * Cus *
                 *****
                  ***
                   *""", decoration.decorate());
    }
    @Test
    public void boxedTextDecorationNoFillTest() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");
        decoration = new DiamondDecoration(decoration, false);

        assertEquals("""
                   **
                  *  *
                 *    *
                * Ahoj *
                 *    *
                  *  *
                   **""", decoration.decorate());
    }

    @Test
    public void boxedTextDecorationEvenNoFillTest() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Cus");
        decoration = new DiamondDecoration(decoration, true);

        assertEquals("""
                   *
                  * *
                 *   *
                * Cus *
                 *   *
                  * *
                   *""", decoration.decorate());
    }
}