package org.firstinspires.ftc.teamcode;

import android.icu.text.CaseMap;

import com.qualcomm.hardware.stmicroelectronics.VL53L0X;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchDevice;
import com.qualcomm.robotcore.hardware.I2cWaitControl;
import com.qualcomm.robotcore.hardware.configuration.I2cSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@I2cSensor(name = "TOF10120 Optical Distance Sensor", description = "Optical Distance Sensor from Taida Century", xmlTag = "TOF10120")
public class TOF10120 extends I2cDeviceSynchDevice<I2cDeviceSynch> implements DistanceSensor {

    @Override
    public Manufacturer getManufacturer()
    {

        return Manufacturer.Other;
    }

    @Override
    protected synchronized boolean doInitialize()
    {
        return true;
    }

    @Override
    public String getDeviceName()
    {

        return "TOF10120 Distance Sensor";
    }

    public TOF10120(I2cDeviceSynch deviceClient)
    {
        super(deviceClient, true);

        this.deviceClient.setI2cAddress(I2cAddr.create8bit(0xa4));

        super.registerArmingStateCallback(false);
        this.deviceClient.engage();
    }
//TODO: REWRITE DATAFRAME ENUM:
    public enum Register
    {
        RangeValue(0x00);

        public int bVal;

        Register(int bVal)
        {
            this.bVal = bVal;
        }
    }
    protected byte readReg()
    {
        return this.deviceClient.read8();
    }
    protected void writeReg(Register reg)
    {
        this.deviceClient.write8(reg.bVal, I2cWaitControl.WRITTEN);
    }

    @Override
    public double getDistance(DistanceUnit unit) {
        writeReg(Register.RangeValue);
        byte UpperByte = readReg();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        byte LowerByte = readReg();

        double range_mm = ((int)UpperByte << 8) | LowerByte;

        if (unit == DistanceUnit.CM) {
            return range_mm / 10;
        } else if (unit == DistanceUnit.METER) {
            return range_mm / 1000;
        } else if (unit == DistanceUnit.INCH) {
            return range_mm / 25.4;
        } else {
            return range_mm;
        }
    }


}
