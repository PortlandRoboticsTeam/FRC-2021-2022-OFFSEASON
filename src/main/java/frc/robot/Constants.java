/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    //Example constant definition
    public static final int teamNumber = 7195;

    //CAN port numberings
    public static final int wheel1PortNum = 2;  //front right
    public static final int wheel2PortNum = 1;  //rear right
    public static final int wheel3PortNum = 4;  //front left
    public static final int wheel4PortNum = 3;  //rear left
    public static final int wheel5PortNum = 5;  //center one
    public static final int wheel6PortNum = 6;  //center two

    public static final int elevatorLiftPortNum = 10;
    public static final int elevatorHookPortNum = 7;
    public static final int elevatorDownPortNum = 12;
    public static final int intakePortNum = 0;
    public static final int shooterBottomPortNum = 11;
    public static final int shooterTopPortNum = 8;
    public static final int wheelSpinnerPortNum = 9;

    public static int shootSolenoidPortNum = 0;                             //port number for the single solenoid in charge of releasing pressure in the t-shirt cannon
    public static final int[] reloadSolenoidPortNums = new int[] {1,2};     //port numbers for the double solenoid in charge of extending and retarcting the reload mechanism

    //A:7 B:8 C:9 D:10, E:11, F:12

    //USB Port Numberings
    public static final int mStickPort = 0;
    public static final int sStickPort = 1;

}