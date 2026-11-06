// Functionality for gamepad buttons

package org.firstinspires.ftc.teamcode.AtticusBotTeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

public class PhysicalGamepadButtons {
    // singleton variables
    private static PhysicalGamepadButtons single_instance = null;
    private PhysicalGamepadButtons(LinearOpMode providedOp) {
        op = providedOp;
        physicalGamepad = PhysicalGamepad.getInstance(op);
        gamepad = physicalGamepad.gamepad;
    }
    final private LinearOpMode op;
    final private PhysicalGamepad physicalGamepad;
    final public Gamepad gamepad;





    public void rotateTowardsAprilTag()
    {

    }

    /// Function called every "frame" of the robot loop
    public void onFrame()
    {
        if (gamepad.a) {
            rotateTowardsCenterOfApriltag();
        }

        // not done anything with yet
    }




    /// Returns the PhysicalControllerButtons singleton
    public static synchronized PhysicalGamepadButtons getInstance(LinearOpMode providedOp)
    {
        if (single_instance == null) {
            if (providedOp == null) {
                throw new java.lang.Error("Tried to getInstance before LinearOpMode was provided");
            }

            single_instance = new PhysicalGamepadButtons(providedOp);
        }

        return single_instance;
    }

}
