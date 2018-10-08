package org.usfirst.frc.team4087.robot.subsystems;

import org.usfirst.frc.team4087.robot.Robot;
import org.usfirst.frc.team4087.robot.RobotMap;
import org.usfirst.frc.team4087.robot.commands.WristDrive;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Wrist extends Subsystem {
	
	private TalonSRX WristMotor;
	
	
	private final int timeoutMS = 10;
	
	public final double W_UpperLimit = 6000;
	public final double W_LowerLimit = 0;
	private final double kP = 0.5;
	private final double kI = 1E-6;
	private final double kD = .0005;
	
	public Wrist() {
		
		WristMotor = new TalonSRX(RobotMap.WRIST.value);
		
		Robot.initTalon(WristMotor);
		
		WristMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, timeoutMS);
		WristMotor.setSensorPhase(false);
		WristMotor.config_kP(0, kP, timeoutMS);
		WristMotor.config_kI(0, kI, timeoutMS);
		WristMotor.config_kD(0, kD, timeoutMS);
		
	}
	
	public void wristControl(ControlMode mode, double target) {
		
		WristMotor.set(mode, target);

		
	}
	
	public double getWristPosition() {
		
		return WristMotor.getSelectedSensorPosition();
		
	}
	
	

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new WristDrive());
		
	}

}