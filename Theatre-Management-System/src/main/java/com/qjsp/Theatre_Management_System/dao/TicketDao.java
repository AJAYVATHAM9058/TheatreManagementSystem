package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.TicketIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.TicketRepository;
import com.qjsp.Theatre_Management_System.dto.Ticket;

@Repository
public class TicketDao {

	@Autowired
	public TicketRepository ticketRepository;

	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Ticket fetchTicketById(int ticketId) {

		Optional<Ticket> optional = ticketRepository.findById(ticketId);
		if (optional.isEmpty()) {
			throw new TicketIdNotFound("No Ticket present with the given Id "+ticketId);
		} else {

			return ticketRepository.findById(ticketId).get();
		}
	}

	public Ticket deleteTicketById(int ticketId) {
		Ticket ticket = fetchTicketById(ticketId);
		ticketRepository.delete(ticket);
		return ticket;

	}

	public Ticket updateTicketById(int ticketId, Ticket ticket) {
		fetchTicketById(ticketId);
		ticket.setTicketId(ticketId);
		return saveTicket(ticket);

	}

	public List<Ticket> fetchAll() {
		return ticketRepository.findAll();
	}

}
