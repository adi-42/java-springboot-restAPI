package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRespository extends MongoRepository<Post,String> {


}
