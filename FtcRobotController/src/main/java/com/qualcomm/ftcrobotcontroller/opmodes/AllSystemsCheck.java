package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Jay on 11/8/2015.
 */
public class AllSystemsCheck extends OpHelperClean {

    public AllSystemsCheck() {

    }

    public double leftMotorPower = 0;
    public double rightMotorPower = 0;

    enum RunState {
        Test_Left;
        Test_Left_Fast;
        Test_Right;
        Test_Right_Fast;
        Test_Arm_Elbow;
        Test_Tape_Measure;
        Test_Zipliner;
        Test_End;
    }

    private boolean Works[] = new boolean[7];

    private RunState runstate = Runstate.Test_Left;

    int Position = 0;

    public void init() {

       for (int i = 0; i < 7; i++)
          Works[i] = false;
    }

    public void loop() {

        switch (runstate) {

            case Test_Left: {

                setMotorPower(0.5, 0);
                Works[1] = true;
                runstate = Test_Left_Fast;

            }

            case Test_Left_Fast: {

               setMotorPower(1, 0);
               Works[2] = true;
               runstate = Test_Right;

            }

            case Test_Right: {

                setMotorPower(0, 0.5);
                Works[3] = true;
                runstate = Test_Right_Fast;

            }

            case Test_Right_Fast: {

               setMotorPower(0, 1);
               Works[4] = true;
               runstate = Test_Arm_Elbow;

            }

            case Test_Arm_Elbow: {

                setArmPivot(.5);
                Works[5] = true;
                runstate = Test_Tape_Measure;

            }

            case Test_Tape_Measure: {

                moveTapeMeasure(.5);
                Works[6] = true;
                runstate = Test_Zipliner;

            }

            case Test_Zipliner: {

                setMotorPower(0, 1);
                Works[7] = true;
                runstate = Test_End;

            }

            case Test_End: {

                setMotorPower(0, 0);
                setArmPivot(0);
                moveTapeMeasure(-.5);

            }

        }

        telemetry.addData("Left Motors Slow Work: ", Works[1]);
        telemetry.addData("Left Motors Fast Work: ", Works[2]);
        telemetry.addData("Right Motors Slow Work: ", Works[3]);
        telemetry.addData("Right Motors Fast Work: ", Works[4]);
        telemetry.addData("Arm Works: ", Works[5]);
        telemetry.addData("Tape Measures Work", Works[6]);
        telemetry.addData("Zipliner Pusher Works: ", Works[7]);

    }

    public void stop() {

    }

}


