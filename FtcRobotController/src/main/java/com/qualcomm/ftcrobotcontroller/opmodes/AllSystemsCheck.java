package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Jay on 11/8/2015.
 */
public class AllSystemsCheck extends OpHelperClean {

    public AllSystemsCheck() {

    }

    enum RunState {
        Test_Left,
        Test_Left_Fast,
        Test_Right,
        Test_Right_Fast,
        Test_Arm_Elbow,
        Test_Tape_Measure,
        Test_Zipliner,
        Test_End;
    }

    boolean Works[] = new boolean[7];

    private RunState runstate = RunState.Test_Left;

    public void init() {

       for (int i = 0; i < 6; i++)
          Works[i] = false;
    }

    @Override
    public void loop() {

        switch (runstate) {

            case Test_Left: {

                setMotorPower(0.5, 0);
                Works[0] = true;
                runstate = RunState.Test_Left_Fast;
                setMotorPower(0, 0);
                break;

            }

            case Test_Left_Fast: {

               setMotorPower(1, 0);
               Works[1] = true;
               runstate = RunState.Test_Right;
                setMotorPower(0, 0);
                break;

            }

            case Test_Right: {

                setMotorPower(0, 0.5);
                Works[2] = true;
                runstate = RunState.Test_Right_Fast;
                setMotorPower(0, 0);
                break;

            }

            case Test_Right_Fast: {

               setMotorPower(0, 1);
               Works[3] = true;
               runstate = RunState.Test_Arm_Elbow;
               setMotorPower(0, 0);
               break;

            }

            case Test_Arm_Elbow: {

                setArmPivot(.5);
                Works[4] = true;
                runstate = RunState.Test_Tape_Measure;
                setArmPivot(0);
                break;

            }

            case Test_Tape_Measure: {

                moveTapeMeasure(.5);
                Works[5] = true;
                runstate = RunState.Test_Zipliner;
                moveTapeMeasure(0);
                break;

            }

            case Test_Zipliner: {

                setZipLinePosition(1);
                Works[6] = true;
                runstate = RunState.Test_End;
                setZipLinePosition(0);
                break;

            }

            case Test_End: {

                stop();
                break;

            }

        }

        telemetry.addData("Left Motors Slow Work: ", Works[0]);
        telemetry.addData("Left Motors Fast Work: ", Works[1]);
        telemetry.addData("Right Motors Slow Work: ", Works[2]);
        telemetry.addData("Right Motors Fast Work: ", Works[3]);
        telemetry.addData("Arm Works: ", Works[4]);
        telemetry.addData("Tape Measures Work", Works[5]);
        telemetry.addData("Zipliner Pusher Works: ", Works[6]);

        if (Works[0] && Works[1] && Works[2] && Works[3] && Works[4] && Works[5] && Works[6]) {

            telemetry.addData("Everything Works: ", true);

        }

    }



}


