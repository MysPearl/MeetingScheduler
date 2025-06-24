package com.scheduler;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingScheduler scheduler = new MeetingScheduler();

    @PostMapping
    public String scheduleMeeting(@RequestBody Meeting meeting) {
        boolean success = scheduler.schedule(meeting);
        return success ? "Meeting scheduled successfully!" : "Conflict: Meeting overlaps with an existing one.";
    }

    @GetMapping
    public List<Meeting> getMeetings() {
        return scheduler.getMeetings();
    }
}
