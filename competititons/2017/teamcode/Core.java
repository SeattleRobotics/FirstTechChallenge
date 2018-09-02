package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

@TeleOp(name="Core", group="Iterative OpMode")

public class Core extends OpMode
{

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    MecamWheels wheels = new MecamWheels();
    // digitalSensor color = new digitalSensor();
    Forklift Lift = new Forklift();
    Grabber glyphGrabber = new Grabber();
    JewelArm arm = new JewelArm();
    
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        wheels.initWheels(this);
        telemetry.addData("Wheels", "Initialized");
        // color.initDigitalSensor(this);
        // telemetry.addData("Color Sensor", "Initialized");
        Lift.initLift(this);
        telemetry.addData("Forklift", "Initialized");
        glyphGrabber.initGrabber(this);
        arm.initJewelArm(this, "left");
        arm.moveJewelArm(this);
        telemetry.addData("Grabber", "Initialized");
        telemetry.addData("Jewel Arm", "Initialized");
        
        
        telemetry.update(); 
        
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
        telemetry.addData("Status", "Running: " + runtime.toString());

        wheels.drive(this);
        // color.getColor(this);
        Lift.moveLift(this);
        glyphGrabber.Grab(this);
        arm.moveJewelArm(this);
        
        telemetry.update(); 

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}



    

    

    

    
