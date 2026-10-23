package org.firstinspires.ftc.teamcode.AtticusBotShared;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class DrivetrainController {
    // singleton variables
    private static DrivetrainController single_instance = null;
    private DrivetrainController(LinearOpMode providedOp) {
        op = providedOp;
        components = Components.getInstance(providedOp);
    }
    final private LinearOpMode op;
    final private Components components;





    // FUNCTIONS

    /// Set the motors power with direction
    public void drive(double lsx, double lsy, double rsx)
    {
        // movement
        components.leftFrontDrive.setPower(lsy - lsx - rsx);
        components.leftBackDrive.setPower(lsy + lsx - rsx);
        components.rightFrontDrive.setPower(lsy + lsx + rsx);
        components.rightBackDrive.setPower(lsy - lsx + rsx);
    }

    /// Set the motors power with direction and a specified speed multiplier
    public void drive(double lsx, double lsy, double rsx, double speedMulti)
    { drive(lsx*speedMulti, lsy*speedMulti, rsx*speedMulti); }

    /// Set the drive motors power with MoveDirection
    public void drive(MoveDirection direction)
    { drive(direction.lsx, direction.lsy, direction.rsx); }

    /// Set the drive motors power with MoveDirection and a specified speed multiplier
    public void drive(MoveDirection direction, double speedMulti)
    { drive(direction.lsx*speedMulti, direction.lsy*speedMulti, direction.rsx*speedMulti); }



    /// Returns the DrivetrainController singleton
    public static synchronized DrivetrainController getInstance(LinearOpMode providedOp)
    {
        if (single_instance == null) {
            if (providedOp == null) {
                throw new java.lang.Error("Tried to getInstance before LinearOpMode was provided");
            }

            single_instance = new DrivetrainController(providedOp);
        }

        return single_instance;
    }

    public static class MoveDirection {
        double lsx;
        double lsy;
        double rsx;

        public MoveDirection(double lsxA, double lsyA, double rsxA)
        {
            lsx = lsxA;
            lsy = lsyA;
            rsx = rsxA;
        }
    }
}
