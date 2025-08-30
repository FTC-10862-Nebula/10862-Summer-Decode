package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

public class Pivot {
    private NebulaServo pivot;
    Telemetry telemetry;

    public Pivot(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        pivot = new NebulaServo(hw,
                "pivot",
                NebulaServo.Direction.Forward,
                isEnabled);
        this.telemetry = telemetry;
    }

    public void periodic() {
        telemetry.addData("pivot: ", getPivotPosition());
    }

    // Outtake
    public void setTargetPosition(double position) {
        pivot.setTargetPosition(position);
    }

    // here
    public void setSetPoint(double rNum, double lNum) {
        pivot.setPosition(rNum);
    }

    public double getPivotPosition() {
        return pivot.getPosition();
    }
}

