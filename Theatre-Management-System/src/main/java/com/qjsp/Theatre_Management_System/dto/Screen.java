package com.qjsp.Theatre_Management_System.dto;

import java.sql.Time;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int screenId;
	private String screenType;
	private String screenSize;
	private Time screenStartTime;
	private Time screenEndTime;
	private String screenNumber;
	private String screenAudioType;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Seat> seats;
	
	@OneToOne
	@Cascade (CascadeType.ALL)
	private Movie movie;
	
}
