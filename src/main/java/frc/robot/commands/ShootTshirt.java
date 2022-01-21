package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TshirtCannon;
import edu.wpi.first.wpilibj.Timer;

public class ShootTshirt extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TshirtCannon tshirtCannon;
    private Timer fireTimer;

    public ShootTshirt(TshirtCannon tshirtCannon){
        this.tshirtCannon = tshirtCannon;
        addRequirements(tshirtCannon);
        fireTimer = new Timer();
    }
    

    @Override
    public void initialize(){
        fireTimer.start();
        System.out.println("fireing " + tshirtCannon.getSafety());
        if(tshirtCannon.getSafety()){
            tshirtCannon.setFireSolenoid(true);
        }
    }

    @Override
    public void execute(){

    }

    @Override
    public boolean isFinished(){
        if(fireTimer.get()>=0.25){
            return true;
        }
        else return false;
    }

    @Override
    public void end(boolean interrupted){
        tshirtCannon.setFireSolenoid(false);
        fireTimer.stop();
        fireTimer.reset();
    }
}
