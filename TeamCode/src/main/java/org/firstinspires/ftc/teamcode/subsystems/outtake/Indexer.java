package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;
import org.firstinspires.ftc.teamcode.util.templates.IndexerTemplate;

public class Indexer extends IndexerTemplate {
    private NebulaServo[] servos;

    public enum Value {
        FORWARD(1.0), // full forward
        STOP(0.0),    // stop
        REVERSE(-1.0);// full reverse

        public final double speed;
        Value(double speed) { this.speed = speed; }
    }

    public Indexer(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        super(
                new NebulaServo[]{
                        new NebulaServo(hw,
                                "indexer",
                                NebulaServo.Direction.Forward,
                                isEnabled, true)
                },
                telemetry
        );
    }

    @Override
    public void periodic() {
        super.periodic();
    }

    public void setSpeed(Value value) {
        servos[0].setPosition(value.speed); // continuous servo: use speed
    }

    public double getSpeed() {
        return servos[0].getSpeed();
    }
}
