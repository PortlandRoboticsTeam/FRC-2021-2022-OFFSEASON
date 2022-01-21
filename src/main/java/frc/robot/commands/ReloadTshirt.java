package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TshirtCannon;
import edu.wpi.first.wpilibj.Timer;

public class ReloadTshirt extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TshirtCannon tshirtCannon;
    private Timer reloadTimer;

    public ReloadTshirt(TshirtCannon tshirtCannon){
        this.tshirtCannon = tshirtCannon;
        addRequirements(tshirtCannon);
        reloadTimer = new Timer();
    }
    

    @Override
    public void initialize(){
        reloadTimer.start();
        tshirtCannon.extendReloadArm();
    }

    @Override
    public void execute(){
        
    }

    @Override
    public boolean isFinished(){
        if(reloadTimer.get()>=5){
            return true;
        }
        else return false;
    }

    @Override
    public void end(boolean interrupted){
        tshirtCannon.retractReloadArm();
        reloadTimer.stop();
        reloadTimer.reset();
    }
}
