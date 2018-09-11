package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


public class MecamWheels {
    

    public DcMotor rearleftDrive;
    public DcMotor frontleftDrive;
    public DcMotor frontrightDrive;
    public DcMotor rearrightDrive;
    
    public void MecamWheels()
    {
        rearleftDrive = null;
        frontleftDrive = null;
        frontrightDrive = null;
        rearrightDrive = null;
    }

    
    public void initWheels(OpMode robot){
                
        frontleftDrive  = robot.hardwareMap.get(DcMotor.class, "frontLeft");
        rearleftDrive = robot.hardwareMap.get(DcMotor.class, "rearLeft");
        frontrightDrive = robot.hardwareMap.get(DcMotor.class, "frontRight");
        rearrightDrive = robot.hardwareMap.get(DcMotor.class, "rearRight");
        frontleftDrive.setDirection(DcMotor.Direction.FORWARD);
        rearleftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontrightDrive.setDirection(DcMotor.Direction.REVERSE);
        rearrightDrive.setDirection(DcMotor.Direction.REVERSE);
    }
    
    public void drive(OpMode robot){
        
        double forwardDrive = robot.gamepad1.left_stick_y;
        double lateralDrive = robot.gamepad1.left_stick_x;
        double turnDrive = robot.gamepad1.right_stick_x;
        
        //Gear code 
        double gear = 4.5;    // 1st Gear (default)
        double turnScale = .75; // Scale down the gearing on turn to make the robot turn more slowly
            
        if (robot.gamepad1.right_bumper)  // 2nd Gear
        {
            gear = 2.4;
        }
        
        else if (robot.gamepad1.left_bumper)  // 3rd Gear
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

        robot.telemetry.addData("Front Left Drive: ", frontleftPower);
        robot.telemetry.addData("Front right Drive:", frontrightPower);
        robot.telemetry.addData("Back left Drive", rearleftPower);
        robot.telemetry.addData("Back right Drive", rearrightPower);
        robot.telemetry.update();

    }   
    
    public void moveBot(OpMode robot, String direction, double time) {
        
        ElapsedTime eTime = new ElapsedTime();
        eTime.reset();
        
        while (eTime.time() < time) {
            if (direction == "forward") 
            {
                frontleftDrive.setPower(1);
                rearleftDrive.setPower(1);
                frontrightDrive.setPower(1);
                rearrightDrive.setPower(1);
        } else if (direction == "backward") {
            frontleftDrive.setPower(-1);
            rearleftDrive.setPower(-1);
            frontrightDrive.setPower(-1);            
            rearrightDrive.setPower(-1);
        } else {
            frontleftDrive.setPower(0);
            frontrightDrive.setPower(0);
            rearrightDrive.setPower(0);
            rearleftDrive.setPower(0);
        }
            
        }
    }
    
    public void turnBot(OpMode robot, String direction, double time)
    {
        
        ElapsedTime eTime = new ElapsedTime();
        eTime.reset();
        
        while (eTime.time() < time) {
            if (direction == "counter") 
            {
                frontleftDrive.setPower(-1);
                rearleftDrive.setPower(-1);
                frontrightDrive.setPower(1);
                rearrightDrive.setPower(1);
            } else {
                frontleftDrive.setPower(1);
                rearleftDrive.setPower(-1);
                frontrightDrive.setPower(1);
                rearrightDrive.setPower(-1);
            }
            
        }
        
    }
    
}
