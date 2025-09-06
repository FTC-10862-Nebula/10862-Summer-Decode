package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;
@Deprecated
public class Slides {
    private final NebulaMotor right, left;
    private PIDFCoefficients slideCoefficients =
            new PIDFCoefficients(0, 0, 0, 0);   // P, I, D, F
    private final Telemetry telemetry;
    private double setPoint = 0;

    public Slides(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        this.telemetry = telemetry;

        right = new NebulaMotor(hw, "slideR",
                DcMotorSimple.Direction.FORWARD,
                DcMotor.ZeroPowerBehavior.BRAKE,
                isEnabled);

        left = new NebulaMotor(hw, "slideL",
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
        return (right.getPosition() + left.getPosition()) / 2.0;
    }

    public void resetEncoder() {
        right.resetEncoder();
        left.resetEncoder();
    }

    public void setTargetPosition(double target) {
        setPoint = target;
        right.setTargetPosition(target);
        left.setTargetPosition(target);
    }

    public double getSetPoint() {
        return setPoint;
    }

    public PIDFCoefficients getCoefficients() {
        return slideCoefficients;
    }

    public void setCoefficients(PIDFCoefficients coeffs) {
        this.slideCoefficients = coeffs;
        right.setPIDFCoefficients(coeffs);
        left.setPIDFCoefficients(coeffs);
    }
}