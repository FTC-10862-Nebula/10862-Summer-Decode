package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;
import org.firstinspires.ftc.teamcode.util.templates.ElevatorTemplate;

public class Lift extends ElevatorTemplate {
    private final Telemetry telemetry;

    public Lift(HardwareMap hw, Telemetry telemetry, boolean isEnabled) {
        super(
                new NebulaMotor[] {
                        new NebulaMotor(hw, "motorRight",
                                DcMotorSimple.Direction.FORWARD,
                                DcMotor.ZeroPowerBehavior.BRAKE, isEnabled),

                        new NebulaMotor(hw, "motorLeft",
                                DcMotorSimple.Direction.REVERSE,
                                DcMotor.ZeroPowerBehavior.BRAKE, isEnabled)
                },
                telemetry,
                new PIDFController(0, 0, 0, 0)
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