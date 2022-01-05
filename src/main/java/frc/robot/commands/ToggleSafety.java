package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TshirtCannon;

public class ToggleSafety extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TshirtCannon tshirtCannon;

    public ToggleSafety(TshirtCannon tshirtCannon){
        this.tshirtCannon = tshirtCannon;
        addRequirements(tshirtCannon);
    }
    

    @Override
    public void initialize(){
        tshirtCannon.toggleSafety();
    }

    @Override
    public void execute(){
        
    }

    @Override
    public boolean isFinished(){
        return false;

    }

    @Override
    public void end(boolean interrupted){
    tshirtCannon.toggleSafety();
    
    }
}
