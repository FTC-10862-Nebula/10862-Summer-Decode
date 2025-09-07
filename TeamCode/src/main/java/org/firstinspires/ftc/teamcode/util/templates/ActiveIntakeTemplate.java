package org.firstinspires.ftc.teamcode.util.templates;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaMotor;

    public class ActiveIntakeTemplate {
        private Telemetry telemetry;
        private final NebulaMotor motor;
        private double currentPower = 0.0;

        public enum Value {
            FORWARD(1.0),
            REVERSE(-1.0),
            STOP(0.0);

            public final double power;
            Value(double power) {
                this.power = power;
            }
        }

        public ActiveIntakeTemplate(
                HardwareMap hw,
                String name,
                DcMotorSimple.Direction direction,
                DcMotor.ZeroPowerBehavior zeroPower,
                boolean isEnabled
        ) {
            motor = new NebulaMotor(
                    hw,
                    name,
                    direction,
                    zeroPower,
                    isEnabled
            );
        }

        public void periodic() {
            telemetry.addData("Motor Power", currentPower);
        }

        public void setPower(double power) {
            currentPower = power;
            motor.setPower(power);
        }

        public void setPower(Value value) {
            setPower(value.power);
        }

        public double getPower() {
            return currentPower;
        }
    }
