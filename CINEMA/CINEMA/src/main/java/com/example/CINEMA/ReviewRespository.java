package com.example.CINEMA;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRespository extends MongoRepository<Reviews, ObjectId> {
}
