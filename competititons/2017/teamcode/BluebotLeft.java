package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

@Autonomous(name="Bluebot Left Arm")

public class BluebotLeft extends OpMode {
    
    
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    MecamWheels wheels = new MecamWheels();
    JewelSensor leftColor = new JewelSensor();
    // JewelSensor rightColor = new JewelSensor();
    Forklift Lift = new Forklift();
    Grabber glyphGrabber = new Grabber();
    String jewelColor = null;
    String targetColor = null;
    JewelArm armL = new JewelArm();
    // JewelArm armR = new JewelArm();
    String color = null;
    boolean gettingJewel = true;
    
    /*
     * Code to run ONCE when the driver hits INIT
     */
    public void init() {
        wheels.initWheels(this);
        telemetry.addData("Wheels", "Initialized");
        leftColor.initSensor(this);
        // rightColor.initSensor(this);
        telemetry.addData("Color Sensor", "Initialized");
        Lift.initLift(this);
        telemetry.addData("Forklift", "Initialized");
        glyphGrabber.initGrabber(this);
        telemetry.addData("Grabber", "Initialized");
        
        // init to raise jewel arm (R & L)
        armL.initJewelArm(this, "left");
        // armR.initJewelArm(this, "right");
        armL.moveJewelArmAuto(this, "left", "up");
        // armR.moveJewelArmAuto(this, "right", "up");
        telemetry.addData("Jewel Arm", "Initialized");
        telemetry.update();
        
        getJewel();
    }
    public void getJewel(){
        
    }
    
    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }
    
     /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        
    // drop left arm
    if(gettingJewel){
    armL.moveJewelArmAuto(this, "left", "down");
    
    color = leftColor.GetColor(this);

    double leftJewelForward = .01;
    double leftSafeMove = .02;
    
    // if blue drive backwar
    if (color == "blue") {
        wheels.moveBot(this, "backward", leftJewelForward);
        armL.moveJewelArmAuto(this, "left", "up");
        wheels.moveBot(this, "forward", leftSafeMove + (2 * leftJewelForward));
        gettingJewel = false;
    
    } else {
        wheels.moveBot(this, "forward", leftJewelForward);
        armL.moveJewelArmAuto(this, "left", "up");
        wheels.moveBot(this, "forward", leftSafeMove);
        gettingJewel = false;
    }
     /*}while(true){
        
        wheels.moveBot(this, "stop", 0);
    */}
    
    // turn the Robot
    //wheels.turnBot(this, "counter", .5);

    // place the glyph
    //wheels.moveBot(this, "forward", .5);
    
    
    // open pincher
    //glyphGrabber.openPincher(this);
    
    // back up
    //wheels.moveBot(this, "back", .25);
    
    //gettingJewel = false;
        
    }
    
    /*
     * Code to run ONCE after the driver hits STOP
     */
     
    @Override
    public void stop(){
        
    }
    
}
