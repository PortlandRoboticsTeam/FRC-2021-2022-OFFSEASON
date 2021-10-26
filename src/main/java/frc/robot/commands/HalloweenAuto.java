package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class HalloweenAuto extends CommandBase {
    private final Drivetrain drivetrain;
    AnalogInput distanceSensor = new AnalogInput(0);
    private double voltage;
    private int range;


    public HalloweenAuto(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);

    }

    public int Convert(double voltage) {
        double vi = 5/1024;
        double rangeMm = 5.0*(voltage/vi);
        double rangeM = rangeMm/1000;
        return (int)rangeM;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        this.voltage = distanceSensor.getVoltage();
        this.range = Convert(this.voltage);
        System.out.println(this.range);
        System.out.println(this.voltage);
        if(this.range < 1.5){
            
        }
    }

    @Override
    public boolean isFinished() {
        return (false);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
