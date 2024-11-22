package org.dominik.decorator.decorations;

import org.dominik.decorator.MessageDecoration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
class PlainTextMessageDecorationTest {
    @Test
    public void testHappyCase() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");

        assertEquals("Ahoj", decoration.decorate());
    }

    @Test
    public void testRemovesEmptySpaces() {
        MessageDecoration decoration = new PlainTextMessageDecoration(" A hoj ");

        assertEquals("A hoj", decoration.decorate());
    }
}