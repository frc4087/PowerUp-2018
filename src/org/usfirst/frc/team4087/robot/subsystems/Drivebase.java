package org.usfirst.frc.team4087.robot.subsystems;

import org.usfirst.frc.team4087.robot.Robot;
import org.usfirst.frc.team4087.robot.RobotMap;
import org.usfirst.frc.team4087.robot.commands.CheesyDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivebase extends Subsystem implements PIDOutput {
	private TalonSRX LeftMotor;
	private TalonSRX LeftMotorSlave;
	private TalonSRX RightMotor;
	private TalonSRX RightMotorSlave;
	private final AHRS ahrs;

	private final double kP = 0;
	private final double kI = 0;
	private final double kD = 0;

	public final PIDController turnController;

	public Drivebase() {
		LeftMotor = new TalonSRX(RobotMap.LEFT_MOTOR.value);
		RightMotor = new TalonSRX(RobotMap.RIGHT_MOTOR.value);
		LeftMotorSlave = new TalonSRX(RobotMap.LEFT_SLAVE.value);
		RightMotorSlave = new TalonSRX(RobotMap.RIGHT_SLAVE.value);
		ahrs = new AHRS(SPI.Port.kMXP);

		Robot.initTalon(LeftMotor);
		Robot.initTalon(LeftMotorSlave);
		Robot.initTalon(RightMotor);
		Robot.initTalon(RightMotorSlave);

		LeftMotorSlave.follow(LeftMotor);
		RightMotorSlave.follow(RightMotor);

		turnController = new PIDController(kP, kI, kD, ahrs, this);
		turnController.setInputRange(-180f, 180f);
		turnController.setOutputRange(-0.45, 0.45);
		turnController.setAbsoluteTolerance(2.0f);
		turnController.setContinuous();

	}

	public void rotateDegrees(double angle) {
		ahrs.reset();
		turnController.reset();
		turnController.setPID(kP, kI, kD);
		turnController.setSetpoint(angle);
		turnController.enable();
	}

	public void curvatureDrive(ControlMode mode, double leftvalue, double rightvalue) {

		LeftMotor.set(mode, leftvalue);
		RightMotor.set(mode, rightvalue);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new CheesyDrive());

	}

	@Override
	public void pidWrite(double output) {
		curvatureDrive(ControlMode.PercentOutput, -output, output);

	}

}
