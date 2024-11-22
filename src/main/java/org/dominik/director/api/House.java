/*
 * *************************************************************************
 * * Yaypay CONFIDENTIAL   2024
 * * All Rights Reserved. * *
 * NOTICE: All information contained herein is, and remains the property of Yaypay Incorporated and its suppliers, if any.
 * The intellectual and technical concepts contained  herein are proprietary to Yaypay Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material  is strictly forbidden unless prior written permission is obtained  from Yaypay Incorporated.
 */

package org.dominik.director.api;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
public class House {
    Basement basement;
    Wall wall;
    Roof roof;
    String extra;
    Chimney chimney;

    @Override
    public String toString() {
        return String.format("A nice house built on %s with %s covered by " +
                        "astonishing %s with %s and with nowhere-else-seen %s",
                basement.name(), wall.name(), roof.name(), chimney.name(), extra);
    }

    public void setBasement(Basement basement) {
        this.basement = basement;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setChimney(Chimney chimney) {
        this.chimney = chimney;
    }
}
