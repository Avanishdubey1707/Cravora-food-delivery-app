package in.putin.foodiesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.putin.foodiesapi.entity.FoodEntity;
@Repository
public interface FoodRespository extends MongoRepository<FoodEntity,String> {

}
