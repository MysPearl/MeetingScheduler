package com.scheduler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Arrays;

@Controller
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingScheduler scheduler = new MeetingScheduler();

    // JSON API endpoint
    @PostMapping
    @ResponseBody
    public String scheduleMeetingAPI(@RequestBody Meeting meeting) {
        boolean success = scheduler.schedule(meeting);
        return success ? "Meeting scheduled successfully!" : "Conflict: Meeting overlaps with an existing one.";
    }

    // JSON API endpoint to list all meetings
    @GetMapping
    @ResponseBody
    public List<Meeting> getMeetings() {
        return scheduler.getMeetings();
    }

    @PostMapping("/submit")
    public String scheduleMeetingForm(@ModelAttribute Meeting meeting,
                                      @RequestParam("attendeesInput") String attendeesInput,
                                      Model model) {
        List<String> attendees = Arrays.stream(attendeesInput.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
        meeting.setAttendees(attendees);

        boolean success = scheduler.schedule(meeting);
        model.addAttribute("meeting", new Meeting());
        model.addAttribute("meetings", scheduler.getMeetings());
        model.addAttribute("status", success ? "Scheduled successfully!" : "Conflict: Meeting overlaps.");
        return "schedule-demo";
    }

}

