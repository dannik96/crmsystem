package cz.cvut.fel.groscdan.crmsystem.controller;


import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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