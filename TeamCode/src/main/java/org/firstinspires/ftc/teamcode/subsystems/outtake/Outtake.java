package org.firstinspires.ftc.teamcode.subsystems.outtake;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Outtake {
    private Telemetry telemetry;
    private Value value;
    private final Slides slides;
    private final Hood arm;
    private final Pivot pivot;

    public enum Value {
        START(0, 0,0),
        HIGH(0, 0,0),
        LOW(0, 0,0);

        public double slidePos, armPos, pivotPos;

        Value(double slidePos, double armPos, double pivotPos) {
            this.slidePos = slidePos;
            this.armPos = armPos;
            this.pivotPos = pivotPos;
        }
    }

    public Outtake(Slides slides, Hood arm, Pivot pivot, Telemetry telemetry) {
        this.slides = slides;
        this.arm = arm;
        this.pivot = pivot;
        this.telemetry = telemetry;
    }

    public CommandBase setPosition(Value value) {
        return new InstantCommand(() -> setValue(value));
    }

    public void setValue(Value value) {
        this.value = value;
        slides.setTargetPosition(value.slidePos);
        arm.setSetPoint(value.armPos);
        pivot.setSetPoint(value.pivotPos);
        telemetry.addData("Outtake set to", value);
        telemetry.update();
    }
}