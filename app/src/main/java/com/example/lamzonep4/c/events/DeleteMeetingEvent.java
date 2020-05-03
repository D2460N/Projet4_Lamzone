package com.example.lamzonep4.c.events;

import android.util.Log;

import com.example.lamzonep4.c.model.Meeting;

public class DeleteMeetingEvent {

    public Meeting meeting ;


    public DeleteMeetingEvent(Meeting meeting) {
        Log.d("DEBUG", "DeleteMeetingEvent: Delete Meeting from meetings list");

        this.meeting = meeting;
    }
}