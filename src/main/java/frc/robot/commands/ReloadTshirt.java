package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TshirtCannon;

public class ReloadTshirt extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TshirtCannon tshirtCannon;

    public ReloadTshirt(TshirtCannon tshirtCannon){
        this.tshirtCannon = tshirtCannon;
        addRequirements(tshirtCannon);
    }
    

    @Override
    public void initialize(){
        tshirtCannon.reload();
    }

    @Override
    public void execute(){
        
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted){

    }
}
