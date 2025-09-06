package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

public class Dropdown {
    private final NebulaServo dropdownL;
    private final NebulaServo dropdownR;
    private final Telemetry telemetry;
    private double currentPosition = 0.0;

    public enum Value {
        UP(0.0),
        DOWN(1.0);

        public final double position;
        Value(double position) {
            this.position = position;
        }
    }

    public Dropdown(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        dropdownL = new NebulaServo(
                hw, "dropL",
                NebulaServo.Direction.Forward, isEnabled);

        dropdownR = new NebulaServo(hw, "dropR",
                NebulaServo.Direction.Reverse, isEnabled);
        this.telemetry = telemetry;
    }

    public void periodic() {
        telemetry.addData("Dropdown Pos", currentPosition);
    }

    public void set(double position) {
        currentPosition = position;
        dropdownL.setTargetPosition(position);
    }

    public void set(Value value) {
        set(value.position);
    }

    public void directSet(double rawPosition) {
        // Bypass target logic if you want direct control
        currentPosition = rawPosition;
        dropdownL.setPosition(rawPosition);
    }

    public double getPosition() {
        return currentPosition;
    }
}