package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AtticusBotShared.Components;
import org.firstinspires.ftc.teamcode.AtticusBotShared.LimelightController;

@Autonomous(name = "AtticusBot Autonomous")
public class BotAuto extends LinearOpMode {
    // SHARED CLASSES
    final private Components components = Components.getInstance(this);
    final private LimelightController limelightController = LimelightController.getInstance(this);

    @Override
    public void runOpMode()
    {
        components.initComponents();

        waitForStart();

        while (opModeIsActive()) {
            limelightController.onFrame();

            telemetry.update();
            sleep(10);
        }

        // de init
        components.deInitComponents();
    }

}
