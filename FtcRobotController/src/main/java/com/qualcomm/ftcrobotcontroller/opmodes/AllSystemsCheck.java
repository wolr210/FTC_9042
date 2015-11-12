package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Jay on 11/8/2015.
 */
public class AllSystemsCheck extends OpHelperClean {

    public AllSystemsCheck() {

    }

    public double leftMotorPower = 0;
    public double rightMotorPower = 0;

    public void init() {

    }

    public void loop() {

        leftMotorPower = Math.random();
        rightMotorPower = Math.random();
        setArmPivot(Math.random());

        setDirection();
        setToEncoderMode();
        resetEncoders();

       setMotorPower(leftMotorPower, rightMotorPower);


    }

    public void stop() {

        leftMotorPower = 0;
        rightMotorPower = 0;

    }

}


