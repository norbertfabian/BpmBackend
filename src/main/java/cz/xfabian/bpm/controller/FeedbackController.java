package cz.xfabian.bpm.controller;

import cz.xfabian.bpm.domain.Feedback;
import cz.xfabian.bpm.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Norbert Fábián on 6/9/2017.
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public Feedback processFeedback(@RequestBody Feedback feedback) {
        feedbackRepository.save(feedback);
        return feedback;
    }
}
