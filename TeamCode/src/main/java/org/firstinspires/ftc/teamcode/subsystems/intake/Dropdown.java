package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

public class Dropdown {

    private final NebulaServo dropdown;
    private final Telemetry telemetry;

    public enum Value {
        UP(0.0),
        DOWN(1.0);

        public final double position;

        Value(double position) {
            this.position = position;
        }
    }

    public Dropdown(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        dropdown = new NebulaServo(hw,
                "drop",
                NebulaServo.Direction.Forward,
                isEnabled);
        this.telemetry = telemetry;
    }

    public void periodic() {
        telemetry.addData("DropPos", getPivotPosition());
    }

    public void setTargetPosition(double position) {
        dropdown.setTargetPosition(position);
    }

    public void set(Value value) {
        dropdown.setTargetPosition(value.position);
    }

    public void setSetPoint(double rNum) {
        dropdown.setPosition(rNum);
    }

    public double getPivotPosition() {
        return dropdown.getPosition();
    }
}