package com.qjsp.Theatre_Management_System.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qjsp.Theatre_Management_System.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	ResponseStructure<String> responseStructure;

	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseStructure<String> ownerIdNotFound(OwnerIdNotFound idNotFound) {

		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Owner Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());

		return responseStructure;
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> addressIdNotFound(AddressIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Address Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}

	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseStructure<String> branchIdNotFound(BranchIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Branch Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	
	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseStructure<String> foodIdNotFound(FoodIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Food Item Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseStructure<String> managerIdNotFound(ManagerIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Manager Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	
	@ExceptionHandler(MovieIdNotFound.class)
	public ResponseStructure<String> movieIdNotFound(MovieIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Movie Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseStructure<String> paymentIdNotFound(PaymentIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Payment Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	@ExceptionHandler(ReviewIdNotFound.class)
	public ResponseStructure<String> reviewIdNotFound(ReviewIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Review Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	@ExceptionHandler(ScreenIdNotFound.class)
	public ResponseStructure<String> screenIdNotFound(ScreenIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Screen Not Present in the Databased");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	@ExceptionHandler(SeatIdNotFound.class)
	public ResponseStructure<String> seatIdNotFound(SeatIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Seat Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	@ExceptionHandler(StaffIdNotFound.class)
	public ResponseStructure<String> staffIdNotFound(StaffIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Staff Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	@ExceptionHandler(TheatreIdNotFound.class)
	public ResponseStructure<String> theatreIdNotFound(TheatreIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Theatre Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	@ExceptionHandler(TicketIdNotFound.class)
	public ResponseStructure<String> ticketIdNotFound(TicketIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Ticket Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
	@ExceptionHandler(ViewerIdNotFound.class)
	public ResponseStructure<String> viewerIdNotFound(ViewerIdNotFound idNotFound) {
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Viewer Not Present in the Database");
		responseStructure.setData(idNotFound.getMessage());
		
		return responseStructure;
	}
	
}
