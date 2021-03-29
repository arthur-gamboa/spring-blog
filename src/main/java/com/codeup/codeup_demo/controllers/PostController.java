package com.codeup.codeup_demo.controllers;

import com.codeup.codeup_demo.models.Post;
import com.codeup.codeup_demo.repo.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String seeAllPosts(Model viewModel) {
        List<Post> postsFromDB = postDao.findAll();
        viewModel.addAttribute("posts", postsFromDB);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", new Post("iPad", "Pro 11in"));
//        Post singlePost = postDao.getOne(id);
//        vModel.addAttribute("post", singlePost);
//        vModel.addAttribute("title", singlePost.getTitle());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPostForm() {
        return "Here, you can create posts.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Submit your posts here.";
    }

}
