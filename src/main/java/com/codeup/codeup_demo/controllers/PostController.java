package com.codeup.codeup_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String seeAllPosts() {
        return "All posts will display here.";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showPost(@PathVariable int id) {
        return "You will see a post with the ID of " + id + ".";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPostForm() {
        return "Here, you can create posts.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "Submit your posts here.";
    }

}
