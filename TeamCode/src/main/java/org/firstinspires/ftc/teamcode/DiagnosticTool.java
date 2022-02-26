package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="DiagnosticForWheels")

public class DiagnosticTool extends LinearOpMode {
    private DcMotor backleftDrive = null;
    private DcMotor backrightDrive = null;
    private DcMotor frontleftDrive = null;
    private DcMotor frontrightDrive = null;
    //private DcMotor Potato = null;
    private DcMotor spinnySpin = null;
    private CRServo claw = null;
    private DcMotor arm = null;
    //private CRServo lilPotato= null;




    @Override
    public void runOpMode() {
        waitForStart();
        backleftDrive = hardwareMap.get(DcMotor.class, "backleftDrive");
        backrightDrive = hardwareMap.get(DcMotor.class, "backrightDrive");
        frontleftDrive = hardwareMap.get(DcMotor.class, "frontleftDrive");
        frontrightDrive = hardwareMap.get(DcMotor.class, "frontrightDrive");
        //Potato = hardwareMap.get(DcMotor.class, "Potato");
        spinnySpin = hardwareMap.get(DcMotor.class, "spinnySpin");
        claw = hardwareMap.get(CRServo.class, "claw");
        arm = hardwareMap.get(DcMotor.class, "arm");
        //lilPotato = hardwareMap.crservo.get("lilPotato");
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


//set the motors to a useable mode
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        //Back left

        sleep(2000);
        telemetry.addData("Status","Back left moving forward");
        telemetry.update();
        backleftDrive.setPower(0.5);

        sleep(1000);
        telemetry.addData("Status", "Back left stopped");
        telemetry.update();
        backleftDrive.setPower(0);

        //Back Right
        sleep(2000);
        telemetry.addData("Status","Back right moving forward");
        telemetry.update();
        backrightDrive.setPower(0.5);

        sleep(1000);
        telemetry.addData("Status", "Back right stopped");
        telemetry.update();
        backrightDrive.setPower(0);

        //Front Right
        sleep(2000);
        telemetry.addData("Status","Front right moving forward");
        telemetry.update();
        backleftDrive.setPower(0.5);

        sleep(1000);
        telemetry.addData("Status", "Front right stopped");
        telemetry.update();
        frontrightDrive.setPower(0);

        //Front Left
        sleep(2000);
        telemetry.addData("Status","Back left moving forward");
        telemetry.update();
        frontleftDrive.setPower(0.5);

        sleep(1000);
        telemetry.addData("Status", "Back left stopped");
        telemetry.update();
        frontleftDrive.setPower(0);

        //spinny Spin
        sleep(2000);
        telemetry.addData("Status","SpinnySpin spinning");
        telemetry.update();
        spinnySpin.setPower(0.5);

        sleep(1000);
        telemetry.addData("Status", "SpinnySpin stopped");
        telemetry.update();
        spinnySpin.setPower(0);

        //arm
        sleep(2000);
        telemetry.addData("Status","arm moving");
        telemetry.update();
        int rightEncoders = 1000;
        int armTarget = arm.getCurrentPosition() + rightEncoders;
        arm.setTargetPosition(armTarget);
        arm.setPower(0.5);

        sleep(1000);
        telemetry.addData("Status", "arm stopped");
        telemetry.update();
        arm.setPower(0);

        sleep(1000);
        telemetry.addData("Status", "arm moving back");
        telemetry.update();
        arm.setTargetPosition(-armTarget);
        arm.setPower(-0.5);

        sleep(1000);

        arm.setPower(0);

        //claw
        sleep(2000);
        telemetry.addData("Status","claw opening");
        telemetry.update();
        claw.setPower(0.5);

        sleep(2000);
        telemetry.addData("Status", "claw stopped");
        telemetry.update();
        claw.setPower(0);

        sleep(2000);
        telemetry.addData("Status","claw closing");
        telemetry.update();
        claw.setPower(-0.5);

        sleep(2000);
        telemetry.addData("Status","claw stopped");
        telemetry.update();
        claw.setPower(0);



    }




}