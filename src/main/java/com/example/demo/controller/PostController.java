package com.example.demo.controller;

import com.example.demo.repository.PostRespository;
import com.example.demo.model.Post;
import com.example.demo.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRespository repo;

    @Autowired
    SearchRepository srepo;

    //GET Requests
    @GetMapping(value="/posts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    //POST Requests
    @PostMapping(value="/post/addPost")
    public Post addPosts(@RequestBody Post[] posts){
        System.out.println(posts[0]);
        for(Post post : posts){
            repo.save(post);
        }
        return new Post("API Request Successful", "Saved post(s)");
    }

    //PUT Requests
    @PutMapping("/post/update/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post updatedPost) {
        repo.findById(id).map(post -> {
            post.setType(updatedPost.getType());
            post.setDesc(updatedPost.getDesc());
            return repo.save(post);
        }).orElseGet(() -> {
            updatedPost.setId(id);
            return repo.save(updatedPost);
        });
        return new Post("API Request Successful", "Updated post(s)");
    }


    //DELETE Requests
    @DeleteMapping("/post/delSingle")
    public Post deletePosts(@RequestBody String[] ids){
        for(String id : ids){
            repo.deleteById(id);
        }
        return new Post("API Request Successful", "Deleted post(s)");
    }

    @DeleteMapping("/posts/deleteAll")
    public Post deleteAll(){
        repo.deleteAll();
        return new Post("API Request Successful", "Cleared Database");
    }


}
