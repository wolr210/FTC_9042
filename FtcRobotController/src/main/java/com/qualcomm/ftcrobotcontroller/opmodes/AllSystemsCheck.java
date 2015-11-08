package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Jay on 11/8/2015.
 */
public class AllSystemsCheck extends OpHelperClean {

    public AllSystemsCheck {

    }

    public void loop() {

        setDirection();
        setToEncoderMode();
        resetEncoders();

        runStraight(10, true);

        rightTarget = 10;
        leftTarget = 0;

       setMotorPower(.2, .8);

    }

}
