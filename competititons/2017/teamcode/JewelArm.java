package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class JewelArm {
    
    public Servo armL = null;
    public Servo armR = null;
    public Servo jewelArm = null;
    double upL = -.1;
    double downL = .6;
    double upR = .6;
    double downR = -.1;
    
    public double Position = 0;
    
    public void JewelArm() {
    }
    
    public void initJewelArm(OpMode robot, String side)
    {
        if (side == "left") {
            armL = robot.hardwareMap.get(Servo.class, "jewelArmL");
        } else {
            armR = robot.hardwareMap.get(Servo.class, "jewelArmR");
        }
    }
    
    
    public void moveJewelArm(OpMode robot){
    /***************************************
    *      JEWEL ARM
    ***************************************/
    double ArmPosition = 0;
    
    if (robot.gamepad2.y){
        ArmPosition = upL;
        armL.setPosition(ArmPosition);
    } else if (robot.gamepad2.a){
        ArmPosition = downL;
        armL.setPosition(ArmPosition);
    }
    
    if (robot.gamepad2.y){
        ArmPosition = upR;
        armL.setPosition(ArmPosition);
    } else if (robot.gamepad2.a){
        ArmPosition = downR;
        armL.setPosition(ArmPosition);
    }

    robot.telemetry.addData("Jewel Arm Position: ", ArmPosition);
    robot.telemetry.update();

    }
    
    public void moveJewelArmAuto(OpMode robot, String side, String pos){
    /***************************************
    *      JEWEL ARM
    ***************************************/
    String armPosition = pos;
    String armSide = side;
    
    /*
    Servo curArm = null;
    
    if(armSide == "left"){
        curArm = armL;
    }else{
        curArm = armR;
    }
    
    if(armPosition == "up"){
        curArm.setPosition(up);
    }else{
        curArm.setPosition(down);
    }
    */

    if(armSide == "left") {
        
        if(armPosition == "up")
        {
            armL.setPosition(upL);
        } else if(armPosition == "down") {
            armL.setPosition(downL);
        }
    } else if (armSide == "right") {
        if(armPosition == "up")
        {
            armR.setPosition(upR);
        } else if(armPosition == "down") {
            armR.setPosition(downR);
        }
    }

    
    robot.telemetry.addData("Jewel Arm Position: ", armPosition);
    robot.telemetry.update();
        
    }
    
    /*
    public void raiseArm(OpMode robot){
        jewelArm.setPosition(up);
    }
    
    public void lowerArm(){
        jewelArm.setPosition(down);
    }
    */
    
}
