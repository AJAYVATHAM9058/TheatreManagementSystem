package com.qjsp.Theatre_Management_System.util;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class ResponseStructure <T> {

	private int statusCode;
	private String message;
	private T data;
	
}
