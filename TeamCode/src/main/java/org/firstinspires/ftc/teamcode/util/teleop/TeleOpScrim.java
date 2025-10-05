package org.firstinspires.ftc.teamcode.util.teleop;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.commands.DriveTeleop;
import org.firstinspires.ftc.teamcode.drivetrain.Drive;
import org.firstinspires.ftc.teamcode.drivetrain.FieldCentric;
import org.firstinspires.ftc.teamcode.drivetrain.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.intake.PowerIntake;
import org.firstinspires.ftc.teamcode.subsystems.outtake.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.outtake.ShooterScrim;

@TeleOp
public class TeleOpScrim extends MatchOpMode {
    private GamepadEx driverGamepad, operatorGamepad;
    private PowerIntake powerIntake;
    private ShooterScrim shooterScrim;
//    private FieldCentric fieldCentric;
    private boolean drivetrainEnabled = true;

    private Drive drive;

    @Override
    public void robotInit() {
//        fieldCentric = new FieldCentric(hardwareMap);
        drive = new Drive(hardwareMap);
        driverGamepad = new GamepadEx(gamepad1);
        operatorGamepad = new GamepadEx(gamepad2);
        shooterScrim = new ShooterScrim( telemetry, hardwareMap,true);
        powerIntake = new PowerIntake(telemetry, hardwareMap, true);
    }

    @Override
    public void robotPeriodic() {

    }

    @Override
    public void configureButtons() {
//        driverGamepad.getGamepadButton(GamepadKeys.Button.START)
//                .whenPressed(() -> drivetrainEnabled = !drivetrainEnabled);

        drive.setDefaultCommand(new DriveTeleop(drive, driverGamepad));

        operatorGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(new InstantCommand(() -> powerIntake.setValue(PowerIntake.Value.INTAKE)))
                .whenReleased(new InstantCommand(() -> powerIntake.setValue(PowerIntake.Value.STOP)));

        operatorGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(new InstantCommand(() -> shooterScrim.setValue(ShooterScrim.Value.SHOOT)))
                .whenReleased(new InstantCommand(() -> shooterScrim.setValue(ShooterScrim.Value.STOP)));
    }

    @Override
    public void matchStart() { }

    @Override
    public void matchLoop() {
//        if (drivetrainEnabled) {
//            fieldCentric.drive(
//                    -driverGamepad.getLeftY(),
//                    driverGamepad.getLeftX(),
//                    driverGamepad.getRightX()
//            );
//        }
    }
}
