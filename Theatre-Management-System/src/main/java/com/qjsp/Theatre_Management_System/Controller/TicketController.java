package com.qjsp.Theatre_Management_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qjsp.Theatre_Management_System.Service.TicketService;
import com.qjsp.Theatre_Management_System.dto.Ticket;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("ticket/api")
public class TicketController {

	@Autowired
	public TicketService ticketService;

//	http://localhost:8080/ticket/api
	@PostMapping
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {

		return ticketService.saveTicket(ticket);
	}

//	http://localhost:8080/ticket/api/1
	@GetMapping("{ticketId}")
	public ResponseStructure<Ticket> fetchTicketById(@PathVariable("ticketId") int ticketId) {

		return ticketService.fetchTicketById(ticketId);
	}

//	http://localhost:8080/ticket/api/8
	@DeleteMapping("{ticketId}")
	public ResponseStructure<Ticket> deleteTicketById(@PathVariable("ticketId") int ticketId) {

		return ticketService.deleteTicketById(ticketId);
	}

//	http://localhost:8080/ticket/api?ticketId=3
	@PutMapping
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int ticketId, @RequestBody Ticket ticket) {
		return ticketService.updateTicketById(ticketId, ticket);
	}

//	http://localhost:8080/ticket/api
	@GetMapping
	public ResponseStructureList<Ticket> fetchAll() {
		return ticketService.fetchAll();
	}
	
//	Adding existing payment to ticket
//	http://localhost:8080/ticket/api/mapExistingPaymentToTicket/2/1
	@PutMapping("mapExistingPaymentToTicket/{paymentId}/{ticketId}")
	public Ticket mapExistingPaymentToTicket(@PathVariable int paymentId,@PathVariable int ticketId) {
		return ticketService.mapExistingPaymentToTicket(paymentId, ticketId);
	}
	

}
