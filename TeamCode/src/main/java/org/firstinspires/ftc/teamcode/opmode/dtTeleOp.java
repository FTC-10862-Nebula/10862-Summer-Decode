package org.firstinspires.ftc.teamcode.opmode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drivetrain.MecanumDrive;

@Config
@TeleOp
public class dtTeleOp {
    private Gamepad driverGamepad;
    private MecanumDrive mecanumDrive;
    private boolean drivetrainEnabled = true; // Toggle for drivetrain

    public dtTeleOp() {}
    public void robotInit() {
        mecanumDrive = new MecanumDrive();
        driverGamepad = new Gamepad();
    }
}
