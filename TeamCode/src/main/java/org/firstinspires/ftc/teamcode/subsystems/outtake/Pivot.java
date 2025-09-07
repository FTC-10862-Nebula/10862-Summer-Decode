package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;
import org.firstinspires.ftc.teamcode.util.templates.ClawTemplate;

public class Pivot extends ClawTemplate {
    public enum Value {
        OPEN(1.0),
        CLOSE(0.0);

        public final double pos;
        Value(double pos) {
            this.pos = pos;
        }
    }

    public Pivot (Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        super(
                hw,
                telemetry,
                "pivot",
                NebulaServo.Direction.Forward,
                isEnabled
        );
    }

    @Override
    public void periodic() {
        super.periodic();
    }

    public void setPosition(Pivot.Value value) {
        setTargetPosition(value.pos);
    }
}
