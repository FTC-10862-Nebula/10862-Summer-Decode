package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.templates.ElevatorTemplate;

public class Elevator extends ElevatorTemplate {
    private final Telemetry telemetry;

    public Elevator(HardwareMap hw, Telemetry telemetry, boolean isEnabled) {
        super(
                hw,
                telemetry,
                "elevatorR",
                "elevatorL",
                DcMotorSimple.Direction.FORWARD,
                DcMotorSimple.Direction.REVERSE,
                DcMotor.ZeroPowerBehavior.BRAKE,
                isEnabled
        );
        this.telemetry = telemetry;
    }

    @Override
    public void periodic() {
        super.periodic();
        telemetry.addData("Elevator", getSetPoint());
    }

    public void moveToRest() {
        setSetPoint(0);
    }

    public void moveToLift() {
        setSetPoint(1000);
    }
}
