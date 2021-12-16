package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import static frc.robot.Constants.*;


public class TshirtCannon extends SubsystemBase{
    private final Solenoid releaseSolenoid = new Solenoid(frc.robot.Constants.shootSolenoidPortNum);
    private final DoubleSolenoid reloadSolenoid = new DoubleSolenoid(reloadSolenoidPortNums[0], reloadSolenoidPortNums[1]);
    private final Timer timer = new Timer();

    public TshirtCannon(){
        reloadSolenoid.set(Value.kReverse);
    }

    public void shootTshirt(){
        timer.start();
        while(timer.get()<0.5){
            releaseSolenoid.set(true);
        }
        timer.stop();
        timer.reset();
        releaseSolenoid.set(false);
    }

    public void extendReloadArm(){
        reloadSolenoid.set(Value.kForward);
    }

    public void retractReloadArm(){
        reloadSolenoid.set(Value.kReverse);
    }

    public void releaseReloadArm(){
        reloadSolenoid.set(Value.kOff);
    }

    public void reload(){
        timer.start();
        while(timer.get()<5){
            this.extendReloadArm();
        }
        timer.stop();
        timer.reset();
        this.retractReloadArm();
    }
}