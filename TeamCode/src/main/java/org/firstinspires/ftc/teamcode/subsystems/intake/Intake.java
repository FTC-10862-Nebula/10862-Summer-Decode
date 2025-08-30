package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    private Telemetry telemetry;
    private Value value;
    private final powerIntake powerIntake;

    private final Dropdown dropdown;

    public enum Value {
        START(0, 0),
        HIGH(0, 0),
        LOW(0, 0);

        public double powerPos, dropPos;

        Value(double powerPos, double dropPos) {
            this.powerPos = powerPos;
            this.dropPos = dropPos;
        }
    }

    public Intake(powerIntake powerIntake,Dropdown dropdown, Telemetry telemetry) {
        this.powerIntake = powerIntake;
        this.dropdown = dropdown;
        this.telemetry = telemetry;
    }

    public CommandBase setPosition(Value value) {
        return new InstantCommand(() -> setValue(value));
    }

    public void setValue(Value value) {
        this.value = value;
        powerIntake.setPower(value.powerPos);
        dropdown.setTargetPosition(value.dropPos);
        telemetry.addData("Outtake set to", value);
        telemetry.update();
    }
}

