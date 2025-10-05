package org.firstinspires.ftc.teamcode.util.teleop;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivetrain.FieldCentric;
import org.firstinspires.ftc.teamcode.subsystems.intake.PowerIntake;
import org.firstinspires.ftc.teamcode.subsystems.outtake.ShooterScrim;

@TeleOp
public class TeleOpScrim extends MatchOpMode {
    private GamepadEx driverGamepad, operatorGamepad;
    private PowerIntake powerIntake;
   // private ShooterScrim shooterScrim;
    private FieldCentric fieldCentric;
    private boolean drivetrainEnabled = true;

    @Override
    public void robotInit() {
        fieldCentric = new FieldCentric(hardwareMap);
        driverGamepad = new GamepadEx(gamepad1);
        operatorGamepad = new GamepadEx(gamepad2);

      //  shooterScrim = new ShooterScrim(telemetry, hardwareMap, true);
        powerIntake = new PowerIntake(telemetry, hardwareMap, true);
    }

    @Override
    public void configureButtons() {
        operatorGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(new InstantCommand(() -> powerIntake.setValue(PowerIntake.Value.INTAKE)))
                .whenReleased(new InstantCommand(() -> powerIntake.setValue(PowerIntake.Value.STOP)));

//        operatorGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
//                .whenPressed(new InstantCommand(() -> shooterScrim.setValue(ShooterScrim.Value.SHOOT)))
//                .whenReleased(new InstantCommand(() -> shooterScrim.setValue(ShooterScrim.Value.STOP)));
    }

    @Override
    public void matchStart() {

    }

    @Override
    public void matchLoop() {
        if (drivetrainEnabled) {
            // Reset IMU yaw
            if (driverGamepad.getButton(GamepadKeys.Button.A)) {
                fieldCentric.resetYaw();
            }

            // Switch between robot-relative and field-centric drive
            if (driverGamepad.getButton(GamepadKeys.Button.LEFT_BUMPER)) {
                fieldCentric.driveFieldRelative(
                        -driverGamepad.getLeftY(),
                        driverGamepad.getLeftX(),
                        driverGamepad.getRightX()
                );
            } else {
                fieldCentric.drive(
                        -driverGamepad.getLeftY(),
                        driverGamepad.getLeftX(),
                        driverGamepad.getRightX()
                );
            }
        }

        telemetry.addLine("Press A to reset Yaw");
        telemetry.addLine("Hold left bumper for robot-relative drive");
        telemetry.update();
    }
}