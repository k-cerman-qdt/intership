/*
 * *************************************************************************
 * * Yaypay CONFIDENTIAL   2024
 * * All Rights Reserved. * *
 * NOTICE: All information contained herein is, and remains the property of Yaypay Incorporated and its suppliers, if any.
 * The intellectual and technical concepts contained  herein are proprietary to Yaypay Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material  is strictly forbidden unless prior written permission is obtained  from Yaypay Incorporated.
 */

package org.dominik.director;

import org.dominik.director.api.House;
import org.dominik.director.api.Worker;
import org.dominik.director.impl.WoodWorker;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
public class App {
    public static void main(String[] args) {
        // a director pattern
        // worker knows how to build it
        // director knows in which order and what to call
        HouseBuilderDirector director = new HouseBuilderDirector();
        Worker woodWorker = new WoodWorker();

        House woodenHouse = director.buildHouse(woodWorker);
        System.out.println(woodenHouse.toString());
    }
}
