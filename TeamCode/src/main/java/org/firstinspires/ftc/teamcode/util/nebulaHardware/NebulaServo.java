package org.firstinspires.ftc.teamcode.util.nebulaHardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class NebulaServo {
    public enum Direction {
        Forward,
        Reverse
    }

    private final ServoImplEx servo;
    private final boolean isEnabled;

    /**
     * @param hM HardwareMap
     * @param deviceId Config name
     * @param direction Forward or Reverse
     * @param isEnabled Whether enabled
     */
    public NebulaServo(HardwareMap hM, String deviceId,
                       Direction direction, boolean isEnabled) {
        servo = (ServoImplEx) hM.get(Servo.class, deviceId);
        this.isEnabled = isEnabled;

        servo.setDirection(direction == Direction.Reverse ?
                Servo.Direction.REVERSE : Servo.Direction.FORWARD);
    }

    /** Normal position control (0–1 range) */
    public void setPosition(double position) {
        if (isEnabled) {
            // Clamp between 0–1
            position = Math.max(0, Math.min(1, position));
            servo.setPosition(position);
        }
    }

    /** For consistency with NebulaMotor */
    public void setTargetPosition(double position) {
        setPosition(position);
    }

    /** Current servo position */
    public double getPosition() {
        return servo.getPosition();
    }

    /** Direct SDK disable (PWM output stops) */
    public void disable() {
        servo.setPwmDisable();
    }

    /** Re-enable servo if disabled */
    public void enable() {
        servo.setPwmEnable();
    }

    /** Static factory */
    public static NebulaServo create(HardwareMap hM, String deviceId,
                                     Direction direction, double minAngle,
                                     double maxAngle, boolean isEnabled) {
        return new NebulaServo(hM, deviceId, direction, isEnabled);
    }
}