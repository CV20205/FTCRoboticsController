package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous(name = "Pushbot: Auto Drive By Encoder", group = "Pushbot")
@Disabled

public class Odometryandautonav {
    HardwarePushbot robot = new HardwarePushbot();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() {


        robot.init(hardwareMap);

        telemetry.addData("Status", "Resetting Encoders");
        telemetry.update();

        robot.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        telemetry.addData("Path0", "Starting at %7d :%7d",
                robot.leftDrive.getCurrentPosition(),
                robot.rightDrive.getCurrentPosition());
        telemetry.update();


    }

    static final double COUNTS_PER_MOTOR_REV = 1440;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 2.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.77953);
    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;

    public int flocx = (1);
    public int flocy = (1);
    public int slocx = (1);
    private int slocy = (1);


    public int meta = (flocy - slocy);
    public int steps = 14;
    public int zeta = (flocx - slocx);
    public int clocy = ((zeta * steps) + slocx);
    public int clocx = ((meta * steps) + slocy);
    public double dsn1 = Math.sqrt(((flocx * flocx) - (slocx * slocx)) + (flocy * flocy) - (slocy * slocy));


    public double n1x = (flocx - clocx);
    public double n1y = (flocy - clocy);

    public double zet = (flocx - slocx);
    public double met = (flocy - slocy);

    public double blocx = (1);

    public double blocy = (1);

    public double n2x = (flocy - blocx);

    public double n2y = (flocy - blocy);

    public double dsn2 = Math.sqrt(((flocx * flocx) - (blocx * blocx)) + (flocy * flocy) - (blocy * blocy));
    public double t = (30);
    public double VC1 = dsn1 / t;
    public double VC2 = dsn2 / t;

    public double V = (1);




        public int RouteAlignN1() {
            int j = clocx;
            int k = clocy;
            for (double i = clocx; i < n1x; i++) {
                j++;
            }
            for (double i = clocy; i < n1y; i++) {
                k++;
            }
            for (double i = clocx; i > n1x; i--) {
                j--;
            }
            for (double i = clocy; i > n1y; i--) {
                k--;
            }
            return (k & j);
        }

            public int RouteAlignN2 () {
                int j2 = clocx;
                int k2 = clocy;
                for (double i = clocx; i < n2x; i++) {
                    j2++;
                }
                for (double i = clocy; i < n2y; i++) {
                    k2++;
                }
                for (double i = clocx; i > n2x; i--) {
                    j2--;
                }
                for (double i = clocy; i > n2y; i--) {
                    k2--;
                }
                return (k2 & j2);
            }


            public double adjustspeed () {
                double v1 = VC1;
                for (double i = VC1; i < V; i++) {
                    v1++;
                }
                for (double i = VC1; i > V; i--) {
                    v1--;
                }
                while (VC1 == V) {
                    RouteAlignN1();
                }
                double VCf = v1;
                return VCf;
            }

        }





















