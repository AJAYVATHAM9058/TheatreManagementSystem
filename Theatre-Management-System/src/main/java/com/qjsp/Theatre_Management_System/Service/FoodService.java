package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.FoodDao;
import com.qjsp.Theatre_Management_System.dto.Food;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class FoodService {

	@Autowired
	public FoodDao foodDao;
	
	@Autowired
	ResponseStructure<Food> responseStructure;
	
	@Autowired
	ResponseStructureList<Food> responseStructureList;
	
	public ResponseStructure<Food> saveFood(Food food) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Food Data Inserted into DataBase");
		responseStructure.setData(foodDao.saveFood(food));

		return responseStructure;
		
	}
	
	public ResponseStructure<Food> fetchFoodById(int foodId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Food Data Retrieved from DataBase");
		responseStructure.setData(foodDao.fetchFoodById(foodId));
		return responseStructure;
	}
	
	public ResponseStructure<Food> deleteFoodById(int foodId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Food Data Deleted From DataBase");
		responseStructure.setData(foodDao.deleteFoodById(foodId));
		return responseStructure;
	}
	
	public ResponseStructure<Food> updateFoodById(int foodId,Food food) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Food Data Updated From DataBase");
		responseStructure.setData(foodDao.updateFoodById(foodId, food));
		return responseStructure;
	}
	
	public ResponseStructureList<Food> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Food Items from Database");
		responseStructureList.setData(foodDao.fetchAll());

		return responseStructureList;
	}
}
