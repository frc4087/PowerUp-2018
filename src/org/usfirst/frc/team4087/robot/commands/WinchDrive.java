package org.usfirst.frc.team4087.robot.commands;


import org.usfirst.frc.team4087.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

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
		
		if (Robot.oi.getControlJoyYL()>0 || Robot.oi.getControlJoyYL()<0) {

		Robot.winch.winchControl(ControlMode.PercentOutput, Robot.oi.getControlJoyYL());
		
		}
		else {
			
						
		}
		

	}

	@Override
	protected boolean isFinished() {

		return false;
	}

	protected void interrupted() {
		end();
	}

}