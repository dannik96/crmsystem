package cz.cvut.fel.groscdan.crmsystem.controller;


import java.util.List;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/posts")
    public List<Post> getAllPosts(@RequestParam(required = false) String title) {
        return postService.getAll();
    }
}