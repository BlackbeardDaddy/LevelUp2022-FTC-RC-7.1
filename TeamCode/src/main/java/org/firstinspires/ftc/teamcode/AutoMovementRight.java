package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
@Autonomous(name = "AutoMovementRight")

public class AutoMovementRight extends LinearOpMode {






    @Override
    public void runOpMode(){

        DcMotor frontleftDrive = hardwareMap.dcMotor.get("frontleftDrive");
        DcMotor backleftDrive = hardwareMap.dcMotor.get("backleftDrive");
        DcMotor frontrightDrive = hardwareMap.dcMotor.get("frontrightDrive");
        DcMotor backrightDrive = hardwareMap.dcMotor.get("backrightDrive");
        CRServo claw = hardwareMap.crservo.get("claw");
        //CRServo boxcar = hardwareMap.crservo.get("boxcar");
        CRServo dropper = hardwareMap.crservo.get("dropper");
        frontrightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        backrightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        //This starts the bot
        sleep(1000);
        // the starting movement that moves it off the glass do not change this section
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

        //turns the bot right or left depending on what code is being used
        frontleftDrive.setPower(1);
        backleftDrive.setPower(1);
        backrightDrive.setPower(-1);
        frontrightDrive.setPower(-1);
        sleep(1500);
        frontleftDrive.setPower(0);
        backleftDrive.setPower(0);
        backrightDrive.setPower(0);
        frontrightDrive.setPower(0);

        //moves the bot forward to be in front of the shipping dock, change this one's time
        frontleftDrive.setPower(1);
        backleftDrive.setPower(1);
        backrightDrive.setPower(1);
        frontrightDrive.setPower(1);
        sleep(2000);
        frontleftDrive.setPower(0);
        backleftDrive.setPower(0);
        backrightDrive.setPower(0);
        frontrightDrive.setPower(0);

        // turns the bot right if it is the left version of the code and left if it is the right version of the code.
        frontleftDrive.setPower(-1);
        backleftDrive.setPower(-1);
        backrightDrive.setPower(1);
        frontrightDrive.setPower(1);
        sleep(1000);
        frontleftDrive.setPower(0);
        backleftDrive.setPower(0);
        backrightDrive.setPower(0);
        frontrightDrive.setPower(0);

        //moves the bot to the shipping element, change this
        frontleftDrive.setPower(1);
        backleftDrive.setPower(1);
        backrightDrive.setPower(1);
        frontrightDrive.setPower(1);
        sleep(2000);
        frontleftDrive.setPower(0);
        backleftDrive.setPower(0);
        backrightDrive.setPower(0);
        frontrightDrive.setPower(0);
        /*// extends the shipping element
        boxcar.setPower(1);
        sleep(5000);
        boxcar.setPower(0);*/

        // drops the box, don't change
        dropper.setPower(-1);
        sleep(2000);
        dropper.setPower(1);
        sleep(2000);
        dropper.setPower(0);

        /*// pulls the shipping element back
        boxcar.setPower(-1);
        sleep(5000);
        boxcar.setPower(0);*/

        //end
        telemetry.addData("Status", "Ready for TeleOp");
        telemetry.update();
        //if you need to change the speed change all four values



        /*telemetry.addData("Status","Starting motion");
        telemetry.update();
        frontleftDrive.setPower(1);
        frontrightDrive.setPower(1);
        backleftDrive.setPower(1);
        backrightDrive.setPower(1);
        sleep(3500);

        telemetry.addData("All Stop", "Comencing Action");
        telemetry.update();
        frontleftDrive.setPower(0);
        frontrightDrive.setPower(0);
        backleftDrive.setPower(0);
        backrightDrive.setPower(0);

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
