package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.PaymentIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.PaymentRepository;
import com.qjsp.Theatre_Management_System.dto.Payment;

@Repository
public class PaymentDao {

	@Autowired
	public PaymentRepository paymentRepository;
	
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	public Payment fetchPaymentById(int paymentId) {

		Optional<Payment> optional = paymentRepository.findById(paymentId);
		if(optional.isEmpty()) {
			throw new PaymentIdNotFound("No Payment present with the given Id "+paymentId);
		}
		else {
			
			return paymentRepository.findById(paymentId).get();
		}
	}

	public Payment deletePaymentById(int paymentId) {
		Payment payment = fetchPaymentById(paymentId);
		paymentRepository.delete(payment);
		return payment;

	}

	public Payment updatePaymentById(int paymentId, Payment payment) {
		fetchPaymentById(paymentId);
		payment.setPaymentId(paymentId);
		return savePayment(payment);

	}
	
	public List<Payment> fetchAll(){
		return paymentRepository.findAll();
	}
	
}
