package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.FoodIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.FoodRepository;
import com.qjsp.Theatre_Management_System.dto.Food;

@Repository
public class FoodDao {

	@Autowired
	public FoodRepository foodRepository;
	
	public Food saveFood(Food food) {
		return foodRepository.save(food);
	}
	
	public Food fetchFoodById(int foodId) {
		Optional<Food> optional = foodRepository.findById(foodId);
		if(optional.isEmpty()) {
			throw new FoodIdNotFound("No Food present with the given Id "+foodId);
		}
		else {
			
			return foodRepository.findById(foodId).get();
		}
	}

	public Food deleteFoodById(int foodId) {
		Food food = fetchFoodById(foodId);
		foodRepository.delete(food);
		return food;

	}

	public Food updateFoodById(int foodId, Food food) {
		fetchFoodById(foodId);
		food.setFoodId(foodId);
		return saveFood(food);

	}
	
	public List<Food> fetchAll(){
		return foodRepository.findAll();
	}
	
}
