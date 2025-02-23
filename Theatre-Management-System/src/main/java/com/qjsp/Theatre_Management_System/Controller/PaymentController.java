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

import com.qjsp.Theatre_Management_System.Service.PaymentService;
import com.qjsp.Theatre_Management_System.dto.Payment;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("payment/api")
public class PaymentController {

	@Autowired
	public PaymentService paymentService;
	
//	http://localhost:8080/payment/api
	@PostMapping
	public ResponseStructure<Payment> savePayment(@RequestBody Payment payment) {
	
		return paymentService.savePayment(payment);
	}
	
//	http://localhost:8080/payment/api/1
	@GetMapping ("{paymentId}")
	public ResponseStructure<Payment> fetchPaymentById(@PathVariable("paymentId") int paymentId) {
		
		return paymentService.fetchPaymentById(paymentId);
	}
	
//	http://localhost:8080/payment/api/8
	@DeleteMapping("{paymentId}")
	public ResponseStructure<Payment> deletePaymentById(@PathVariable("paymentId") int paymentId) {
		
		return paymentService.deletePaymentById(paymentId);
	}
	
//	http://localhost:8080/payment/api?paymentId=3
	@PutMapping
	public ResponseStructure<Payment> updatePaymentById(@RequestParam int paymentId,@RequestBody Payment payment) {
		return paymentService.updatePaymentById(paymentId, payment);
	}
	
//	http://localhost:8080/payment/api
	@GetMapping
	public ResponseStructureList<Payment> fetchAll() {
		return paymentService.fetchAll();
	}
	
}
