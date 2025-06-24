
package com.scheduler;

import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
    private final List<Meeting> meetings = new ArrayList<>();

    public boolean schedule(Meeting newMeeting) {
        for (Meeting m : meetings) {
            if (m.overlaps(newMeeting)) {
                return false;
            }
        }
        meetings.add(newMeeting);
        return true;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
