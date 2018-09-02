/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
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

package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import android.graphics.Color;
import android.view.View;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class digitalSensor {
  
  /** The colorSensor field will contain a reference to our color sensor hardware object */
  NormalizedColorSensor colorSensor;
  
  /** The relativeLayout field is used to aid in providing interesting visual feedback
   * in this sample application; you probably *don't* need something analogous when you
   * use a color sensor on your robot */
  View relativeLayout;
  int relativeLayoutId;
  
  public void digitalSensor()
  {
    colorSensor = null;
    relativeLayout = null;
    relativeLayoutId = 0;
  }

  public void initDigitalSensor(OpMode robot){

    colorSensor = robot.hardwareMap.get(NormalizedColorSensor.class, "sensor_color");
    
    // If possible, turn the light on in the beginning (it might already be on anyway,
    // we just make sure it is if we can).
    if (colorSensor instanceof SwitchableLight) {
      ((SwitchableLight)colorSensor).enableLight(true);
    }
  }
  
  public void getColor(OpMode robot){
    // values is a reference to the hsvValues array.
    float[] hsvValues = new float[3];
    final float values[] = hsvValues;

    // bPrevState and bCurrState keep track of the previous and current state of the button
    boolean bPrevState = false;
    boolean bCurrState = false;

    bCurrState = robot.gamepad1.x;

      // If the button state is different than what it was, then act
      if (bCurrState != bPrevState) {
        // If the button is (now) down, then toggle the light
        if (bCurrState) {
          if (colorSensor instanceof SwitchableLight) {
            SwitchableLight light = (SwitchableLight)colorSensor;
            light.enableLight(!light.isLightOn());
          }
        }
      }
      bPrevState = bCurrState;

      // Read the sensor
      NormalizedRGBA colors = colorSensor.getNormalizedColors();

      /** Use telemetry to display feedback on the driver station. We show the conversion
       * of the colors to hue, saturation and value, and display the the normalized values
       * as returned from the sensor.
       * @see <a href="http://infohost.nmt.edu/tcc/help/pubs/colortheory/web/hsv.html">HSV</a>*/

      Color.colorToHSV(colors.toColor(), hsvValues);
      robot.telemetry.addLine()
              .addData("H", "%.3f", hsvValues[0])
              .addData("S", "%.3f", hsvValues[1])
              .addData("V", "%.3f", hsvValues[2]);
      robot.telemetry.addLine()
              .addData("a", "%.3f", colors.alpha)
              .addData("r", "%.3f", colors.red)
              .addData("g", "%.3f", colors.green)
              .addData("b", "%.3f", colors.blue);

      /** We also display a conversion of the colors to an equivalent Android color integer.
       * @see Color */
      int color = colors.toColor();
      robot.telemetry.addLine("raw Android color: ")
              .addData("a", "%02x", Color.alpha(color))
              .addData("r", "%02x", Color.red(color))
              .addData("g", "%02x", Color.green(color))
              .addData("b", "%02x", Color.blue(color));

      // Balance the colors. The values returned by getColors() are normalized relative to the
      // maximum possible values that the sensor can measure. For example, a sensor might in a
      // particular configuration be able to internally measure color intensity in a range of
      // [0, 10240]. In such a case, the values returned by getColors() will be divided by 10240
      // so as to return a value it the range [0,1]. However, and this is the point, even so, the
      // values we see here may not get close to 1.0 in, e.g., low light conditions where the
      // sensor measurements don't approach their maximum limit. In such situations, the *relative*
      // intensities of the colors are likely what is most interesting. Here, for example, we boost
      // the signal on the colors while maintaining their relative balance so as to give more
      // vibrant visual feedback on the robot controller visual display.
      float max = Math.max(Math.max(Math.max(colors.red, colors.green), colors.blue), colors.alpha);
      colors.red   /= max;
      colors.green /= max;
      colors.blue  /= max;
      color = colors.toColor();

      robot.telemetry.addLine("normalized color:  ")
              .addData("a", "%02x", Color.alpha(color))
              .addData("r", "%02x", Color.red(color))
              .addData("g", "%02x", Color.green(color))
              .addData("b", "%02x", Color.blue(color));
      robot.telemetry.update();

      // convert the RGB values to HSV values.
      Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), hsvValues);

      // change the background color to match the color detected by the RGB sensor.
      // pass a reference to the hue, saturation, and value array as an argument
      // to the HSVToColor method.
      
  }
}
