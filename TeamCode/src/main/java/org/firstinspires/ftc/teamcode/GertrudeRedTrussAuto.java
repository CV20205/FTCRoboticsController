 package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.TimerTask;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="NessieRedTruss",group="linear Opmode")
public class GertrudeRedTrussAuto extends LinearOpMode {
private ElapsedTime runtime = new ElapsedTime();
    public DcMotor fL = null;
    public DcMotor fR = null;
    public DcMotor bL = null;
    public DcMotor bR = null;
    public DcMotor hando = null;
    public DcMotor susp = null;
    private Servo drone = null;
    private Servo rotate = null;
    private Servo clawi = null;

   
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        fL  = hardwareMap.get(DcMotor.class, "fL");
        fR = hardwareMap.get(DcMotor.class, "fR");
        bL  = hardwareMap.get(DcMotor.class, "bL");
        bR = hardwareMap.get(DcMotor.class, "bR");
        //susp = hardwareMap.get(DcMotor.class, "susp");//suspention aka hang on the bars 
        //drone =hardwareMap.get(Servo.class, "drone");
      
        //fL.setDirection(DcMotor.Direction.REVERSE);
        bL.setDirection(DcMotor.Direction.REVERSE);
        //fR.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.REVERSE);
        //susp.setDirection(DcMotor.Direction.REVERSE);//SUSPENTION 
        waitForStart();
        runtime.reset();
   while(opModeIsActive() && runtime.seconds() < 20){
   }
    runtime.reset();
        while(opModeIsActive() && runtime.seconds() < .2){
            fL.setPower(.5);
            fR.setPower(-.5);
            bR.setPower(.5);
            bL.setPower(-.5);
        }
        while(opModeIsActive() && runtime.seconds() < 7){
            fL.setPower(.5);
            fR.setPower(.5);
            bR.setPower(.5);
            bL.setPower(.5);
        }
    }
}
