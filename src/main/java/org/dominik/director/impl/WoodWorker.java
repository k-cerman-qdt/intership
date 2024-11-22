/*
 * *************************************************************************
 * * Yaypay CONFIDENTIAL   2024
 * * All Rights Reserved. * *
 * NOTICE: All information contained herein is, and remains the property of Yaypay Incorporated and its suppliers, if any.
 * The intellectual and technical concepts contained  herein are proprietary to Yaypay Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material  is strictly forbidden unless prior written permission is obtained  from Yaypay Incorporated.
 */

package org.dominik.director.impl;

import org.dominik.director.api.Basement;
import org.dominik.director.api.Chimney;
import org.dominik.director.api.House;
import org.dominik.director.api.Roof;
import org.dominik.director.api.Wall;
import org.dominik.director.api.Worker;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
public class WoodWorker implements Worker {

    @Override
    public Roof buildRoof() {
        return new Roof("wooden roof covered by leaves");
    }

    @Override
    public Basement buildBasement() {
        return new Basement("temporary bamboo-basement");
    }

    @Override
    public Wall buildWall() {
        return new Wall("tiny walls from OSB desks");
    }

    @Override
    public Chimney buildChimney() {
        return new Chimney("no chimney");
    }

    @Override
    public String buildSomethingExtra() {
        return "table in a kitchen";
    }
}
