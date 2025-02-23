package com.qjsp.Theatre_Management_System.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketIdNotFound extends RuntimeException{
	private String message;
}
