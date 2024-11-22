package org.dominik.decorator.decorations;

import org.dominik.decorator.MessageDecoration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
class FramedWithDashesDecorationTest {

    @Test
    public void boxedTextDecorationTest() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");
        decoration = new FramedWithDashesDecoration(decoration);

        assertEquals("""
                +------+
                | Ahoj |
                +------+""", decoration.decorate());
    }
}