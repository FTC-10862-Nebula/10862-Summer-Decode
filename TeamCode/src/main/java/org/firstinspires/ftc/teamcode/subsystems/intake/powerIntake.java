package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;

public class powerIntake {
    private Telemetry telemetry;
    public NebulaMotor pintake;

    public powerIntake(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        pintake = new NebulaMotor(hw, "pIntake",
                DcMotorSimple.Direction.FORWARD,
                DcMotor.ZeroPowerBehavior.BRAKE,
                isEnabled);
        this.telemetry = telemetry;
    }

    public void periodic() {}

    public void setPower(double power){
        pintake.setPower(power);
    }
}

