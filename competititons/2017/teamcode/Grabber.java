package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class Grabber {
    public DcMotor pincherMotor;
    
    public void Grabber()
    {
        pincherMotor = null;
    }
    
    public void initGrabber(OpMode robot){
        pincherMotor = robot.hardwareMap.get(DcMotor.class, "pincher");
    }
    
    public void Grab(OpMode robot){
        
        double pincherPower = -robot.gamepad2.right_stick_x;
             
        pincherMotor.setPower(pincherPower);
        
        robot.telemetry.addData("Pincher Power: ", pincherPower);
        robot.telemetry.update();
     
    }
    
    public void openPincher(OpMode robot){
        pincherMotor.setPower(-1);
    }
}
