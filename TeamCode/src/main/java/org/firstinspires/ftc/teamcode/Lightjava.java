package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
@Autonomous(name = "Auto1")

public class Lightjava extends LinearOpMode {



    


    @Override
    public void runOpMode(){

        DcMotor frontleftDrive = hardwareMap.dcMotor.get("frontleftDrive");
        DcMotor backleftDrive = hardwareMap.dcMotor.get("backleftDrive");
        DcMotor frontrightDrive = hardwareMap.dcMotor.get("frontrightDrive");
        DcMotor backrightDrive = hardwareMap.dcMotor.get("backrightDrive");

        waitForStart();
        //This starts the bot
        sleep(1000);


        frontleftDrive.setPower(-1);
        backrightDrive.setPower(-1);
        backleftDrive.setPower(1);
        frontrightDrive.setPower(1);

        sleep(2000);
        
        
        frontleftDrive.setPower(0);
        backrightDrive.setPower(0);
        backleftDrive.setPower(0);
        frontrightDrive.setPower(0);
        
        //second chain
        sleep(1000);


        frontleftDrive.setPower(1);
        backrightDrive.setPower(1);
        backleftDrive.setPower(-1);
        frontrightDrive.setPower(-1);

        sleep(2000);
        
        
        frontleftDrive.setPower(0);
        backrightDrive.setPower(0);
        backleftDrive.setPower(0);
        frontrightDrive.setPower(0);
        


    }
}
