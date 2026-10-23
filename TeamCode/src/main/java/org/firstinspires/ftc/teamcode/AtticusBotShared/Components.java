package org.firstinspires.ftc.teamcode.AtticusBotShared;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/// Components is a singleton, its fields are all the components (servos, motors, limelight) the bot uses

public class Components {
    // singleton variables
    private static Components single_instance = null;

    private Components(LinearOpMode providedOp) {
        op = providedOp;
    }

    final private LinearOpMode op;


    // COMPONENTS //

    // limelight
//    public Limelight3A limelight = null;

    // drivetrain components
    public DcMotor leftFrontDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightBackDrive = null;


    /// Call initComponents before indexing any of the fields of the Components class
    public void initComponents() {
        // component init
        leftFrontDrive = op.hardwareMap.get(DcMotor.class, "frontLeft");
        rightFrontDrive = op.hardwareMap.get(DcMotor.class, "frontRight");
        leftBackDrive = op.hardwareMap.get(DcMotor.class, "backLeft");
        rightBackDrive = op.hardwareMap.get(DcMotor.class, "backRight");

//        limelight = op.hardwareMap.get(Limelight3A.class, "limelight");

        // configurations
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);

        op.telemetry.addData("Components", "initialized");
    }

    /// De-init components when bot is turned off
    public void deInitComponents()
    {
//        limelight.stop();
    }


    /// Returns the components singleton
    public static synchronized Components getInstance(LinearOpMode providedOp)
    {
        if (single_instance == null) {
            if (providedOp == null) {
                throw new java.lang.Error("Tried to getInstance before LinearOpMode was provided");
            }

            single_instance = new Components(providedOp);
        }

        return single_instance;
    }
}
