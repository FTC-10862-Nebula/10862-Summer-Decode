package org.firstinspires.ftc.teamcode.util.templates;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

public class ClawTemplate {
    private final Telemetry telemetry;
    private final NebulaServo servo;

    public ClawTemplate  (
            HardwareMap hw,
            Telemetry telemetry,
            String name,
            NebulaServo.Direction direction,
            boolean isEnabled
    ){
        this.telemetry = telemetry;
        servo = new NebulaServo(hw, name, direction, isEnabled);
    }

    public void periodic() {
        telemetry.addData("Servo Pos", getPosition());
    }

    public void setTargetPosition(double pos) {
        servo.setTargetPosition(pos);
    }
    public void setSetPoint(double Num) {
        servo.setPosition(Num);
    }

    public double getPosition() {
        return servo.getPosition();
    }
    public NebulaServo getServo() {
        return servo;
    }
}
