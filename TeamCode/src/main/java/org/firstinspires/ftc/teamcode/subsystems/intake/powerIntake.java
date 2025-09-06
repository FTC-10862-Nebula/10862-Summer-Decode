package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;

public class powerIntake {
    private final Telemetry telemetry;
    private final NebulaMotor pintake;
    private double currentPower = 0.0;

    //Color Sensors will be added

    public enum Value {
        IN(1.0),
        OUT(-1.0),
        STOP(0.0);

        public final double power;
        Value(double power) {
            this.power = power;
        }
    }

    public powerIntake(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        pintake = new NebulaMotor(
                hw,
                "pIntake",
                DcMotorSimple.Direction.FORWARD,
                DcMotor.ZeroPowerBehavior.BRAKE,
                isEnabled
        );
        this.telemetry = telemetry;
    }

    public void periodic() {
        telemetry.addData("Intake Power", currentPower);
    }

    public void setPower(double power) {
        currentPower = power;
        pintake.setPower(power);
    }

    public void setPower(Value value) {
        setPower(value.power);
    }

    public double getPower() {
        return currentPower;
    }
}