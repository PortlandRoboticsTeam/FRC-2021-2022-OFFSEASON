package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TshirtCannon;

public class ShootTshirt extends CommandBase{
    private final TshirtCannon tshirtCannon;

    public ShootTshirt(TshirtCannon tshirtCannon){
        this.tshirtCannon = tshirtCannon;
        addRequirements(tshirtCannon);
    }
    

    @Override
    public void initialize(){
        tshirtCannon.shootTshirt();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}