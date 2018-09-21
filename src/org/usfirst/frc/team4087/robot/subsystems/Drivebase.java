package org.usfirst.frc.team4087.robot.subsystems;

import org.usfirst.frc.team4087.robot.Robot;
import org.usfirst.frc.team4087.robot.RobotMap;
import org.usfirst.frc.team4087.robot.commands.CheesyDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivebase extends Subsystem {
	private TalonSRX LeftMotor;
	private TalonSRX LeftMotorSlave;
	private TalonSRX RightMotor;
	private TalonSRX RightMotorSlave;

	public Drivebase() {
		LeftMotor = new TalonSRX(RobotMap.LEFT_MOTOR.value);
		RightMotor = new TalonSRX(RobotMap.RIGHT_MOTOR.value);
		LeftMotorSlave = new TalonSRX(RobotMap.LEFT_SLAVE.value);
		RightMotorSlave = new TalonSRX(RobotMap.RIGHT_SLAVE.value);
		
		Robot.initTalon(LeftMotor);
		Robot.initTalon(LeftMotorSlave);
		Robot.initTalon(RightMotor);
		Robot.initTalon(RightMotorSlave);
		
		LeftMotorSlave.follow(LeftMotor);
		RightMotorSlave.follow(RightMotor);
	}

	public void set(ControlMode mode, double leftvalue, double rightvalue) {
		
		LeftMotor.set(mode, leftvalue);
		RightMotor.set(mode, rightvalue);
		
	}
	
	public void curvatureDrive(ControlMode mode, double leftvalue, double rightvalue) {
		
		LeftMotor.set(mode, leftvalue);
		RightMotor.set(mode,  rightvalue);
	}
	
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new CheesyDrive());

	}


}
