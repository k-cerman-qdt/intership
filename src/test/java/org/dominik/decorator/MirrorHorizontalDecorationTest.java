package org.dominik.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
class MirrorHorizontalDecorationTest {

    @Test
    public void mirrorRight() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");
        decoration = new MirrorHorizontalDecoration(decoration, MirrorHorizontalDecoration.MirrorMode.RIGHT);

        assertEquals("""
                Ahoj|johA
                ====|====""", decoration.decorate());
    }
    @Test
    public void mirrorLeft() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");
        decoration = new MirrorHorizontalDecoration(decoration, MirrorHorizontalDecoration.MirrorMode.LEFT);

        assertEquals("""
                johA|Ahoj
                ====|====""", decoration.decorate());
    }
    @Test
    public void mirrorBoth() {
        MessageDecoration decoration = new PlainTextMessageDecoration("Ahoj");
        decoration = new MirrorHorizontalDecoration(decoration, MirrorHorizontalDecoration.MirrorMode.BOTH);

        assertEquals("""
                johA|Ahoj|johA
                ====|====|====""", decoration.decorate());
    }
}