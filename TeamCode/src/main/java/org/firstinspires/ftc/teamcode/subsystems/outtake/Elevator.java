package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;

public class Elevator {
    protected NebulaMotor elevator;
    private PIDFCoefficients slideCoefficients =
            new PIDFCoefficients(0, 0, 0, 0);   // P, I, D, F
    private Telemetry telemetry;
    private double setPoint = 0;

    public Elevator(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        this.telemetry = telemetry;

        elevator = new NebulaMotor(hw, "elevator",
                DcMotorSimple.Direction.FORWARD,
                DcMotor.ZeroPowerBehavior.BRAKE,
                isEnabled);

    }
    public void periodic() {
        telemetry.addData("Elevator SetPoint", getSetPoint());
        telemetry.addData("Elevator Encoder", getPosition());
    }

    public double getPosition() {
        return elevator.getPosition();
    }
    public void resetEncoder() {
        elevator.resetEncoder();
    }
    public void setSetPoint(double target) {
        setPoint = target;
    }
    public double getSetPoint() {
        return setPoint;
    }
    public PIDFCoefficients getCoefficients() {
        return slideCoefficients;
    }
    public void setCoefficients(PIDFCoefficients coeffs) {
        this.slideCoefficients = coeffs;
        elevator.setPIDFCoefficients(coeffs);
    }
}
