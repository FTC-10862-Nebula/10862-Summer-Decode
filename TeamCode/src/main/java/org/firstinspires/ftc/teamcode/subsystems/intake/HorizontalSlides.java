package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;

public class HorizontalSlides {
    private final NebulaMotor rightH, leftH;
    private PIDFCoefficients slideCoefficients =
            new PIDFCoefficients(0, 0, 0, 0);   // P, I, D, F
    private final Telemetry telemetry;
    private double setPoint = 0;

    public HorizontalSlides(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        this.telemetry = telemetry;

        rightH = new NebulaMotor(hw, "slideR",
                DcMotorSimple.Direction.FORWARD,
                DcMotor.ZeroPowerBehavior.BRAKE,
                isEnabled);

        leftH = new NebulaMotor(hw, "slideL",
                DcMotorSimple.Direction.REVERSE,
                DcMotor.ZeroPowerBehavior.BRAKE,
                isEnabled);
    }

    public void periodic() {
        telemetry.addData("Slide SetPoint", getSetPoint());
        telemetry.addData("Slide Position", getPosition());
    }

    // Average of both encoders
    public double getPosition() {
        return rightH.getPosition() + leftH.getPosition()/ 2.0;
    }

    public void resetEncoder() {
        rightH.resetEncoder();
        leftH.resetEncoder();
    }

    public void setTargetPosition(double target) {
        setPoint = target;
        rightH.setTargetPosition(target);
        leftH.setTargetPosition(target);
    }

    public double getSetPoint() {
        return setPoint;
    }

    public PIDFCoefficients getCoefficients() {
        return slideCoefficients;
    }

    public void setCoefficients(PIDFCoefficients coeffs) {
        this.slideCoefficients = coeffs;
        rightH.setPIDFCoefficients(coeffs);
        leftH.setPIDFCoefficients(coeffs);
    }
}
