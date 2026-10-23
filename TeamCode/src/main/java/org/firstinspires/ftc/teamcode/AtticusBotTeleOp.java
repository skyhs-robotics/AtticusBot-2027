package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.AtticusBotShared.Components;
import org.firstinspires.ftc.teamcode.AtticusBotShared.DrivetrainController;
import org.firstinspires.ftc.teamcode.AtticusBotShared.PhysicalGamepad;


@TeleOp(name = "AtticusBot Teleop")
public class AtticusBotTeleOp extends LinearOpMode {
    // SHARED CLASSES
    final private Components components = Components.getInstance(this);
    final private PhysicalGamepad physicalGamepad = PhysicalGamepad.getInstance(this);
    final private DrivetrainController drivetrainController = DrivetrainController.getInstance(this);

    @Override
    public void runOpMode()
    {
        components.initComponents();

        waitForStart(); // wait for start button to be pressed

        while (opModeIsActive()) {
            drivetrainController.drive(physicalGamepad.getMoveDirection());

            telemetry.update();
            sleep(10);
        }

        // de-init
        components.deInitComponents();
    }
}
