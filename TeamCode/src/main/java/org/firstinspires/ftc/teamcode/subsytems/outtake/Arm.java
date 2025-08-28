package org.firstinspires.ftc.teamcode.subsytems.outtake;
import android.nfc.tech.NfcB;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.nebulaHardware.NebulaServo;

public class Arm {
    public NebulaServo nebulaServo;
    private NebulaServo armR, armL;
    Telemetry telemetry;

    //2 servos
    public Arm(Telemetry telemetry, HardwareMap hw, boolean isEnabled) {
        nebulaServo = new NebulaServo(hw,
                "armL",
                NebulaServo.Direction.Forward,
                isEnabled);
        nebulaServo = new NebulaServo(hw,
                "armR",
                NebulaServo.Direction.Reverse,
                isEnabled);
        this.telemetry = telemetry;
    }

    public void periodic() {
        telemetry.addData("ArmR Pos: " , getRPosition());
        telemetry.addData("ArmLPos: ", getLPosition());

    }
    public void setSetPoint(double rNum, double lNum) {
        armR.setPosition(rNum);
        armL.setPosition(lNum);
    }
    public double getRPosition(){
        return armR.getPosition();
    }
    public double getLPosition(){
        return armL.getPosition();
    }

}
