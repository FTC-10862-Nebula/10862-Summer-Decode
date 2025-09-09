package org.firstinspires.ftc.teamcode.util.nebulaHardware;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class NebulaServo {
    public enum Direction { Forward, Reverse }

    private final ServoImplEx servo;
    private final boolean isEnabled;
    private final boolean isContinuous; // new

    public NebulaServo(HardwareMap hM, String deviceId,
                       Direction direction, boolean isEnabled, boolean isContinuous) {
        servo = (ServoImplEx) hM.get(Servo.class, deviceId);
        this.isEnabled = isEnabled;
        this.isContinuous = isContinuous;

        servo.setDirection(direction == Direction.Reverse ?
                Servo.Direction.REVERSE : Servo.Direction.FORWARD);
    }

    /** Normal or continuous control */
    public void setPosition(double position) {
        if (!isEnabled) return;

        if (isContinuous) {
            // Map -1..1 input to 0..1 PWM
            position = Math.max(-1, Math.min(1, position));
            servo.setPosition(0.5 + position / 2.0);
        } else {
            // Standard servo: clamp 0..1
            position = Math.max(0, Math.min(1, position));
            servo.setPosition(position);
        }
    }
    public double getPosition() {
        return servo.getPosition();
    }
    public double getSpeed() {
        if (!isContinuous) return 0;
        return (servo.getPosition() - 0.5) * 2.0;
    }

    // Keep the rest of your methods the same
}
