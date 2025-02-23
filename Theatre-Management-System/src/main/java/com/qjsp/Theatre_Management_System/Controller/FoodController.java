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

import com.qjsp.Theatre_Management_System.Service.FoodService;
import com.qjsp.Theatre_Management_System.dto.Food;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("food/api")
public class FoodController {

	@Autowired
	public FoodService foodService;
	
//	http://localhost:8080/food/api
	@PostMapping
	public ResponseStructure<Food> saveFood(@RequestBody Food food) {
	
		return foodService.saveFood(food);
	}
	
//	http://localhost:8080/food/api/1
	@GetMapping ("{foodId}")
	public ResponseStructure<Food> fetchFoodById(@PathVariable("foodId") int foodId) {
		
		return foodService.fetchFoodById(foodId);
	}
	
//	http://localhost:8080/food/api/8
	@DeleteMapping("{foodId}")
	public ResponseStructure<Food> deleteFoodById(@PathVariable("foodId") int foodId) {
		
		return foodService.deleteFoodById(foodId);
	}
	
//	http://localhost:8080/food/api?foodId=3
	@PutMapping
	public ResponseStructure<Food> updateFoodById(@RequestParam int foodId,@RequestBody Food food) {
		return foodService.updateFoodById(foodId, food);
	}
	
//	http://localhost:8080/food/api
	@GetMapping
	public ResponseStructureList<Food> fetchAll() {
		return foodService.fetchAll();
	}
}
