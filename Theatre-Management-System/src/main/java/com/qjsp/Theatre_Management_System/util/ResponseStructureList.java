package com.qjsp.Theatre_Management_System.util;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructureList<T> {

	private int statusCode;
	private String message;
	private List<T> data;
}
