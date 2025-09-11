package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.templates.ArmTemplate;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

//2 servos
public class Hood extends ArmTemplate {
    private final Telemetry telemetry;

    public Hood(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        super(
                new NebulaServo[]{
                new NebulaServo(hw,
                        "armR",
                        NebulaServo.Direction.Forward,
                        isEnabled),

                        new NebulaServo(hw,
                                "armL",
                                NebulaServo.Direction.Reverse,
                                isEnabled)
                },
                telemetry
        );
        this.telemetry = telemetry;
    }

    @Override
    public void periodic() {
        super.periodic();
        telemetry.addData("Arm", "Active");
    }
    public void moveToX() {
        setSetPoint(0.2);
    }

    public void moveToY() {
        setSetPoint(0.8);
    }
}
