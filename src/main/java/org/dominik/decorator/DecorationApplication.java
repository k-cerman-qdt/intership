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

import java.util.Scanner;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
public class DecorationApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("Welcome to AMAZING ASCII ART APPLICATION!");
        System.out.println("Give me your amazing text to be decorated:");
        System.out.print("My input text: ");
        String input = scanner.nextLine();
        MessageDecoration decoration = new PlainTextMessageDecoration(input);
        while (true) {
            System.out.println("Choose your decoration:");
            System.out.println("- TERMINATE (stops a program)");
            System.out.println("- BACK (removes last decoration)"); // todo implement back - probably using LinkedLifoImpl?
            System.out.println("- underline");
            System.out.println("- uppercase");
            // todo add all other decorations
            // todo create 1 your own complex decoration with a test
            input = scanner.nextLine();

            if ("TERMINATE".equalsIgnoreCase(input)) {
                break;
            }
            decoration = switch (input) {
                case "underline" -> new UnderlineMessageDecoration(decoration);
                case "uppercase" -> new UppercaseDecorator(decoration);
                default -> {
                    System.out.println("Invalid input");
                    yield decoration;
                }
            };
            System.out.println();
            System.out.println(decoration.decorate());
            System.out.println();
            // todo output also all steps applied
        }

        System.out.println("Program terminated.");
        scanner.close();
    }
}
