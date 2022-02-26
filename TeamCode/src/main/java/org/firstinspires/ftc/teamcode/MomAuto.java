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
@Autonomous(name = "MomAuto")

public class MomAuto extends LinearOpMode {






    @Override
    public void runOpMode(){

        DcMotor frontleftDrive = hardwareMap.dcMotor.get("frontleftDrive");
        DcMotor backleftDrive = hardwareMap.dcMotor.get("backleftDrive");
        DcMotor frontrightDrive = hardwareMap.dcMotor.get("frontrightDrive");
        DcMotor backrightDrive = hardwareMap.dcMotor.get("backrightDrive");
        DcMotor Potato = hardwareMap.dcMotor.get("Potato");

        waitForStart();
        //This starts the bot
        sleep(1000);

        for (int i=0; i<5;i++) {
            Potato.setPower(-1);
            sleep(1000);
            Potato.setPower(0);
            telemetry.addData("Status", "Me when");
            telemetry.update();

            Potato.setPower(1);
            sleep(1000);
            Potato.setPower(0);

            telemetry.addData("Status", "You're mom");
        }





    }
}
