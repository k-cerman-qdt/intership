/*
 * *************************************************************************
 * * Yaypay CONFIDENTIAL   2024
 * * All Rights Reserved. * *
 * NOTICE: All information contained herein is, and remains the property of Yaypay Incorporated and its suppliers, if any.
 * The intellectual and technical concepts contained  herein are proprietary to Yaypay Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material  is strictly forbidden unless prior written permission is obtained  from Yaypay Incorporated.
 */

package org.dominik.decorator.decorations;

import org.dominik.decorator.MessageDecoration;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
public class DiamondDecoration implements MessageDecoration {
    private final MessageDecoration decorated;
    private final boolean fill;

    public DiamondDecoration(MessageDecoration decoration, boolean fill) {
        this.decorated = decoration;
        this.fill = fill;
    }

    @Override
    public String toString() {
        return "diamond";
    }

    @Override
    public String decorate() {
        return ""; // todo implement
    }
}