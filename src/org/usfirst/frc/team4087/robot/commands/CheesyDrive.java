package org.usfirst.frc.team4087.robot.commands;

import org.usfirst.frc.team4087.robot.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class CheesyDrive extends Command {

	public CheesyDrive() {
		requires(Robot.drivebase);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		double throttle = (1.0 - Robot.oi.DRIVE_JOY.getThrottle() / -2.0);
		
		Robot.drivebase.curvatureDrive(ControlMode.PercentOutput, Robot.oi.getLeftJoyY() * throttle,Robot.oi.getLeftJoyX() * throttle);
		
		//new comment
	}
	@Override
	protected boolean isFinished() {
		
		return false;
	}
	
	protected void interrupted() {
		end();
	}

}
