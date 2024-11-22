package org.dominik.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
class MirrorUnderneathDecorationTest {

    @Test
    public void boxedTextDecorationTest() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");
        decoration = new UnderlineMessageDecoration(decoration);
        decoration = new MirrorUnderneathDecoration(decoration);

        assertEquals("""
                Ahoj
                ====
                ----
                ====
                Ahoj
                ********""", decoration.decorate());
    }
}