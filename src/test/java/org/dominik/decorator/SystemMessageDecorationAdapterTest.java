package org.dominik.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
class SystemMessageDecorationAdapterTest {

    @Test
    public void returnSameText() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");

        assertEquals("Ahoj", decoration.decorate());
    }
}