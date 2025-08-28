package org.firstinspires.ftc.teamcode.subsytems.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;

public class powerIntake {
    private Telemetry tl;
    public NebulaMotor motor;

    public powerIntake(Telemetry tl, HardwareMap hw, boolean isEnabled) {
        motor = new NebulaMotor(hw, "pIntake",
                DcMotorSimple.Direction.FORWARD,
                DcMotor.ZeroPowerBehavior.BRAKE,
                isEnabled);
        this.tl = tl;
    }

    public void periodic() {}
    public void setSetPoint(double power){
        motor.setPower(power);
    }
}

