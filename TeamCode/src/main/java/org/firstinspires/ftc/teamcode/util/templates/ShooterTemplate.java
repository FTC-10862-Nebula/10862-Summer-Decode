package org.firstinspires.ftc.teamcode.util.templates;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;

public class ShooterTemplate extends SubsystemBase {
    private final Telemetry telemetry;
    private final NebulaMotor[] motors;
    private final PIDFController pidf;
    private double currentPower = 0.0;

    public ShooterTemplate(
            NebulaMotor[] motors,
            Telemetry telemetry,
            PIDFController pidf
    ) {
        this.motors = motors;
        this.telemetry = telemetry;
        this.pidf = pidf;
    }

    @Override
    public void periodic() {
        telemetry.addData("Shooter Power", currentPower);
    }

    public void setPower(double power) {
        currentPower = power;
        for (NebulaMotor motor : motors) {
            motor.setPower(power);
        }
    }

    public double getPower() {
        return currentPower;
    }
}

