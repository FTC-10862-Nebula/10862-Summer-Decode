package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

public class VariableShooter {
    private final NebulaServo armR, armL;
    private final Telemetry telemetry;

    // 2 servos
    public VariableShooter(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        armL = new NebulaServo(hw,
                "armL",
                NebulaServo.Direction.Forward,
                isEnabled);
        armR = new NebulaServo(hw,
                "armR",
                NebulaServo.Direction.Reverse,
                isEnabled);
        this.telemetry = telemetry;
    }

    public void periodic() {
        telemetry.addData("ArmR Pos: ", getRPosition());
        telemetry.addData("ArmL Pos: ", getLPosition());
    }

    // convenience for Outtake (single position)
    public void setTargetPosition(double position) {
        armR.setTargetPosition(position);
        armL.setTargetPosition(position);
    }

    // for independent control
    public void setSetPoint(double rNum, double lNum) {
        armR.setPosition(rNum);
        armL.setPosition(lNum);
    }

    public double getRPosition() {
        return armR.getPosition();
    }

    public double getLPosition() {
        return armL.getPosition();
    }
}