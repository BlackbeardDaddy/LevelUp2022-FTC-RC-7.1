package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "TurnTest")

public class TurnTest extends LinearOpMode {






    @Override
    public void runOpMode(){

        DcMotor frontleftDrive = hardwareMap.dcMotor.get("frontleftDrive");
        DcMotor backleftDrive = hardwareMap.dcMotor.get("backleftDrive");
        DcMotor frontrightDrive = hardwareMap.dcMotor.get("frontrightDrive");
        DcMotor backrightDrive = hardwareMap.dcMotor.get("backrightDrive");
        CRServo claw = hardwareMap.crservo.get("claw");
        CRServo boxcar = hardwareMap.crservo.get("boxcar");
        frontrightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        backrightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        //This starts the bot
        sleep(1000);
        for (int i = 0; i < 4; i++) {
            telemetry.addData("Status","Moving Forward");
            telemetry.update();
            frontleftDrive.setPower(1);
            frontrightDrive.setPower(1);
            backleftDrive.setPower(1);
            backrightDrive.setPower(1);
            sleep(745);

            telemetry.addData("All Stop", "Comencing Action");
            telemetry.update();
            frontleftDrive.setPower(0);
            frontrightDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            sleep(2000);
            
            telemetry.addData("Status","Turning");
            telemetry.update();
            frontleftDrive.setPower(1);
            frontrightDrive.setPower(-1);
            backleftDrive.setPower(1);
            backrightDrive.setPower(-1);
            sleep(735);

            telemetry.addData("All Stop", "Comencing Action");
            telemetry.update();
            frontleftDrive.setPower(0);
            frontrightDrive.setPower(0);
            backleftDrive.setPower(0);
            backrightDrive.setPower(0);
            sleep(2000);
            
            
            
            
        }


       /* sleep(1000);
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
