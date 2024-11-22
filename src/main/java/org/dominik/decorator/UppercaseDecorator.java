/*
 * *************************************************************************
 * * Yaypay CONFIDENTIAL   2024
 * * All Rights Reserved. * *
 * NOTICE: All information contained herein is, and remains the property of Yaypay Incorporated and its suppliers, if any.
 * The intellectual and technical concepts contained  herein are proprietary to Yaypay Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material  is strictly forbidden unless prior written permission is obtained  from Yaypay Incorporated.
 */

package org.dominik.decorator;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
public class UppercaseDecorator implements MessageDecoration {
    private final MessageDecoration decorated;

    public UppercaseDecorator(MessageDecoration decorated) {
        this.decorated = decorated;
    }

    @Override
    public String decorate() {
        return decorated.decorate().toUpperCase();
    }
}
