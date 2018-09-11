package org.firstinspires.ftc.testcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="TEST: Jason", group="Linear Opmode")

public class JasonTest extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor rearleftDrive = null;
    private DcMotor frontleftDrive = null;
    private DcMotor frontrightDrive = null;
    private DcMotor rearrightDrive = null;
    private DcMotor forkLiftDrive = null; 
    private DcMotor pincherDrive = null;
    private DcMotor leftPinchDrive = null;
    private DcMotor rightPinchDrive = null;
    private Servo jewelArm = null; 

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        frontleftDrive  = hardwareMap.get(DcMotor.class, "frontLeft");
        rearleftDrive = hardwareMap.get(DcMotor.class, "rearLeft");
        frontrightDrive = hardwareMap.get(DcMotor.class, "frontRight");
        rearrightDrive = hardwareMap.get(DcMotor.class, "rearRight");
        forkLiftDrive = hardwareMap.get(DcMotor.class, "forkLift");
        pincherDrive = hardwareMap.get(DcMotor.class, "pincher");
        leftPinchDrive = hardwareMap.get(DcMotor.class, "leftPinch"); 
        rightPinchDrive = hardwareMap.get(DcMotor.class, "rightPinch");
        jewelArm = hardwareMap.get(Servo.class, "jewelArm");
        
        //jewelArm.setPosition(.5);

        frontleftDrive.setDirection(DcMotor.Direction.FORWARD);
        rearleftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontrightDrive.setDirection(DcMotor.Direction.REVERSE);
        rearrightDrive.setDirection(DcMotor.Direction.REVERSE);

        leftPinchDrive.setDirection(DcMotor.Direction.REVERSE); 
        rightPinchDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            /***************************************
                    DRIVE
             ***********m****************************/        

            double forwardDrive = gamepad1.left_stick_y;
            double lateralDrive = gamepad1.left_stick_x;
            double turnDrive = gamepad1.right_stick_x;
            
            //Gear code 
            double gear = 4.5;    // 1st Gear (default)
            double turnScale = .75; // Scale down the gearing on turn to make the robot turn more slowly
            
            if (gamepad1.right_bumper)  // 2nd Gear
            {
                gear = 2.4;
            }
            else if (gamepad1.left_bumper)  // 3rd Gear
            {
                gear = 1.2;
            } 
            
            double frontleftPower = Range.clip(forwardDrive - (turnDrive * turnScale) - lateralDrive, -1.0, 1.0) / gear;
            double rearleftPower = Range.clip(forwardDrive - (turnDrive * turnScale) + lateralDrive, -1.0, 1.0) / gear;
            double frontrightPower = Range.clip(forwardDrive + (turnDrive * turnScale) + lateralDrive, -1.0, 1.0) / gear;
            double rearrightPower = Range.clip(forwardDrive + (turnDrive * turnScale) - lateralDrive, -1.0, 1.0) / gear;
            
            frontleftDrive.setPower(frontleftPower);
            rearleftDrive.setPower(rearleftPower);
            frontrightDrive.setPower(frontrightPower);
            rearrightDrive.setPower(rearrightPower);
            
            /***************************************
             *      FORKLIFT
             * *************************************/
             
            double forkDirection = gamepad2.left_stick_y;
            
            forkLiftDrive.setPower(forkDirection); 
//            forkLiftDrive.setPower(0);
             
            /***************************************
             *      Pincher
             * *************************************/
             
             double pincherDirection = gamepad2.right_stick_x;
             
             pincherDrive.setPower(pincherDirection / 1.5);
             
             /**************************************
              *     PINCHER WHEELS
              * ************************************/
             
            double leftPinchDirection = 0; 
            double rightPinchDirection = 0;

             float leftTrigger = gamepad2.left_trigger;
             float rightTrigger = gamepad2.right_trigger;
             
             if (leftTrigger > 0)
             {
                 leftPinchDirection = .5;
                 rightPinchDirection = .5;
             }
             
             if (rightTrigger > 0)
             {
                 leftPinchDirection = -.5;
                 rightPinchDirection = -.5;
             }
             
             leftPinchDrive.setPower(leftPinchDirection);  
             rightPinchDrive.setPower(rightPinchDirection);
        }
    }
}
