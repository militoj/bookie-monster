package org.launchcode.controllers;

import org.launchcode.models.Book;
import org.launchcode.models.BookFieldType;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    private JobData jobData = JobData.getInstance();

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute(new SearchForm());
        return "search";
    }

    @RequestMapping(value = "results")
    public String search(Model model,
                         @ModelAttribute SearchForm searchForm) {

        ArrayList<Book> books;

        if (searchForm.getSearchField().equals(BookFieldType.ALL)) {
            books = jobData.findByValue(searchForm.getKeyword());
        } else {
            books = jobData.findByColumnAndValue(searchForm.getSearchField(), searchForm.getKeyword());
        }

        model.addAttribute("books", books);

        return "search";
    }

}
