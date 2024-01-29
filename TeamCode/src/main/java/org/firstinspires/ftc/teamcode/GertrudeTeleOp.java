package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import java.util.TimerTask;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name="GertrudeTeleOp",group="linear Opmode")
public class GertrudeTeleOp extends LinearOpMode {

private ElapsedTime runtime = new ElapsedTime();
    public DcMotor fL = null;
    public DcMotor fR = null;
    public DcMotor bL = null;
    public DcMotor bR = null;
    public DcMotor hando = null;
   // public DcMotor susp = null;
   private Servo drone = null;
   private Servo clawi = null;
   public CRServo rotate = null;
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
       drone =hardwareMap.get(Servo.class, "drone");
       hando = hardwareMap.get(DcMotor.class, "hando");
      clawi = hardwareMap.get(Servo.class, "clawi");
      rotate  = hardwareMap.get(CRServo.class, "rotate");
      
      
        fL.setDirection(DcMotor.Direction.REVERSE);
        bL.setDirection(DcMotor.Direction.REVERSE);
        fR.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.REVERSE);
       // susp.setDirection(DcMotor.Direction.REVERSE);//SUSPENTION 
        hando.setDirection(DcMotor.Direction.REVERSE);
        
        
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Setup a variable for each drive wheel to save power level for telemetry
            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.
            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x * 0.5;
            double strafe = gamepad1.left_stick_x;
            boolean strafeL = gamepad1.x;
            boolean strafeR = gamepad1.y;
          double LY2 = gamepad2.left_stick_y;
           // boolean RB = gamepad2.right_bumper;
            //boolean LB = gamepad2.left_bumper;
          
            
            
           //*/ up to here 

            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
            // leftPower  = -gamepad1.left_stick_y ;
            // rightPower = -gamepad1.right_stick_y ;

            // Send calculated power to wheels
            double frontleftPower = 0.85 * Range.clip(drive  - turn - strafe, -0.50, 0.50);//front left
            double frontrightPower = 1.0 * Range.clip(drive + turn + strafe, -0.50, 0.50);//front right
            double backleftPower = 0.90 * Range.clip(drive - turn + strafe, -0.50, 0.50);//back left
            double backrightPower = 1.0 * Range.clip(drive + turn - strafe, -0.50, 0.50);//back right
         /*
         if (gamepad1.dpad_right) {
             fL.setPower(1);
             bL.setPower(0);
             fR.setPower(0);
             bR.setPower(1);
         }
         
         if (gamepad1.dpad_left) {
             fL.setPower(0);
             bL.setPower(1);
             fR.setPower(1);
             bR.setPower(0);
         }
         
         if (gamepad1.dpad_up) {
             fL.setPower(-1);
             bL.setPower(0);
             fR.setPower(0);
             bR.setPower(-1);
         }
         
         if (gamepad1.dpad_down) {
             fL.setPower(0);
             bL.setPower(-1);
             fR.setPower(-1);
             bR.setPower(0);
         }
         */
            fL.setPower(frontleftPower);
            bL.setPower(backleftPower);
            fR.setPower(frontrightPower);
            bR.setPower(backrightPower);
            
            //suspention 
           /*
            if (gamepad1.x) {
                susp.setPower(1);
            } else if (gamepad1.y){
                susp.setPower(-1);
            } else {
                susp.setPower(0);
            }
           */
            // works drone launcher
           if(gamepad2.dpad_right){
               drone.setPosition(0.35);
            } 
            if(gamepad2.dpad_left) {
              drone.setPosition(.1);
            } 
           
           
           //doesn't work as expeted // encoder stuff requiered needed !! I have shared the document of 15458's code becau
            /*
            gamepad2.left_stick_y = LastUp
            double position = hando.getCurrentPosition();
            if(gamepad2.left_stick_y && !lastUp)
            telemetry.addDatta("IN if statement" , currentHandoIndex);
            hando.setPower(0.7);//was 0.45
            hando.setTargetPosition(handoPosition{currentHandoIndex % 2});
            hando.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            currentHandoIndex++;
            }
            */
            
            
//this works as exped arm
            if (gamepad2.left_stick_y>0){
                hando.setPower(1);
            }else{
                hando.setPower(-0.2);
            }
            if (gamepad2.left_stick_y<0){
                hando.setPower(-1);
            }
        
        // clawi/ claw that would grab the pixels from Lucas 1 edition
        //works :)"
        if(gamepad2.right_bumper){
            clawi.setPosition(0.8958);
        } 
        if(gamepad2.left_bumper){
            clawi.setPosition(1.0);
        }
         if(gamepad1.right_bumper){
            clawi.setPosition(0.8958);
        } 
        if(gamepad1.left_bumper){
            clawi.setPosition(1.0);
        }
        //rotates the gearbox
       while(gamepad2.right_trigger > 0){
            rotate.setPower(0.25);
        }
        while(gamepad2.left_trigger > 0){
            rotate.setPower(-0.25);
        }
        rotate.setPower(0);
        
     //   if(gamepad2.right)
            // Show the elapsed game time and wheel power.f
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            //telemetry.addData("Motors", "left (%.2f), right (%.2f)",  fL, fR, bL, bR);
            //show the position of the motor on telemetry :)
           telemetry.update();

            
            
        }//closes while opModeIsActive
    }//closes runOpMode
   
}//closes class








