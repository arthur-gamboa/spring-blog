package com.codeup.codeup_demo.controllers;

import com.codeup.codeup_demo.models.Ad;
import com.codeup.codeup_demo.models.Post;
import com.codeup.codeup_demo.repo.AdRepository;
import com.codeup.codeup_demo.repo.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {

    private final AdRepository adDao;

    AdController(AdRepository adDao) {

        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String seeAllAds(Model viewModel) {
        List<Ad> adsFromDB = adDao.findAll();
        viewModel.addAttribute("ads", adsFromDB);
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String showOneAd(@PathVariable long id, Model vModel) {
        vModel.addAttribute("ad", adDao.getOne(id));
        return "ads/show";
    }

    @GetMapping("/ads/create")
    @ResponseBody
    public String viewAdForm() {

        return "Here, you can ads posts.";
    }

    @PostMapping("/ads/create")
    @ResponseBody
    public String createAd(@RequestParam ("ad_title") String title, @RequestParam("ad_description") String description) {

        Ad adToSave = new Ad(title, description);
        adDao.save(adToSave);

        return "Submit your ads here.";
    }

    @GetMapping("/ads/${id}/update")
    public String updateAdForm(@PathVariable Long id, Model model) {

        Ad adFromDb = adDao.getOne(id);
        model.addAttribute("old ad", adFromDb);

        return "ads/update";

    }

    @PostMapping("/ads/${id}/update")
    @ResponseBody
    public String updateAd(@PathVariable Long id, @RequestParam ("ad_title") String title, @RequestParam("ad_description") String description) {

        Ad adToSave = new Ad(title, description);
        adDao.save(adToSave);

        return "Update your ads here.";
    }

    @PostMapping("/ads/${id}/delete")
    @ResponseBody
    public String deleteAd(@PathVariable Long id) {
        adDao.deleteById(id);
        return "You deleted an ad.";
    }

}
