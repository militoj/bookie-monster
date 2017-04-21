package org.launchcode.controllers;

import org.launchcode.models.Book;
import org.launchcode.models.BookField;
import org.launchcode.models.BookFieldType;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "list")
public class ListController {

    private JobData jobData = JobData.getInstance();

    @RequestMapping(value = "")
    public String list(Model model) {
        BookFieldType[] fields = BookFieldType.values();
        model.addAttribute("fields", fields);
        return "list";
    }

    @RequestMapping(value = "values")
    public String listColumnValues(Model model, @RequestParam BookFieldType column) {

        if (column.equals(BookFieldType.ALL)) {
            return "redirect:/list/all";
        }


        ArrayList<? extends BookField> items;

        switch(column) {
            case ISBN:
                items = jobData.getEmployers().findAll();
                break;
            case LOCATION:
                items = jobData.getLocations().findAll();
                break;
            case CORE_COMPETENCY:
                items = jobData.getCoreCompetencies().findAll();
                break;
            case POSITION_TYPE:
            default:
                items = jobData.getPositionTypes().findAll();
        }

        model.addAttribute("title", "All " + column.getName() + " Values");
        model.addAttribute("column", column);
        model.addAttribute("items", items);

        return "list-column";
    }

    @RequestMapping(value = "jobs")
    public String listJobsByColumnAndValue(Model model,
                                           @RequestParam BookFieldType column, @RequestParam String name) {

        ArrayList<Book> books = jobData.findByColumnAndValue(column, name);

        model.addAttribute("title", "Jobs with " + column.getName() + ": " + name);
        model.addAttribute("books", books);

        return "list-books";
    }

    @RequestMapping(value = "all")
    public String listAllJobs(Model model) {

        ArrayList<Book> books = jobData.findAll();

        model.addAttribute("title", "All Jobs");
        model.addAttribute("books", books);

        return "list-books";
    }
}
