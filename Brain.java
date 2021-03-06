package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;

    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        //what would you like me to do, Clever Human?
        driveDirect(500, 451);

    }

    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {
        readSensors(SENSORS_BUMPS_AND_WHEEL_DROPS);
        if (isBumpLeft()) {
            driveDirect(-250, 250);
            SystemClock.sleep(300);

            driveDirect(500, 451);
            SystemClock.sleep(450);
            driveDirect(500, 451);
        }
        if(isBumpRight()){
            driveDirect(-250, 250);
            SystemClock.sleep(1000);
            driveDirect(500,451);
        }
            // readSensors(6);
            //int getInfared = getInfraredByte();
            //driveDirect(300, -300);

            //dashboard.log(" " + getInfared);
//readSensors(SENSORS_BUMPS_AND_WHEEL_DROPS);

            //      if (isBumpLeft()) {
//driveDirect(-300,300);
//SystemClock.sleep(500);
//driveDirect(500,500);
            //      }

    }
}