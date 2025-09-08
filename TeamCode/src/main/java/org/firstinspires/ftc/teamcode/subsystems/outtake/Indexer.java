package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;
import org.firstinspires.ftc.teamcode.util.templates.IndexerTemplate;

public class Indexer extends IndexerTemplate {
    public enum Value {
        OPEN(1.0),
        CLOSE(0.0);

        public final double pos;
        Value(double pos) {
            this.pos = pos;
        }
    }

    public Indexer(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        super(
                new NebulaServo[]{
                        new NebulaServo(hw,
                                "indexer",
                                NebulaServo.Direction.Forward,
                                isEnabled)
                },
                telemetry
        );
    }

    @Override
    public void periodic() {
        super.periodic();
    }

    public void setPosition(Value value) {
        setSetPoint(value.pos);
    }
}
