package org.dominik.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
class UppercaseDecoratorTest {

    @Test
    public void testUpperCase() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");
        decoration = new UppercaseDecorator(decoration);

        assertEquals("AHOJ", decoration.decorate());
    }
}