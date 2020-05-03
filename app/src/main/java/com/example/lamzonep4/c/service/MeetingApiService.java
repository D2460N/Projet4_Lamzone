package com.example.lamzonep4.c.service;

import com.example.lamzonep4.c.model.Meeting;
import com.example.lamzonep4.c.model.Room;

import java.util.List;

public interface MeetingApiService {


    List<Room> getRooms();

    List<Meeting> getMeetingsList() ;


    void deleteMeeting(Meeting meeting);

    void addMeeting(Meeting meeting);


}