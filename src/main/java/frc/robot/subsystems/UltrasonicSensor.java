package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;

import static frc.robot.Constants.*;

public class UltrasonicSensor extends SubsystemBase{
    private double volt;
    private double distance;
    private final AnalogInput rangeFinder = new AnalogInput(ultrasonicSensorPortNum);

    public UltrasonicSensor(){
        
    }

    public double getRange(){
        volt = rangeFinder.getVoltage();
        distance = 5*volt/0.004883;
        System.out.println(distance);
        
        return distance;
    }

}
