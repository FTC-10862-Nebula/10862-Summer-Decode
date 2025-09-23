package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;
import org.firstinspires.ftc.teamcode.util.templates.ShooterTemplate;

public class Shooter extends ShooterTemplate{

    public enum Value {
        SHOOT(1.0),
        REST(0.0);

        public final double velocity;
        Value(double velocity) {
            this.velocity = velocity;
        }
    }
public Shooter (HardwareMap hw, Telemetry telemetry, boolean isEnabled){
    super(
            new NebulaMotor[]{
                    new NebulaMotor(hw, "shooterR",
                            DcMotorSimple.Direction.FORWARD,
                            DcMotor.ZeroPowerBehavior.BRAKE, isEnabled),
                    new NebulaMotor(hw, "shooterL",
                            DcMotorSimple.Direction.FORWARD,
                            DcMotor.ZeroPowerBehavior.BRAKE, isEnabled)
            },
            telemetry,
            new PIDFController(0,0,0,0)
        );
    }

    public void setPosition(Value value) { setVelocity(value.velocity); }

}
