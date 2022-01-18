package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import static frc.robot.Constants.*;

public class TshirtCannon extends SubsystemBase{
    
    private final Solenoid releaseSolenoid = new Solenoid(pcmCanPort, releaseSolenoidPortNum);
    private final DoubleSolenoid reloadSolenoid = new DoubleSolenoid(pcmCanPort, reloadSolenoidPortNums1, reloadSolenoidPortNums2);
    private Boolean safety = false;

    public TshirtCannon(){
        reloadSolenoid.set(Value.kReverse);
    }

    public void shootTshirt(){
        System.out.println("fireing " + safety);
        if(safety){
            releaseSolenoid.set(true);
            new WaitCommand(0.25);
            releaseSolenoid.set(false);
        safety = false;
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
        extendReloadArm();
        new WaitCommand(5);
        retractReloadArm();
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