package org.firstinspires.ftc.teamcode.subsystems.intake;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;
import org.firstinspires.ftc.teamcode.util.templates.ActiveIntakeTemplate;

public class powerIntake extends ActiveIntakeTemplate {
    private final Telemetry telemetry;

    public enum Value {
        INTAKE(1.0),
        OUTTAKE(-1.0),
        STOP(0.0);

        public final double power;
        Value(double power) {
            this.power = power;
        }
    }

    public powerIntake(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        super(
         new NebulaMotor[]{ new NebulaMotor(
             hw, "pIntake",
              DcMotorSimple.Direction.FORWARD,
              DcMotor.ZeroPowerBehavior.BRAKE,
              isEnabled)},
                telemetry);
        this.telemetry = telemetry;
    }

    @Override
    public void periodic() {
        super.periodic();
    }

    public void intake() {
        setPower(Value.INTAKE.power);
    }
    public void outtake() {
        setPower(Value.OUTTAKE.power);
    }

    public void stop() {
        setPower(Value.STOP.power);
    }
}
