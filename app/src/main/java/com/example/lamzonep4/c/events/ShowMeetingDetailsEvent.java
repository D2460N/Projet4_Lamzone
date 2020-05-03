package com.example.lamzonep4.c.events;

import com.example.lamzonep4.c.model.Meeting;

public class ShowMeetingDetailsEvent {


    public Meeting meeting;

    /**
     * Constructor.k
     *
     * @param meeting
     */
    public ShowMeetingDetailsEvent(Meeting meeting) {
        this.meeting = meeting;
    }
}