package in.putin.foodiesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.putin.foodiesapi.entity.CartEntity;

@Repository
public interface CartRepository extends MongoRepository<CartEntity ,String> {

}
