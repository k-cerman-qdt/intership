package org.dominik.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
class UnderlineMessageDecorationTest {

    @Test
    public void returnsUnderlineMessage() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");
        decoration = new UnderlineMessageDecoration(decoration);

        assertEquals("""
                Ahoj
                ====""", decoration.decorate());
    }

    @Test
    public void returnsUnderlineMessageLonger() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Nazdar");
        decoration = new UnderlineMessageDecoration(decoration);

        assertEquals("""
                Nazdar
                ======""", decoration.decorate());
    }
}