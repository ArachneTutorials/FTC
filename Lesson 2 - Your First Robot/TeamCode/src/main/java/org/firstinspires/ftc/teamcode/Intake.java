package org.firstinspires.ftc.teamcode;

import arachne.lib.pipeline.BooleanPipe;
import arachne.lib.pipeline.BooleanSource;
import arachne.lib.pipeline.DoublePipe;
import arachne.lib.pipeline.DoubleSource;
import arachne.lib.systems.Subsystem;

public class Intake extends Subsystem {
    private final BooleanPipe shooterIntakeOutput;
    private final DoublePipe intakeOutput;

    private static final double INTAKE_SPEED = 0.7;
    private static final double OUTTAKE_SPEED = -1;

    public Intake() {
        super();

        this.shooterIntakeOutput = new BooleanPipe(false);
        this.intakeOutput = new DoublePipe(0);
    }

    public void intake(boolean activate) {
        if(activate) {
            shooterIntakeOutput.accept(true);
            intakeOutput.accept(INTAKE_SPEED);
        }
        else {
            shooterIntakeOutput.accept(false);
            intakeOutput.accept(0);
        }
    }

    public void outtake(boolean activate) {
        if(activate) {
            shooterIntakeOutput.accept(false);
            intakeOutput.accept(OUTTAKE_SPEED);
        }
        else {
            intakeOutput.accept(0);
        }
//        intakeOutput.accept(activate ? OUTTAKE_SPEED : 0);
    }

    public BooleanSource getShooterIntakeOutput() {
        return shooterIntakeOutput;
    }

    public DoubleSource getIntakeOutput() {
        return intakeOutput;
    }
}
