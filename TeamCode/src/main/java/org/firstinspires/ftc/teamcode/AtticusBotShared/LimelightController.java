package org.firstinspires.ftc.teamcode.AtticusBotShared;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class LimelightController {
    // singleton variables
    private static LimelightController single_instance = null;
    private LimelightController(LinearOpMode providedOp) {
        op = providedOp;
        components = Components.getInstance(op);
        limelight = components.limelight;
    }
    final private LinearOpMode op;
    final private Components components;
    final private Limelight3A limelight;

    /// Retrieve the last LLResult of the robot, throws an error if could not retrieve the result
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
