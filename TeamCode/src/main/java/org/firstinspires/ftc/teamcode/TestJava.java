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
@Autonomous(name = "TestJava")

public class TestJava extends LinearOpMode {
    
    @Override
    public void runOpMode(){
    
    CRServo dropper = hardwareMap.crservo.get("dropper");
    
    waitForStart();
    
    sleep(1000);
    telemetry.addData("Status", "Starting");
    telemetry.update();
    dropper.setPower(-1);
    
    sleep(2000);
    telemetry.addData("Status", "Moving back");
    telemetry.update();
    dropper.setPower(1);
    sleep(2000);
    telemetry.addData("Status", "Stopping");
    telemetry.update();
    dropper.setPower(0);
    
    
    
    
    
    }
}