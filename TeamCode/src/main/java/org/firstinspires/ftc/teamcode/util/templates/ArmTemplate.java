package org.firstinspires.ftc.teamcode.util.templates;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

public class ArmTemplate {
    private final Telemetry telemetry;
    private final NebulaServo servoR, servoL;

    public ArmTemplate(
            HardwareMap hw,
            Telemetry telemetry,
            String nameR,
            String nameL,
            NebulaServo.Direction dirR,
            NebulaServo.Direction dirL,
            boolean isEnabled
    ) {
        this.telemetry = telemetry;
        servoR = new NebulaServo(hw, nameR, dirR, isEnabled);
        servoL = new NebulaServo(hw, nameL, dirL, isEnabled);
    }

    public void periodic() {
        telemetry.addData("ServoR Pos", getRPosition());
        telemetry.addData("ServoL Pos", getLPosition());
    }


    public void setTargetPosition(double pos) {
        servoR.setTargetPosition(pos);
        servoL.setTargetPosition(pos);
    }
    public void setSetPoint(double rNum, double lNum) {
        servoR.setPosition(rNum);
        servoL.setPosition(lNum);
    }
    public double getRPosition() {
        return servoR.getPosition();
    }
    public double getLPosition() {
        return servoL.getPosition();
    }
    public NebulaServo getRightServo() {
        return servoR;
    }
    public NebulaServo getLeftServo() {
        return servoL;
    }
}