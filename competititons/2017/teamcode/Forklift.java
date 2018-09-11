package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class Forklift {
    public DcMotor forkLiftDrive;
    // public TouchSense stop;

    public void Forklift()
    {
        forkLiftDrive = null;
        // stop = null;
    }

    
    public void initLift(OpMode robot){
                
        forkLiftDrive = robot.hardwareMap.get(DcMotor.class, "forkLift");
        // stop = new TouchSense();
        // stop.initTouch(robot);
    }
    
    public void moveLift(OpMode robot){
        
        double forkLiftPower = 0;
        forkLiftPower = -(robot.gamepad2.left_stick_y);
        
        forkLiftDrive.setPower(forkLiftPower / 1.25);
        
        /*
        if(stop.sampleTouchSensor(robot) || (forkLiftPower < 0))
        {
        }
        else{
            forkLiftDrive.setPower(0);
        }
        
        */ 
        
        robot.telemetry.addData("Forklift Power: ", forkLiftPower);
        robot.telemetry.update();

    }        
      
    
}
