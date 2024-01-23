package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvWebcam;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
//import org.openftc.easyopencv.WebcamName;

@Autonomous
public class GertrudeCameraBlueBack extends LinearOpMode {

    private ElapsedTime eTime = new ElapsedTime();
    private DcMotor flDrive = null;
    private DcMotor frDrive = null;
    private DcMotor brDrive = null;
    private DcMotor blDrive = null;
    private DcMotor arm = null;
    private Servo leftServo = null;
    private Servo rotateServo = null;
    private OpenCvWebcam webcam;
    //private CameraBlueDetermineObjectPosition pipeline;

    @Override
    public void runOpMode() {

        flDrive = hardwareMap.get(DcMotor.class, "flDrive");
        frDrive = hardwareMap.get(DcMotor.class, "frDrive");
        blDrive = hardwareMap.get(DcMotor.class, "blDrive");
        brDrive = hardwareMap.get(DcMotor.class, "brDrive");
        arm = hardwareMap.get(DcMotor.class, "arm");
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rotateServo = hardwareMap.get(Servo.class, "rotateServo");

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setTargetPosition(0);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        blDrive.setDirection(DcMotor.Direction.REVERSE);
        brDrive.setDirection(DcMotor.Direction.FORWARD);
        flDrive.setDirection(DcMotor.Direction.REVERSE);
        frDrive.setDirection(DcMotor.Direction.FORWARD);

        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Initialize camera and pipeline
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        //  webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        // pipeline = new CameraBlueDetermineObjectPosition();
        //webcam.setPipeline(pipeline);

        // Start camera streaming
        webcam.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);

        // Wait for the start button to be pressed
        waitForStart();

        // Main autonomous logic
        while (opModeIsActive()) {
            // Access the analysis result from the pipeline
           /* CameraBlueDetermineObjectPosition.TeamElementPosition elementPosition = pipeline.getAnalysis();

            // Implement autonomous logic based on the analysis result
            // For example:
            if (elementPosition == CameraBlueDetermineObjectPosition.TeamElementPosition.LEFT) {
                // Move the robot based on the left element position
                moveRobotLeft();
            } else if (elementPosition == CameraBlueDetermineObjectPosition.TeamElementPosition.CENTER) {
                // Move the robot based on the center element position
                moveRobotCenter();
            } else if (elementPosition == CameraBlueDetermineObjectPosition.TeamElementPosition.RIGHT) {
                // Move the robot based on the right element position
                moveRobotRight();
            }
*/
            // Update telemetry or perform other tasks
            telemetry.addData("Status", "Running");
            telemetry.update();

            // Sleep to give the robot some time to process and act
            sleep(100);
        }
    }

    // Example method: Move the robot left
    private void moveRobotLeft() {
        // Implement logic to move the robot left
        // For example:
        flDrive.setPower(-0.5);
        frDrive.setPower(0.5);
        blDrive.setPower(-0.5);
        brDrive.setPower(0.5);
    }

    // Example method: Move the robot center
    private void moveRobotCenter() {
        while(opModeIsActive() && eTime.seconds() < 2.37){
            flDrive.setPower(0.3);
            frDrive.setPower(0.3);
            blDrive.setPower(0.3);
            brDrive.setPower(0.3);
        }
        eTime.reset();

    }

    // Example method: Move the robot right
    private void moveRobotRight() {
        // Implement  logic to move the robot right
        // For example:
        flDrive.setPower(0.5);
        frDrive.setPower(-0.5);
        blDrive.setPower(0.5);
        brDrive.setPower(-0.5);
    }
}

