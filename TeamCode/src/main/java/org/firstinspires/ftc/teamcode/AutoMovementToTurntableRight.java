package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "move_To_Turntable(Right)")

public class AutoMovementToTurntableRight extends LinearOpMode {






    @Override
    public void runOpMode(){

        DcMotor frontleftDrive = hardwareMap.dcMotor.get("frontleftDrive");
        DcMotor backleftDrive = hardwareMap.dcMotor.get("backleftDrive");
        DcMotor frontrightDrive = hardwareMap.dcMotor.get("frontrightDrive");
        DcMotor backrightDrive = hardwareMap.dcMotor.get("backrightDrive");
        DcMotor spinnySpin = hardwareMap.dcMotor.get("spinnySpin");
        frontrightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        backrightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        //This starts the bot
        sleep(1000);

        telemetry.addData("Status","Starting motion");
        telemetry.update();
        frontleftDrive.setPower(1);
        frontrightDrive.setPower(1);
        backleftDrive.setPower(1);
        backrightDrive.setPower(1);
        sleep(300);

        telemetry.addData("All Stop", "Comencing Action");
        telemetry.update();
        frontleftDrive.setPower(0);
        frontrightDrive.setPower(0);
        backleftDrive.setPower(0);
        backrightDrive.setPower(0);
        //Turn left
        sleep(1200);

        telemetry.addData("Status","Turning right");
        telemetry.update();
        frontleftDrive.setPower(1);
        frontrightDrive.setPower(-1);
        backleftDrive.setPower(1);
        backrightDrive.setPower(-1);
        sleep(850);

        telemetry.addData("All Stop", "Comencing Action");
        telemetry.update();
        frontleftDrive.setPower(0);
        frontrightDrive.setPower(0);
        backleftDrive.setPower(0);
        backrightDrive.setPower(0);
        //Move to turntable
        sleep(1000);

        telemetry.addData("Status","Moving to turntable");
        telemetry.update();
        frontleftDrive.setPower(1);
        frontrightDrive.setPower(1);
        backleftDrive.setPower(1);
        backrightDrive.setPower(1);
        sleep(2700);

        telemetry.addData("All Stop", "Comencing Action");
        telemetry.update();
        frontleftDrive.setPower(0);
        frontrightDrive.setPower(0);
        backleftDrive.setPower(0);
        backrightDrive.setPower(0);
        //spin the turntable
        sleep(1000);

        telemetry.addData("Status","Spinning the turntable");
        telemetry.update();
        spinnySpin.setPower(-0.35);
        sleep(3000);

        telemetry.addData("All Stop", "Comencing Action");
        telemetry.update();
        spinnySpin.setPower(0);
    /*
        sleep(1000);
        telemetry.addData("Moving Backwards","Starting Motion");
        telemetry.update();
       frontleftDrive.setPower(-1);
       frontrightDrive.setPower(-1);
       backleftDrive.setPower(-1);
       backrightDrive.setPower(-1);
       sleep (4000);
       telemetry.addData ("All Stop","Comenceing Action");
       telemetry.update();
        frontleftDrive.setPower(0);
       frontrightDrive.setPower(0);
       backleftDrive.setPower(0);
       backrightDrive.setPower(0);*/




    }
}
