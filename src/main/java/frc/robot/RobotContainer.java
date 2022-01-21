/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.EventImportance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import static frc.robot.Constants.*;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
    // Subsystem definitions
    private final Drivetrain drivetrain = new Drivetrain();
    private final TshirtCannon tshirtCannon = new TshirtCannon();
    //private final UltrasonicSensor distanceSensor = new UltrasonicSensor();

    //Command definitions
    private final AutoDrive simpleAutonomousCommand = new AutoDrive(drivetrain);

    //Joystick definitions
    public static Joystick m_stick = new Joystick(mStickPort);
    public static Joystick s_stick = new Joystick(sStickPort);

    //Chooser definitions
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    
    //The container for the robot.  Contains subsystems, OI devices, and commands.
    public RobotContainer() {
            // Set the scheduler to log Shuffleboard events for command initialize, interrupt, finish
        CommandScheduler.getInstance()
        .onCommandInitialize(
            command ->
                Shuffleboard.addEventMarker(
                    "Command initialized", command.getName(), EventImportance.kNormal));
        CommandScheduler.getInstance()
            .onCommandInterrupt(
                command ->
                    Shuffleboard.addEventMarker(
                        "Command interrupted", command.getName(), EventImportance.kNormal));
        CommandScheduler.getInstance()
            .onCommandFinish(
                command ->
                    Shuffleboard.addEventMarker(
                        "Command finished", command.getName(), EventImportance.kNormal));
        
        
        // Configure the button bindings
        configureButtonBindings();

        //Add options the autonomous chooser
        autoChooser.addOption("Autonomous Drive", simpleAutonomousCommand);

        // Put the chooser on the dashboard
        Shuffleboard.getTab("Autonomous").add(autoChooser);
        

        //Set driving mode
        drivetrain.setDefaultCommand(
                new DriveSlide(drivetrain,
                        () -> m_stick.getY(),
                        () -> m_stick.getX(),
                        () -> m_stick.getTwist(),
                        () -> m_stick.getThrottle(),
                        () -> m_stick.getTrigger()));
        

    }

    //Defines command-button mappings
    private void configureButtonBindings() {
        //Names buttons
        JoystickButton m_1 = new JoystickButton(m_stick, 1);
        JoystickButton m_2 = new JoystickButton(m_stick, 2);
        // JoystickButton m_3 = new JoystickButton(m_stick, 3);
        // JoystickButton m_4 = new JoystickButton(m_stick, 4);

        //JoystickButton s_1 = new JoystickButton(s_stick, 1);
        //Binds buttons

        m_1.whenPressed(new ShootTshirt(tshirtCannon));
        m_2.whenPressed(new SafetyOff(tshirtCannon));
        m_2.whenReleased(new SafetyOn(tshirtCannon));
        //m_3.whenPressed(new ReloadTshirt(tshirtCannon));
        //m_4.whenPressed(new ReleaseReloadArm(tshirtCannon));

    }

    //Return autonomus command to this function
    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}
