package com.codeup.codeup_demo.controllers;

import com.codeup.codeup_demo.models.Post;
import com.codeup.codeup_demo.models.User;
import com.codeup.codeup_demo.repo.PostRepository;
import com.codeup.codeup_demo.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String seeAllPosts(Model viewModel) {
        List<Post> postsFromDB = postDao.findAll();
        viewModel.addAttribute("posts", postsFromDB);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable Long id, Model vModel) {
        vModel.addAttribute("post", postDao.getOne(id));
//        Post singlePost = postDao.getOne(id);
//        vModel.addAttribute("post", singlePost);
//        vModel.addAttribute("title", singlePost.getTitle());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewPostForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@ModelAttribute Post postToSave) {
//        Post postToSave = new Post();
        User userToAdd = userDao.getOne(2L);

//        // Setting title here
//        postToSave.setTitle(post_title);
//
//        // Setting body here
//        postToSave.setBody(body);

        // Setting user here
        postToSave.setOwner(userToAdd);

        // Save posts here
        postDao.save(postToSave);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(Model vModel, @PathVariable Long id) {
        vModel.addAttribute("post", postDao.getOne(id));
        return "posts/create";
    }

    @PostMapping("/posts/{id}/edit")
    @ResponseBody
    public String editPost(@ModelAttribute Post postToUpdate, @PathVariable Long id) {

        User userToAdd = userDao.getOne(2L);

        postToUpdate.setId(id);

        postToUpdate.setOwner(userToAdd);
        postDao.save(postToUpdate);

        return "redirect:/posts";
    }

}
