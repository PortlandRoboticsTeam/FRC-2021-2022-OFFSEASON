package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TshirtCannon;
import edu.wpi.first.wpilibj.Timer;

public class SafetyOn extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TshirtCannon tshirtCannon;
    private Timer safetyTimer;

    public SafetyOn(TshirtCannon tshirtCannon){
        this.tshirtCannon = tshirtCannon;
        addRequirements(tshirtCannon);
        safetyTimer = new Timer();
    }
    

    @Override
    public void initialize(){
        safetyTimer.start();
    }

    @Override
    public void execute(){
        
    }

    @Override
    public boolean isFinished(){
        if(safetyTimer.get()>=0.5){
            return true;
        }
        else return false;
    }

    @Override
    public void end(boolean interrupted){
        tshirtCannon.safetySet(false);
        safetyTimer.stop();
        safetyTimer.reset();
    }
}
