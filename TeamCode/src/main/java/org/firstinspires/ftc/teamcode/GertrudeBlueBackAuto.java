package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import java.util.TimerTask;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous

public class GertrudeBlueBackAuto extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    public DcMotor fL = null;
    public DcMotor fR = null;
    public DcMotor bL = null;
    public DcMotor bR = null;
    public DcMotor hando = null;
    public DcMotor susp = null;
   private Servo drone = null;
   private Servo clawi = null;
   public CRServo rotate = null;
   @Override
   public void runOpMode(){
    fL  = hardwareMap.get(DcMotor.class, "fL");
        fR = hardwareMap.get(DcMotor.class, "fR");
        bL  = hardwareMap.get(DcMotor.class, "bL");
        bR = hardwareMap.get(DcMotor.class, "bR");
        susp = hardwareMap.get(DcMotor.class, "susp");//suspention aka hang on the bars 
       drone =hardwareMap.get(Servo.class, "drone");
       hando = hardwareMap.get(DcMotor.class, "hando");
      clawi = hardwareMap.get(Servo.class, "clawi");
      rotate  = hardwareMap.get(CRServo.class, "rotate");
   
      fL.setDirection(DcMotor.Direction.REVERSE);
        bL.setDirection(DcMotor.Direction.REVERSE);
        fR.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.REVERSE);
        susp.setDirection(DcMotor.Direction.REVERSE);//SUSPENTION 
        hando.setDirection(DcMotor.Direction.REVERSE);
       waitForStart();
       runtime.reset();
       while(opModeIsActive() && runtime.seconds() < 0.155){
        clawi.setPosition(1.0);
           fR.setPower(.5);//+
           fL.setPower(-.5);//-
           bR.setPower(-.5);//-
           bL.setPower(.5);//+
       }
        runtime.reset();
       while(opModeIsActive() && runtime.seconds() < 0.38){
        clawi.setPosition(1.0);
           fR.setPower(-.5);//+
           fL.setPower(-.5);//+
           bR.setPower(-.5);//+
           bL.setPower(-.5);//+
       }
       runtime.reset();
       while (opModeIsActive() && runtime.seconds() < 0.5)
       {
        rotate.setPower(0.25);
       }
        clawi.setPosition(0.88);
        sleep(500);
         runtime.reset();
         while(opModeIsActive() && runtime.seconds() < 0.13){
           fR.setPower(.5);//-
           fL.setPower(.5);//-
           bR.setPower(.5);//-
           bL.setPower(.5);//-
        }
   }
}
