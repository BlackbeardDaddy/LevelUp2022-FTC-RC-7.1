package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.CVPipelines.DuckPipeline;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvPipeline;
import org.firstinspires.ftc.teamcode.CVPipelines.DuckPipeline;
import org.openftc.easyopencv.OpenCvWebcam;

@TeleOp
public class CVtest extends LinearOpMode {

    private double crThreshHigh = 70;
    private double crThreshLow = 0;
    private double cbThreshHigh = 180;
    private double cbThreshLow = 160;

    private int minRectangleArea = 100;
    private double leftBarcodeRangeBoundary = 0.3; //i.e 30% of the way across the frame from the left
    private double rightBarcodeRangeBoundary = 0.6; //i.e 60% of the way across the frame from the left

    private double lowerRuntime = 0;
    private double upperRuntime = 0;

    // Cyan Range                                      Y      Cr     Cb
    public static Scalar scalarLowerYCrCb = new Scalar(0.0, 0, 160);
    public static Scalar scalarUpperYCrCb = new Scalar(255.0, 70, 180);

    private DuckPipeline pipeline;

    @Override
    public void runOpMode() {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        WebcamName webcam = hardwareMap.get(WebcamName.class, "Webcam1");
        OpenCvWebcam Webcam1 = OpenCvCameraFactory.getInstance().createWebcam(webcam, cameraMonitorViewId);

        pipeline = new DuckPipeline(0.2, 0.2, 0.2, 0.2);
        pipeline.configureScalarLower(scalarLowerYCrCb.val[0], scalarLowerYCrCb.val[1], scalarLowerYCrCb.val[2]);
        pipeline.configureScalarUpper(scalarUpperYCrCb.val[0], scalarUpperYCrCb.val[1], scalarUpperYCrCb.val[2]);
        Webcam1.setViewportRenderingPolicy(OpenCvCamera.ViewportRenderingPolicy.OPTIMIZE_VIEW);
        Webcam1.setViewportRenderer(OpenCvCamera.ViewportRenderer.GPU_ACCELERATED);
        Webcam1.setPipeline(pipeline);

        Webcam1.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                Webcam1.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);
                telemetry.addLine("Camera is up and running!  Poggers");
                telemetry.update();
            }

            @Override
            public void onError(int errorCode) {
                telemetry.addLine("Camera was too tired to start.  Ffffffff.");
                telemetry.update();
            }
        });

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            if (pipeline.error) {
                telemetry.addData("Exception: ", pipeline.debug.getStackTrace());
            }
            double rectangleArea = pipeline.getRectArea();

            //Print out the area of the rectangle that is found.
            telemetry.addData("Rectangle Area", rectangleArea);

            //Check to see if the rectangle has a large enough area to be a marker.
            if (rectangleArea > minRectangleArea) {
                //Then check the location of the rectangle to see which barcode it is in.
                if (pipeline.getRectMidpointX() > rightBarcodeRangeBoundary * pipeline.getRectWidth()) {
                    telemetry.addData("Barcode Position", "Right");
                } else if (pipeline.getRectMidpointX() < leftBarcodeRangeBoundary * pipeline.getRectWidth()) {
                    telemetry.addData("Barcode Position", "Left");
                } else {
                    telemetry.addData("Barcode Position", "Center");
                }
            }

            telemetry.update();
        }
    }
    public void testing(DuckPipeline pipeline){
        if(lowerRuntime + 0.05 < getRuntime()){
            crThreshLow += -gamepad1.left_stick_y;
            cbThreshLow += gamepad1.left_stick_x;
            lowerRuntime = getRuntime();
        }
        if(upperRuntime + 0.05 < getRuntime()){
            crThreshHigh += -gamepad1.right_stick_y;
            cbThreshHigh += gamepad1.right_stick_x;
            upperRuntime = getRuntime();
        }

        crThreshLow = inValues(crThreshLow, 0, 255);
        crThreshHigh = inValues(crThreshHigh, 0, 255);
        cbThreshLow = inValues(cbThreshLow, 0, 255);
        cbThreshHigh = inValues(cbThreshHigh, 0, 255);

        pipeline.configureScalarLower(0.0, crThreshLow, cbThreshLow);
        pipeline.configureScalarUpper(255.0, crThreshHigh, cbThreshHigh);

        telemetry.addData("lowerCr ", crThreshLow);
        telemetry.addData("lowerCb ", cbThreshLow);
        telemetry.addData("UpperCr ", crThreshHigh);
        telemetry.addData("UpperCb ", cbThreshHigh);
    }
    public double inValues(double value, double min, double max){
        if(value < min){ value = min; }
        if(value > max){ value = max; }
        return value;
    }
}


