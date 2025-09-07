package org.firstinspires.ftc.teamcode.util.templates;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;

public class ElevatorTemplate {
    private final Telemetry telemetry;
    private final NebulaMotor motorR, motorL;
    private double setPoint = 0.0;
    private PIDFCoefficients pidf = new PIDFCoefficients(0, 0, 0, 0);

    public ElevatorTemplate(
            HardwareMap hw,
            Telemetry telemetry,
            String nameR,
            String nameL,
            DcMotorSimple.Direction directionR,
            DcMotorSimple.Direction directionL,
            DcMotor.ZeroPowerBehavior zeroPower,
            boolean isEnabled
    ) {
        this.telemetry = telemetry;
        this.motorR = new NebulaMotor(hw, nameR, directionR, zeroPower, isEnabled);
        this.motorL = new NebulaMotor(hw, nameL, directionL, zeroPower, isEnabled);
    }

    public void periodic() {
        telemetry.addData("Elevator SetPoint", setPoint);
        telemetry.addData("Elevator Position", getPosition());
    }

    public double getPosition() {
        return motorR.getPosition();
    }

    public void resetEncoder() {
        motorR.resetEncoder();
        motorL.resetEncoder();
    }
    public void setSetPoint(double target) {
        setPoint = target;
    }

    public double getSetPoint() {
        return setPoint;
    }
    public PIDFCoefficients getCoefficients() {
        return pidf;
    }
    public void setCoefficients(PIDFCoefficients coeffs) {
        this.pidf = coeffs;
        motorR.setPIDFCoefficients(coeffs);
        motorL.setPIDFCoefficients(coeffs);
    }
    public NebulaMotor getMotorR() {
        return motorR;
    }
    public NebulaMotor getMotorL(){
        return motorL;
    }
}
