package org.firstinspires.ftc.teamcode.AtticusBotShared;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

import java.util.concurrent.CompletableFuture;

public class LimelightController {
    // singleton variables
    private static LimelightController single_instance = null;
    private LimelightController(LinearOpMode providedOp) {
        op = providedOp;
        components = Components.getInstance(op);
        drivetrainController = DrivetrainController.getInstance(op);
        limelight = components.limelight;
    }
    final private LinearOpMode op;
    final private Components components;
    final private DrivetrainController drivetrainController;
    final private Limelight3A limelight;

    /// Retrieve the last LLResult of the robot, throws an error if you could not retrieve the result
    public LLResult retrieveResult()
    {
        LLResult result = limelight.getLatestResult();

        if (result == null || !result.isValid()) {
            throw new java.lang.Error("Failed to retrieve result");
        }

        return result;
    }



    /// Function called every "frame" of the robot loop
    public void onFrame()
    {
        // not done anything with yet
    }

    /// Yields, and returns false if you could not find an AprilTag, or it just fails
    public CompletableFuture<Boolean> rotateTowardsAprilTag()
    {
        return CompletableFuture.supplyAsync(() -> {
            LLResult result = retrieveResult();
            // how to detect if robot did not see the apriltag?

            return true;
        });
    }








    /// Returns the components singleton
    public static synchronized LimelightController getInstance(LinearOpMode providedOp)
    {
        if (single_instance == null) {
            if (providedOp == null) {
                throw new java.lang.Error("Tried to getInstance before LinearOpMode was provided");
            }

            single_instance = new LimelightController(providedOp);
        }

        return single_instance;
    }
}
