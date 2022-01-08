package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import static frc.robot.Constants.*;

public class TshirtCannon extends SubsystemBase{
    
    private final Solenoid releaseSolenoid = new Solenoid(pcmCanPort, releaseSolenoidPortNum);
    private final DoubleSolenoid reloadSolenoid = new DoubleSolenoid(pcmCanPort, reloadSolenoidPortNums1, reloadSolenoidPortNums2);
    private final Timer tshirtTimer = new Timer();
    //private final Timer offTimer = new Timer();
    private Boolean safety = false;

    public TshirtCannon(){
        reloadSolenoid.set(Value.kReverse);
    }

    public void shootTshirt(){
        System.out.println("fireing " + this.safety);
        if(safety){
            tshirtTimer.start();
            while(tshirtTimer.get()<0.25){
                releaseSolenoid.set(true);
            }
            tshirtTimer.stop();
            tshirtTimer.reset();
            releaseSolenoid.set(false);
        this.safety = false;
        }
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
        tshirtTimer.start();
        while(tshirtTimer.get()<5){
            this.extendReloadArm();
        }
        tshirtTimer.stop();
        tshirtTimer.reset();
        this.retractReloadArm();
    }

    public void safetyOff(){
        safety = true;
        System.out.println(safety);
    }

    public void safetyOn(){
        new WaitCommand(0.5);
        safety = false;
        System.out.println("therminated " + safety);
    }


}