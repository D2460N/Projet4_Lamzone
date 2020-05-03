package com.example.lamzone.Events;

import com.example.lamzone.Model.Meeting;

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