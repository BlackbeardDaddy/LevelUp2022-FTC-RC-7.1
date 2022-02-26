package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous

public class Option1 extends LinearOpMode {



    @Override
    public void runOpMode(){
        DcMotor frontleftDrive = hardwareMap.dcMotor.get("frontleftDrive");
        DcMotor backleftDrive = hardwareMap.dcMotor.get("backleftDrive");
        DcMotor frontrightDrive = hardwareMap.dcMotor.get("frontrightDrive");
        DcMotor backrightDrive = hardwareMap.dcMotor.get("backrightDrive");
        CRServo claw = hardwareMap.crservo.get("claw");
        DcMotor arm = hardwareMap.dcMotor.get("claw");
        CRServo boxcar = hardwareMap.crservo.get("boxcar");
        CRServo dropper = hardwareMap.crservo.get("dropper");

        frontrightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        backrightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
            waitForStart();
    // move off the line
            frontleftDrive.setPower(1);
            backleftDrive.setPower(1);
            backrightDrive.setPower(1);
            frontrightDrive.setPower(1);
            sleep(300);
            //stops the bot
            frontleftDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            frontrightDrive.setPower(0);

            // turns the bot to face the left duck
             sleep(1000);

            frontleftDrive.setPower(-0.5);
            backleftDrive.setPower(-0.5);
            backrightDrive.setPower(0.5);
            frontrightDrive.setPower(0.5);
            sleep(735);
            frontleftDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            frontrightDrive.setPower(0);

            // moves the bot to the duck

            sleep(1000);

            frontleftDrive.setPower(0.5);
            backleftDrive.setPower(0.5);
            backrightDrive.setPower(0.5);
            frontrightDrive.setPower(0.5);
            sleep(1000);
            frontleftDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            frontrightDrive.setPower(0);

            // grabs the duck
            claw.setPower(-0.5);
            //raise the arm
            int rightEncoders = 1000;
            int armTarget = 2000;
            arm.setTargetPosition(armTarget);
            arm.setPower(0.4);
            while (arm.isBusy()) {}
            arm.setPower(0);
            //turn to the loading dock
            sleep(1000);

            frontleftDrive.setPower(0.5);
            backleftDrive.setPower(0.5);
            backrightDrive.setPower(-0.5);
            frontrightDrive.setPower(-0.5);
            sleep(1000);
            frontleftDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            frontrightDrive.setPower(0);

            // move to loading dock

            sleep(1000);

            frontleftDrive.setPower(0.5);
            backleftDrive.setPower(0.5);
            backrightDrive.setPower(0.5);
            frontrightDrive.setPower(0.5);
            sleep(1000);
            frontleftDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            frontrightDrive.setPower(0);

            //drop the duck in the loader
            claw.setPower(1);
            sleep(250);
            claw.setPower(0);

            // lowers the arm
            frontleftDrive.setPower(-0.5);
            backleftDrive.setPower(-0.5);
            backrightDrive.setPower(-0.5);
            frontrightDrive.setPower(-0.5);
            sleep(700);
            frontleftDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            frontrightDrive.setPower(0);

            armTarget = -2000;
            arm.setTargetPosition(-armTarget);
            arm.setPower(-0.4);

            while (arm.isBusy()) {}
            arm.setPower(0);

            // extends the box dropper

            boxcar.setPower(1);
            sleep(5000);
            boxcar.setPower(0);

            // drops the box

            dropper.setPower(-1);
            sleep(2000);
            dropper.setPower(0);
            sleep(1000);
            dropper.setPower(1);
            sleep(2000);
            dropper.setPower(0);

            // retracts the boxcar

            boxcar.setPower(-1);
            sleep(5000);
            boxcar.setPower(0);
}}