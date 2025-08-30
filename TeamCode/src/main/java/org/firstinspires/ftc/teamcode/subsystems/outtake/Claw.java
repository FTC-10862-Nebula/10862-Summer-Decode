package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

public class Claw {

    public enum Value{
        OPEN(1),
        CLOSE(0);
        public final double pos;
        Value (double pos) {
            this.pos = pos;
        }
        Value (Value value) {
            this.pos = value.pos;
        }
    }
    private final NebulaServo clawS;
    Telemetry telemetry;

    public Claw(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        clawS = new NebulaServo(hw,
                "clawS",
                NebulaServo.Direction.Forward,
                isEnabled);
        this.telemetry = telemetry;
    }

    public void periodic(){}

    public void setClawS(Value value){clawS.setPosition(value.pos);}
    public double getClawPos(){return clawS.getPosition();}
}
