package org.launchcode.controllers;

import org.launchcode.models.*;
import org.launchcode.models.data.BookFieldData;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Book at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Book with the given ID and pass it into the view
        model.addAttribute("job", jobData.findById(id));
        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Book and add it to the jobData data store. Then
        // redirect to the book detail view for the new Book.

        if (errors.hasErrors()) {
            //model.addAttribute(new JobForm());
            return "new-book";
        }

        BookFieldData<Employer> newEmployer = jobData.getEmployers();
        Employer foundEmployer = newEmployer.findById(jobForm.getEmployerId());

        Quantity foundQuantity = jobData.getLocations().findById(jobForm.getLocationId());

        Price foundPrice = jobData.getPositionTypes().findById(jobForm.getPositionTypeId());

        DateCreated foundDateCreated = jobData.getCoreCompetencies().findById(jobForm.getCoreCompetencyId());


        Book book = new Book( jobForm.getName(), foundEmployer, foundQuantity,
                foundPrice, foundDateCreated);

        jobData.add(book);
        return "redirect:/book?id="+ book.getId();



    }
}