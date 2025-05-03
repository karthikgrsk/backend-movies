package com.example.CINEMA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRespository reviewrespository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReviews(String reviewBody,String imdbId){

        Reviews review= reviewrespository.insert(new Reviews(reviewBody));

        mongoTemplate.update(Movies.class).
                matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();

        return review;
    }

}
