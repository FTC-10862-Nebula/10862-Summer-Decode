package org.firstinspires.ftc.teamcode.subsytems.outtake;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;

public class Slides {
    public NebulaMotor motor;
 public Slides (Telemetry telemetry, HardwareMap hw, boolean isEnabled){
     motor = new NebulaMotor (hw, "slideR",
             DcMotorSimple.Direction.FORWARD,
             DcMotor.ZeroPowerBehavior.BRAKE,
             isEnabled);
     motor = new NebulaMotor (hw, "slideL",
             DcMotorSimple.Direction.REVERSE,
             DcMotor.ZeroPowerBehavior.BRAKE,
             isEnabled);
 }
    public void periodic() {}
    public void setSetPoint(double power){
        motor.setPower(power);
    }
 }

