// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import java.util.Timer;
// import com.qualcomm.robotcore.hardware.CRServo;
// import com.qualcomm.robotcore.hardware.Servo;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.util.Range;
// import java.util.TimerTask;

// @TeleOp(name="NesiCodev1", group="Linear Opmode")
// public class NesiCodev1 extends LinearOpMode {

//     // Declare OpMode members.
//     private ElapsedTime runtime = new ElapsedTime();
//     private Timer timer = new Timer();
//     public DcMotor fL = null;
//     public DcMotor fR = null;
//     public DcMotor bL = null;
//     public DcMotor bR = null;
//     private DcMotor arm = null;
//     private Servo l1 = null;
//     private Servo l2 = null;
//     private Servo c1 = null;
//     private Servo c2 = null;
//     private Servo c3 = null;
//     private Servo c4 = null;
//     private Servo a1 = null;
//     private Servo a2 = null;
//     //private Servo a3 = null;
//     //private Servo a4 = null;
//     private Servo u1 = null;
//     private Servo u2 = null;
//     private Servo cU1 = null;
//     private Servo cU2 = null;
//     //private Servo cL1= null;
//     //private Servo cL2= null;
    
//     @Override
//     public void runOpMode() {
//         telemetry.addData("Status", "Initialized");
//         telemetry.update();

//         // Initialize the hardware variables. Note that the strings used here as parameters
//         // to 'get' must correspond to the names assigned during the robot configuration
//         // step (using the FTC Robot Controller app on the phone).
//         fL  = hardwareMap.get(DcMotor.class, "fL");
//         fR = hardwareMap.get(DcMotor.class, "fR");
//         bL  = hardwareMap.get(DcMotor.class, "bL");
//         bR = hardwareMap.get(DcMotor.class, "bR");
//         arm = hardwareMap.get(DcMotor.class, "arm");
//         l1 = hardwareMap.get(Servo.class, "l1");
//         l2 = hardwareMap.get(Servo.class, "l2");
//         c1 = hardwareMap.get(Servo.class, "c1");
//         c2 = hardwareMap.get(Servo.class, "c2");
//         a1 = hardwareMap.get(Servo.class, "a1");
//         a2 = hardwareMap.get(Servo.class, "a2");
//         c3 = hardwareMap.get(Servo.class, "c3");
//         c4 = hardwareMap.get(Servo.class, "c4");
//         //a3 = hardwareMap.get(Servo.class, "a3");
//         //a4 = hardwareMap.get(Servo.class, "a4");
//         u1= hardwareMap.get(Servo.class, "u1");
//         u2 = hardwareMap.get(Servo.class, "u2");
//         cU1 = hardwareMap.get(Servo.class, "cU1");
//         cU2 = hardwareMap.get(Servo.class, "cU2");
//         //cL1 = hardwareMap.get(Servo.class, "cL1");
//         //cL2= hardwareMap.get(Servo.class, "cL2");
//         // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
//         // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
//         // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
//         fL.setDirection(DcMotor.Direction.REVERSE);
//         bL.setDirection(DcMotor.Direction.REVERSE);
//         fR.setDirection(DcMotor.Direction.REVERSE);
//         bR.setDirection(DcMotor.Direction.FORWARD);
//         arm.setDirection(DcMotor.Direction.REVERSE);
        
//         class MoveArmToDownPosition extends TimerTask {
//             public void run() {
//                 c1.setPosition(0);
//                 c2.setPosition(0);
//                 c3.setPosition(0);
//                 c4.setPosition(0);
//             }
//         }
//         class MoveArmToDownPosition2 extends TimerTask {
//             public void run() {
//                 c1.setPosition(0.25);
//                 c2.setPosition(0.25);
//                 c3.setPosition(0.25);
//                 c4.setPosition(0.25);
//             }
//         }
//         class MoveArmToDownPosition3 extends TimerTask {
//             public void run() {
//                 c1.setPosition(0.3);
//                 c2.setPosition(0.3);
//                 c3.setPosition(0.3);
//                 c4.setPosition(0.3);
//             }
//         }
//         class MoveArmToDownPosition4 extends TimerTask {
//             public void run() {
//                 c1.setPosition(0.35);
//                 c2.setPosition(0.35);
//                 c3.setPosition(0.35);
//                 c4.setPosition(0.35);
//             }
//         }
//         // Wait for the game to start (driver presses PLAY)
//         waitForStart();
//         runtime.reset();

//         // run until the end of the match (driver presses STOP)
//         while (opModeIsActive()) {

//             // Setup a variable for each drive wheel to save power level for telemetry

//             // Choose to drive using either Tank Mode, or POV Mode
//             // Comment out the method that's not used.  The default below is POV.

//             // POV Mode uses left stick to go forward, and right stick to turn.
//             // - This uses basic math to combine motions and is easier to drive straight.
//             double drive = -gamepad1.left_stick_y;
//             double turn  =  gamepad1.right_stick_x;
//             double strafe = gamepad1.left_stick_x;
//             boolean strafeL = gamepad1.x;
//             boolean strafeR = gamepad1.y;
//             double LY2 = gamepad2.left_stick_y;
//             boolean RB = gamepad2.right_bumper;
//             boolean LB = gamepad2.left_bumper;
//             /*if(gamepad1.dpad_up){
//                 fL.setPower(0.75);
//                 fR.setPower(0.75);
//                 fL.setPower(0.75);
//                 fR.setPower(0.75);
//             }
//             if(gamepad1.dpad_down){
//                 fL.setPower(-0.75);
//                 fR.setPower(-0.75);
//                 fL.setPower(-0.75);
//                 fR.setPower(-0.75);
//             }
            
//             if (strafeL || gamepad1.dpad_left) {
//                 fL.setPower(-0.7);
//                 fR.setPower(0.7);
//                 bL.setPower(1.0);
//                 bR.setPower(-1.0);
//             }
//             else if (strafeR || gamepad1.dpad_right) {
//                 fL.setPower(0.7);
//                 fR.setPower(-0.7);
//                 bL.setPower(-1.0);
//                 bR.setPower(1.0);
//             }
            
//           */ 

//             // Tank Mode uses one stick to control each wheel.
//             // - This requires no math, but it is hard to drive forward slowly and keep straight.
//             // leftPower  = -gamepad1.left_stick_y ;
//             // rightPower = -gamepad1.right_stick_y ;

//             // Send calculated power to wheels
//             double frontleftPower = 0.6 * Range.clip(drive - turn + strafe, -1.0, 1.0);
//             double frontrightPower = 0.6 * Range.clip(drive + turn - strafe, -1.0, 1.0);
//             double backleftPower = 0.6 * Range.clip(drive + turn - strafe, -1.0, 1.0);
//             double backrightPower = 0.6 * Range.clip(drive + turn + strafe, -1.0, 1.0);
//             fL.setPower(frontleftPower);
//             bL.setPower(backleftPower);
//             fR.setPower(frontrightPower);
//             bR.setPower(backrightPower);
            
            
//             // Arm 
            
//             if (gamepad1.dpad_up){
//                 arm.setPower(0.5);
//             } else if (gamepad1.dpad_down){
//                 arm.setPower(-0.5);
//             } else {
//                 arm.setPower(0.1);
//             }
//             //THIS IS INTAKE ARM CODE (l1-l2)
//             if (gamepad1.dpad_left){
//                 l1.setPosition(0); 
//                 l2.setPosition(0);
//             }
            
//             if (gamepad1.dpad_right){
//                 l1.setPosition(0.7); 
//                 l2.setPosition(0.4); 
//             }
//              if (gamepad1.x){
//                 l1.setPosition(0); 
//                 l2.setPosition(0);
//             }
            
//             if (gamepad1.b){
//                 l1.setPosition(0.5); 
//                 l2.setPosition(0.4); 
//             }
                
//             /*if (gamepad2.right_bumper){
//                 a1.setPosition(0); 
//                 a2.setPosition(0);
//             }
            
//             if (gamepad2.left_bumper){
//                 a1.setPosition(0.7); 
//                 a2.setPosition(0.4);
//             }  
//             */
//             if(gamepad2.a){
//                 timer.schedule(new MoveArmToDownPosition4(), 200);
//                 c1.setPosition(0.35);
//                 c2.setPosition(0.35);
//                 c3.setPosition(0.35);
//                 c4.setPosition(0.35);
//                 timer.schedule(new MoveArmToDownPosition3(), 400);
//                 c1.setPosition(0.3);
//                 c2.setPosition(0.3);
//                 c3.setPosition(0.3);
//                 c4.setPosition(0.3);
//                 timer.schedule(new MoveArmToDownPosition2(), 600);
//                 c1.setPosition(0.25);
//                 c2.setPosition(0.25);
//                 c3.setPosition(0.25);
//                 c4.setPosition(0.25);
//                 timer.schedule(new MoveArmToDownPosition(), 800);
//                 c1.setPosition(0.1);
//                 c2.setPosition(0.15);
//                 c3.setPosition(0.15);
//                 c4.setPosition(0.15);
                
//                 telemetry.addData("Status", "a is pressed");
//             }
            
//              if(gamepad2.y){
//                 c1.setPosition(0.4);
//                 c2.setPosition(0.4);
//                 c3.setPosition(0.4);
//                 c4.setPosition(0.4);
//                 telemetry.addData("Status", "y is pressed");
//             }
            
//             if(gamepad2.x){
//                 u1.setPosition(0.7);
//                 u2.setPosition(0);
//                 cU1.setPosition(0.1);
                
//                 telemetry.addData("Status", "x is pressed");
//             }
//             if(gamepad2.b){
//                 u1.setPosition(0);
//                 u2.setPosition(0.7);
                
//                 telemetry.addData("Status", "b is pressed");
//             }
            
            
//              if(gamepad2.dpad_up){
//                 cU1.setPosition(0);
//                 //cU2.setPosition(0.8);
                
//                 telemetry.addData("Status", "x is pressed");
//             }
//              if(gamepad2.left_bumper){
//                 cU2.setPosition(0.3);
//                 //cU2.setPosition(0.8);
                
//                 telemetry.addData("Status", "x is pressed");
//             } if(gamepad2.right_bumper){
//                 cU2.setPosition(0.2);
//                 //cU2.setPosition(0.8);
                
//                 telemetry.addData("Status", "x is pressed");
//             }
//             if(gamepad2.dpad_left){
//                 cU1.setPosition(1);
//                 //cU2.setPosition(0);
                
//                 telemetry.addData("Status", "b is pressed");
//             }
//             //claw flipper
//             if(gamepad2.dpad_right){
//                 cU1.setPosition(0);
//                 //cU2.setPosition(0.8);
                
//                 telemetry.addData("Status", "x is pressed");
//             }
           
//              if(gamepad1.dpad_up){
//                 a1.setPosition(0);
                
                
//                 telemetry.addData("Status", "x is pressed");
//             }
//             if(gamepad1.dpad_down){
//                 a1.setPosition(0.6);
                
                
//                 telemetry.addData("Status", "b is pressed");
//             }
//             //claw
//             if(gamepad1.left_bumper){
//                 a2.setPosition(0.3);
                
                
//                 telemetry.addData("Status", "x is pressed");
//             }
//             if(gamepad1.right_bumper){
//                 a2.setPosition(0.1);
                
                
//                 telemetry.addData("Status", "b is pressed");
//             }
//              //RIGHT ONE CODE
//              //END OF SCORING ARM
//             // Show the elapsed game time and wheel power.f
//             telemetry.addData("Status", "Run Time: " + runtime.toString());
//             //telemetry.addData("Motors", "left (%.2f), right (%.2f)",  fL, fR, bL, bR);
//             telemetry.update();
            
            
            
//         }//closes while opModeIsActive
//     }//closes runOpMode
// }//closes class



