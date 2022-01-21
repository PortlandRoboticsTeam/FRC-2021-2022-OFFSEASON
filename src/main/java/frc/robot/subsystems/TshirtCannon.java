package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import static frc.robot.Constants.*;

public class TshirtCannon extends SubsystemBase{
    
    private final Solenoid releaseSolenoid = new Solenoid(pcmCanPort, releaseSolenoidPortNum);
    //private final DoubleSolenoid reloadSolenoid = new DoubleSolenoid(pcmCanPort, reloadSolenoidPortNums1, reloadSolenoidPortNums2);
    private Boolean safety = false;

    public TshirtCannon(){
        //reloadSolenoid.set(Value.kReverse);
    }


    public void setFireSolenoid(Boolean fireState){
        releaseSolenoid.set(fireState);
    }

    public void extendReloadArm(){
        //reloadSolenoid.set(Value.kForward);
    }

    public void retractReloadArm(){
        //reloadSolenoid.set(Value.kReverse);
    }

    public void releaseReloadArm(){
        //reloadSolenoid.set(Value.kOff);
    }

    public void safetySet(Boolean safetyState){
        safety = safetyState;
    }

    public Boolean getSafety(){
        return safety;
    }


}