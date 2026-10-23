package org.firstinspires.ftc.teamcode.AtticusBotShared;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

/// interface for the physical controller used for teleop

public class PhysicalGamepad {
    // singleton variables
    private static PhysicalGamepad single_instance = null;
    private PhysicalGamepad(LinearOpMode providedOp) {
        op = providedOp;
        gamepad = op.gamepad1;
    }
    final private LinearOpMode op;
    final public Gamepad gamepad;



    public DrivetrainController.MoveDirection getMoveDirection()
    {
        return new DrivetrainController.MoveDirection(
            gamepad.left_stick_x,
            gamepad.left_stick_y,
            gamepad.right_stick_x
        );
    }




    /// Returns the PhysicalController singleton
    public static synchronized PhysicalGamepad getInstance(LinearOpMode providedOp)
    {
        if (single_instance == null) {
            if (providedOp == null) {
                throw new java.lang.Error("Tried to getInstance before LinearOpMode was provided");
            }

            single_instance = new PhysicalGamepad(providedOp);
        }

        return single_instance;
    }

}
