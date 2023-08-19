package com.parkingapp.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.DialectOverride.GeneratedColumn;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "parkingapp")
public class Parking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Serial_No")
	private Integer sNo;
	@Column(name = "In_Date")
	private LocalDate inDate;
	@Size(min=1, message = "Vehicle type should be minimum of 1 chars")
	@Column(name = "Vehicle_Type", nullable = false)
	private String vehicleType;
	@Size(min=4, message = "Vehicle number should be minimum of 4 chars")
	@Column(name = "Vehicle_Number", nullable = false)
	private String vehicleNumber;
//	@JsonFormat(pattern = "hh:mm:ss")
	@Column(name = "In_Time")
	private LocalDateTime inTime;
//	@JsonFormat(pattern = "hh:mm:ss")
	@Column(name = "Out_Time")
	private LocalDateTime outTime;	
	@Column(name = "Time_Elapsed ")
	private Long timeElapsed;	
	@Column (name = "Amount")
	private Long amount;

}
