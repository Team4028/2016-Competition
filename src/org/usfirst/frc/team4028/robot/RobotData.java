package org.usfirst.frc.team4028.robot;

import java.util.Date;

import org.usfirst.frc.team4028.robot.Constants.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


/* 
* This class contains the dynamic data while the robot is running in Auton or Teleop
* 	( and follows the DTO [Data Transfer Object] pattern )
* 
* It is used for:
* 	- collection of working data values used by Telop & Auton to control the robot
* 	- data logging to a text file (if enabled)
* 	- sending data to the ShartDashboard
* 
* It contains three (3) inner classes
* 	InputData		all real time data read from the robot (roboRio) 
* 	WorkingData		values calculated from the input data
* 	OutputData		values determined by code that will be pushed back to the robioRio to control motors & solenoids etc.
* 
* Date			Rev		Author						Comments
* -----------	------	-------------------------	---------------------------------- 
* 22.Aug.2015	0.2		Sebastian Rodriguez			Added new fields for Nav sensor
* 02.Aug.2015	0.1		Tom Bruns					Initial Version
*
*/
public class RobotData 
{
	// class constructor
	public RobotData()
	{
		this.InputDataValues = new InputData();
		this.WorkingDataValues = new WorkingData();
		this.OutputDataValues = new OutputData();
	}
	
	// properties
	public InputData InputDataValues;
	public WorkingData WorkingDataValues;
	public OutputData OutputDataValues;
	
	// build a TSV (Tab Separated Value) string for the header
	public String BuildTSVHeader()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(InputDataValues.BuildTSVHeader() + "\t");
		sb.append(WorkingDataValues.BuildTSVHeader() + "\t");	
		sb.append(OutputDataValues.BuildTSVHeader() + "\n");
		
		return sb.toString();
	}

	// build a TSV for the data values
	public String BuildTSVData()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(InputDataValues.BuildTSVData() + "\t");
		sb.append(WorkingDataValues.BuildTSVData() + "\t");	
		sb.append(OutputDataValues.BuildTSVData() + "\n");
		
		return sb.toString();
	}
	
	// internal class representing all of the Input data (sensors, driver station) used to control the robot
	public class InputData
	{
		public long FPGATimeMicroSecs;

		public boolean IsScaleDriveSpeedUpBtnPressed;			// logic will latch output value (so this acts like a single shot)
		public boolean IsScaleDriveSpeedDownBtnPressed;			// logic will latch output value (so this acts like a single shot)
		
		public boolean IsAlphaSolenoidOpenBtnPressed;
		public boolean IsAlphaSolenoidClosedBtnPressed;
		public boolean IsBetaSolenoidOpenBtnPressed;
		public boolean IsBetaSolenoidClosedBtnPressed;
 	
		public double ArcadeDriveThrottleRawCmd;
		public double ArcadeDriveTurnRawCmd;
		public double ShooterRawVelocityCmd;
		public double TurretRawVelocityCmd;
    	    	
		public double LeftDriveEncoderCurrentCount;	
		public double RightDriveEncoderCurrentCount;
		public double TurretEncoderCurrentCount;
		
		public boolean NavxIsConnected;
		public boolean NavxIsCalibrating;
		
		public float NavxYaw;
		public float NavxPitch;
		public float NavxRoll;
		public float NavxCompassHeading;
		public float NavxFusedHeading;
		public double NavxTotalYaw;
		public double NavxYawRateDPS;
		public float NavxAccelX;
		public float NavxAccelY;
		public boolean NavxIsMoving;
		public boolean NavxIsRotating;
		
		
		// build a TSV for the header
		public String BuildTSVHeader()
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append("InputData:FPGATimeMicroSecs" + "\t");
			sb.append("InputData:IsScaleDriveSpeedUpBtnPressed" + "\t");
			sb.append("InputData:IsScaleDriveSpeedDownBtnPressed" + "\t");
			sb.append("InputData:IsAlphaSolenoidOpenBtnPressed" + "\t");
			sb.append("InputData:IsAlphaSolenoidClosedBtnPressed" + "\t");
			sb.append("InputData:IsBetaSolenoidOpenBtnPressed" + "\t");
			sb.append("InputData:IsBetaSolenoidClosedBtnPressed" + "\t");
			sb.append("InputData:ArcadeDriveThrottleRawCmd" + "\t");
			sb.append("InputData:ArcadeDriveTurnRawCmd" + "\t");
			sb.append("InputData:ShooterRawVelocityCmd" + "\t");
			sb.append("InputData:TurretRawVelocityCmd" + "\t");
			sb.append("InputData:LeftDriveEncoderCurrentCount" + "\t");
			sb.append("InputData:RightDriveEncoderCurrentCount" + "\t");
			sb.append("InputData:TurretEncoderCurrentCount" + "\t");
			sb.append("InputData:NavxIsConnected" + "\t");
			sb.append("InputData:NavxIsCalibrated" + "\t");
			sb.append("InputData:NavxYaw" + "\t");
			sb.append("InputData:NavxPitch" + "\t");
			sb.append("InputData:NavxRoll" + "\t");
			sb.append("InputData:NavxCompassHeading" + "\t");
			sb.append("InputData:NavxFusedHeading" + "\t");
			sb.append("InputData:NavxTotalYaw" + "\t");
			sb.append("InputData:NavxYawRateDPS" + "\t");
			sb.append("InputData:NavxAccelX" + "\t");
			sb.append("InputData:NavxAccelY" + "\t");
			sb.append("InputData:NavxIsMoving" + "\t");
			sb.append("InputData:NavxIsRotating");
					
			return sb.toString();
		}
		
		// build a TSV for the data
		public String BuildTSVData()
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append(FPGATimeMicroSecs + "\t");
			sb.append(IsScaleDriveSpeedUpBtnPressed + "\t");
			sb.append(IsScaleDriveSpeedDownBtnPressed + "\t");
			sb.append(IsAlphaSolenoidOpenBtnPressed + "\t");
			sb.append(IsAlphaSolenoidClosedBtnPressed + "\t");
			sb.append(IsBetaSolenoidOpenBtnPressed + "\t");
			sb.append(IsBetaSolenoidClosedBtnPressed + "\t");
			sb.append(ArcadeDriveThrottleRawCmd + "\t");
			sb.append(ArcadeDriveTurnRawCmd + "\t");
			sb.append(ShooterRawVelocityCmd + "\t");
			sb.append(TurretRawVelocityCmd + "\t");
			sb.append(LeftDriveEncoderCurrentCount + "\t");
			sb.append(RightDriveEncoderCurrentCount + "\t");
			sb.append(TurretEncoderCurrentCount + "\t");
			sb.append(NavxIsConnected + "\t");
			sb.append(NavxIsCalibrating + "\t");
			sb.append(NavxYaw + "\t");
			sb.append(NavxPitch + "\t");
			sb.append(NavxRoll + "\t");
			sb.append(NavxCompassHeading + "\t");
			sb.append(NavxFusedHeading + "\t");
			sb.append(NavxTotalYaw + "\t");
			sb.append(NavxYawRateDPS + "\t");
			sb.append(NavxAccelX + "\t");
			sb.append(NavxAccelY + "\t");
			sb.append(NavxIsMoving + "\t");
			sb.append(NavxIsRotating);

			return sb.toString();
		}
	}
	
	// internal class representing all of the working data
	public class WorkingData
	{
		public boolean IsLoggingEnabled;
		public String LogFilePathName;
		public Date LoggingStartedDT;
		
		public Date LastScanDT;
		
		public boolean IsDriveSpeedScalingButtonPressedLastScan;
		public double DriveSpeedScalingFactor;			// min = 0.0, max = 1.0, 1.0 = 100%, 
		
		public double LeftDriveEncoderInitialCount;
		public double LeftDriveEncoderLastCount;
		public double LeftDriveEncoderLastDeltaCount;
		public double LeftDriveEncoderTotalDeltaCount;
		
		public double LeftDriveMotorCurrentRPM;
    	public double LeftDriveEncoderCurrentCPS;
    	public double LeftDriveGearBoxCurrentRPM;
    	public double LeftDriveWheelsCurrentSpeedIPS;
		
		public double RightDriveEncoderInitialCount;
		public double RightDriveEncoderLastCount;
		public double RightDriveEncoderLastDeltaCount;
		public double RightDriveEncoderTotalDeltaCount;
		
		public double RightDriveMotorCurrentRPM;
    	public double RightDriveEncoderCurrentCPS;
    	public double RightDriveGearBoxCurrentRPM;
    	public double RightDriveWheelsCurrentSpeedIPS;
		
    	public double TurretEncoderInitialCount;
    	public double TurretEncoderTotalDeltaCount;
    	public double TurretEncoderDegreesCount;
		// build a TSV for the header
		public String BuildTSVHeader()
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append("WorkingData:IsDriveSpeedScalingButtonPressedLastScan" + "\t");
			sb.append("WorkingData:DriveSpeedScalingFactor" + "\t");
			
			sb.append("WorkingData:LeftDriveEncoderInitialCount" + "\t");
			sb.append("WorkingData:LeftDriveEncoderLastCount" + "\t");
			sb.append("WorkingData:LeftDriveEncoderLastDeltaCount" + "\t");
			sb.append("WorkingData:LeftDriveEncoderTotalDeltaCount" + "\t");
			
			sb.append("WorkingData:LeftDriveMotorCurrentRPM" + "\t");
			sb.append("WorkingData:LeftDriveEncoderCurrentCPS" + "\t");
			sb.append("WorkingData:LeftDriveGearBoxCurrentRPM" + "\t");
			sb.append("WorkingData:LeftDriveWheelsCurrentSpeedIPS" + "\t");
			
			sb.append("WorkingData:RightDriveEncoderInitialCount" + "\t");
			sb.append("WorkingData:RightDriveEncoderLastCount" + "\t");
			sb.append("WorkingData:RightDriveEncoderLastDeltaCount" + "\t");
			sb.append("WorkingData:RightDriveEncoderTotalDeltaCount" + "\t");
			
			sb.append("WorkingData:RightDriveMotorCurrentRPM" + "\t");
			sb.append("WorkingData:RightDriveEncoderCurrentCPS" + "\t");
			sb.append("WorkingData:RightDriveGearBoxCurrentRPM" + "\t");
			sb.append("WorkingData:RightDriveWheelsCurrentSpeedIPS" + "\t");
			
			sb.append("WorkingData:TurretEncoderInitialCount" + "\t");
			sb.append("WorkingData:TurretEncoderTotalDeltaCount" + "\t");
			sb.append("WorkingData:TurretEncoderDegreesCount");
					
			return sb.toString();
		}
		
		// build a TSV for the data
		public String BuildTSVData()
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append(IsDriveSpeedScalingButtonPressedLastScan + "\t");
			sb.append(DriveSpeedScalingFactor + "\t");
			
			sb.append(LeftDriveEncoderInitialCount + "\t");
			sb.append(LeftDriveEncoderLastCount + "\t");
			sb.append(LeftDriveEncoderLastDeltaCount + "\t");
			sb.append(LeftDriveEncoderTotalDeltaCount + "\t");
			
			sb.append(LeftDriveMotorCurrentRPM + "\t");
			sb.append(LeftDriveEncoderCurrentCPS + "\t");
			sb.append(LeftDriveGearBoxCurrentRPM + "\t");
			sb.append(LeftDriveWheelsCurrentSpeedIPS + "\t");
			
			sb.append(RightDriveEncoderInitialCount + "\t");
			sb.append(RightDriveEncoderLastCount + "\t");
			sb.append(RightDriveEncoderLastDeltaCount + "\t");
			sb.append(RightDriveEncoderTotalDeltaCount + "\t");
			
			sb.append(RightDriveMotorCurrentRPM + "\t");
			sb.append(RightDriveEncoderCurrentCPS + "\t");
			sb.append(RightDriveGearBoxCurrentRPM + "\t");
			sb.append(RightDriveWheelsCurrentSpeedIPS + "\t");
			
			sb.append(TurretEncoderInitialCount + "\t");
			sb.append(TurretEncoderTotalDeltaCount);
					
			return sb.toString();
		}
	}
	
	// internal class representing all of the Motor Output Data used to control the robot
	public class OutputData
	{
		public double ArcadeDriveThrottleAdjCmd;
		public double ArcadeDriveTurnAdjCmd;
		public double TurretAdjVelocityCmd;
		public double GammaMtrVelocityCmd;
		public double DeltaMtrVelocityCmd;
		
		public Value AlphaSolenoidPosition;
		public Value BetaSolenoidPosition;

		public String DriversStationMsg;
		
		// build a TSV for the header
		public String BuildTSVHeader()
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append("OutputData:ArcadeDriveAdjThrottleCmd" + "\t");
			sb.append("OutputData:ArcadeDriveAdjTurnCmd" + "\t");
			sb.append("OutputData:TurretAdjVeloctyCmd" + "\t");
			sb.append("OutputData:GammaMtrVelocityCmd" + "\t");
			sb.append("OutputData:DeltaMtrVelocityCmd" + "\t");
			sb.append("OutputData:AlphaSolenloidPosition" + "\t");
			sb.append("OutputData:BetaSolenoidPosition" + "\t");
			sb.append("OutputData:DriversStationMsg");
			
					
			return sb.toString();
		}
		
		// build a TSV for the data
		public String BuildTSVData()
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append(ArcadeDriveThrottleAdjCmd + "\t");
			sb.append(ArcadeDriveTurnAdjCmd + "\t");
			sb.append(TurretAdjVelocityCmd + "\t");
			sb.append(GammaMtrVelocityCmd + "\t");
			sb.append(DeltaMtrVelocityCmd + "\t");
			sb.append(DriversStationMsg);
			
			String alphaSolenoidPositionDesc = "";
			if (AlphaSolenoidPosition == RobotMap.ALPHA_SOLENOID_OPEN_POSITION)
			{
				alphaSolenoidPositionDesc = "ALPHA_SOLENOID_OPEN";
			}
			else if (AlphaSolenoidPosition == RobotMap.ALPHA_SOLENOID_CLOSED_POSITION)
			{
				alphaSolenoidPositionDesc = "ALPHA_SOLENOID_CLOSED";
			}
			else
			{
				alphaSolenoidPositionDesc = "UNKNOWN";
			}
			
			String betaSolenoidPositionDesc = "";
			if (BetaSolenoidPosition == RobotMap.BETA_SOLENOID_OPEN_POSITION)
			{
				betaSolenoidPositionDesc = "FRONT_CLIPS_OPEN";
			}
			else if (BetaSolenoidPosition == RobotMap.BETA_SOLENOID_CLOSED_POSITION)
			{
				betaSolenoidPositionDesc = "FRONT_CLIPS_CLOSED";
			}
			else
			{
				betaSolenoidPositionDesc = "UNKNOWN";
			}
			
			sb.append(alphaSolenoidPositionDesc + "\t");
			sb.append(betaSolenoidPositionDesc + "\t");
					
			return sb.toString();
		}
	}
}