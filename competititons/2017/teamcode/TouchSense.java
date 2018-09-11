/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
/***********************************************

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class TouchSense {
    /**
     * The REV Robotics Touch Sensor
     * is treated as a digital channel.  It is HIGH if the button is unpressed.
     * It pulls LOW if the button is pressed.
     *
     * Also, when you connect a REV Robotics Touch Sensor to the digital I/O port on the
     * Expansion Hub using a 4-wire JST cable, the second pin gets connected to the Touch Sensor.
     * The lower (first) pin stays unconnected.*
     */
    
    /*

    DigitalChannel digitalTouch;  // Hardware Device Object
    
    public void TouchSense() {
        digitalTouch = null;
    }
    
    public void initTouch(OpMode robot){
        
        // get the device
        digitalTouch = robot.hardwareMap.get(DigitalChannel.class, "sensor_touch");
        
        // set the digital channel to input.
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        
    }
    
    public boolean sampleTouchSensor(OpMode robot) {
    // send the info back to driver station using telemetry function.
    // if the digital channel returns true it's HIGH and the button is unpressed.
        
        boolean state = digitalTouch.getState();
        
        String stateStr = "False";
        
        if(state){
            stateStr = "True";
        }
        
        robot.telemetry.addData("Touch Sensor Status: ", stateStr);
        robot.telemetry.update();
        
        return state;
    }
}
    
***********************************************/
