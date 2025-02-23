package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.PaymentDao;
import com.qjsp.Theatre_Management_System.dto.Payment;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class PaymentService {

	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	ResponseStructure<Payment> responseStructure;

	@Autowired
	ResponseStructureList<Payment> responseStructureList;

	public ResponseStructure<Payment> savePayment(Payment payment) {

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Payment Data Inserted into DataBase");
		responseStructure.setData(paymentDao.savePayment(payment));
		return responseStructure;

	}

	public ResponseStructure<Payment> deletePaymentById(int paymentId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Payment Data Deleted From DataBase");
		responseStructure.setData(paymentDao.deletePaymentById(paymentId));
		return responseStructure;
	}

	public ResponseStructure<Payment> fetchPaymentById(int paymentId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Payment Data Retrieved from DataBase");
		responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
		return responseStructure;
	}

	public ResponseStructure<Payment> updatePaymentById(int paymentId, Payment payment) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Payment Data Updated From DataBase");
		responseStructure.setData(paymentDao.updatePaymentById(paymentId, payment));
		return responseStructure;
	}

	public ResponseStructureList<Payment> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Payments from Database");
		responseStructureList.setData(paymentDao.fetchAll());

		return responseStructureList;
	}
}
