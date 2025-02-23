package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.PaymentDao;
import com.qjsp.Theatre_Management_System.dao.TicketDao;
import com.qjsp.Theatre_Management_System.dto.Payment;
import com.qjsp.Theatre_Management_System.dto.Ticket;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	ResponseStructure<Ticket> responseStructure;

	@Autowired
	ResponseStructureList<Ticket> responseStructureList;

	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Ticket Data Inserted into DataBase");
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return responseStructure;

	}

	public ResponseStructure<Ticket> deleteTicketById(int ticketId) {
		Ticket ticket = ticketDao.deleteTicketById(ticketId);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket Data Deleted From DataBase");
		responseStructure.setData(ticketDao.deleteTicketById(ticketId));
		return responseStructure;
	}

	public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Ticket Data Retrieved from DataBase");
		responseStructure.setData(ticketDao.fetchTicketById(ticketId));
		return responseStructure;
	}

	public ResponseStructure<Ticket> updateTicketById(int ticketId, Ticket ticket) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket Data Updated From DataBase");
		responseStructure.setData(ticketDao.updateTicketById(ticketId, ticket));
		return responseStructure;
	}

	public ResponseStructureList<Ticket> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Tickets from Database");
		responseStructureList.setData(ticketDao.fetchAll());

		return responseStructureList;
	}

//	Adding Existing Payment to Ticket
	public Ticket mapExistingPaymentToTicket(int paymentId, int ticketId) {

		Payment payment = paymentDao.fetchPaymentById(paymentId);
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		ticket.setPayment(payment);

		return ticketDao.saveTicket(ticket);
	}

}
