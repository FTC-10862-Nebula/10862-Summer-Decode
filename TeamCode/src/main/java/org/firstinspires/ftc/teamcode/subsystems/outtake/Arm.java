package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.templates.ArmTemplate;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

//2 servos
public class Arm extends ArmTemplate {
    private final Telemetry telemetry;

    public Arm(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        super(
                hw,
                telemetry,
                "armR",
                "armL",
                NebulaServo.Direction.Reverse,
                NebulaServo.Direction.Forward,
                isEnabled
        );
        this.telemetry = telemetry;
    }

    @Override
    public void periodic() {
        super.periodic();
        telemetry.addData("Arm", "Active");
    }
    public void moveToTransfer() {
        setTargetPosition(0.2);
    }

    public void moveToScore() {
        setTargetPosition(0.8);
    }
}
