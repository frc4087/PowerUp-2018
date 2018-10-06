package org.usfirst.frc.team4087.robot.subsystems;

import org.usfirst.frc.team4087.robot.Robot;
import org.usfirst.frc.team4087.robot.RobotMap;
import org.usfirst.frc.team4087.robot.commands.WinchDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {
	
	private TalonSRX W_Master;
	private TalonSRX W_Slave;
	
	
	private final int timeoutMS = 10;
	
	public final double W_UpperLimit = 35000;
	public final double W_LowerLimit = 0;
	private final double kP = 0.5;
	private final double kI = 1E-5;
	private final double kD = 1E-5;
	
	public Winch() {
		
		W_Master = new TalonSRX(RobotMap.WINCH_MASTER.value);
		W_Slave = new TalonSRX(RobotMap.WINCH_SLAVE.value);
		
		Robot.initTalon(W_Master);
		Robot.initTalon(W_Slave);		
		
		W_Slave.follow(W_Master);
		
		W_Master.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, timeoutMS);
		W_Master.setSensorPhase(true);
		W_Master.config_kP(0, kP, timeoutMS);
		W_Master.config_kI(0, kI, timeoutMS);
		W_Master.config_kD(0, kD, timeoutMS);
		
	}
	
	public void winchControl(ControlMode mode, double target) {
		
		W_Master.set(mode, target);

		
	}
	
	public double getWinchPosition() {
		
		return W_Master.getSelectedSensorPosition(0);
		
	}
	
	

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new WinchDrive());
		
	}

}