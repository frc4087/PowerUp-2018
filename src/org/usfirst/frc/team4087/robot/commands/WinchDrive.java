package org.usfirst.frc.team4087.robot.commands;

import java.io.Console;

import org.usfirst.frc.team4087.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WinchDrive extends Command {

	public final double W_UpperLimit = -35000;
	public final double W_LowerLimit = 0;
	static double setpoint = 0;

	public WinchDrive() {
		requires(Robot.winch);
	}

	protected void initialize() {

	}

	protected void execute() {
		
		setpoint =+ (Robot.oi.getControlJoyYL()) * -800;
		Robot.winch.winchPID(ControlMode.Position, setpoint);

	}

	@Override
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}

}