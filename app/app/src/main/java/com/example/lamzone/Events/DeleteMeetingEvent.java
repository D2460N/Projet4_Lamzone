package com.example.lamzone.Events;

import android.util.Log;

import com.example.lamzone.Model.Meeting;

public class DeleteMeetingEvent {

    public Meeting meeting ;


    public DeleteMeetingEvent(Meeting meeting) {
        Log.d("DEBUG", "DeleteMeetingEvent: Delete Meeting from meetings list");

        this.meeting = meeting;
    }
}