/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4087.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	public static final double JOY_DEADZONE = 0.05;

	public final Joystick DRIVE_JOY = new Joystick(RobotMap.DRIVE_JOYSTICK.value);
	public final Joystick CONTROL_JOY = new Joystick(RobotMap.CONTROL_JOYSTICK.value);

	/*
	Axis indexes:
	0 - LeftX
	1 - LeftY
	2,3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
	4 - RightX
	5 - RightY
	6 - DPad Left/Right

	Button mapping matches Windows Control Panel>Game Pads display 
	 */
	
	public double getDriveJoyXL() {
		double raw = DRIVE_JOY.getRawAxis(0);
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getDriveJoyYL() {
		double raw = DRIVE_JOY.getRawAxis(1);
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getDriveJoyXR() {
		double raw = DRIVE_JOY.getRawAxis(4);
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getDriveJoyYR() {
		double raw = DRIVE_JOY.getRawAxis(5);
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getControlJoyXL() {
		double raw = CONTROL_JOY.getRawAxis(0);
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getControlJoyYL() {
		double raw = CONTROL_JOY.getRawAxis(1);
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getControlJoyXR() {
		double raw = CONTROL_JOY.getRawAxis(4);
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getControlJoyYR() {
		double raw = CONTROL_JOY.getRawAxis(5);
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public OI() {

	}
}
