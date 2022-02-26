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
@Autonomous(name = "AutoMovement")

public class AutoMovement extends LinearOpMode {


    
    


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
        //sleep(1000);
        //boxcar.setPower(1);
        //telemetry.addData("Move", "Man");
        //telemetry.update();
        //sleep(5000);
        //boxcar.setPower(-1);
        //telemetry.addData("Move", "back");
        //telemetry.update();
        //sleep(3000);
        //boxcar.setPower(0);
        //telemetry.addData("Move", "done");
        //telemetry.update();
        
        
        
        telemetry.addData("Status","Starting motion");
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
