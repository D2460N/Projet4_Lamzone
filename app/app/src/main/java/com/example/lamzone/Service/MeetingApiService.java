package com.example.lamzone.Service;

import com.example.lamzone.Model.Meeting;
import com.example.lamzone.Model.Room;


import java.util.List;

public interface MeetingApiService {


    List<Room> getRooms ();

    List<Meeting> getMeetingsList() ;


    void deleteMeeting(Meeting meeting);

    void addMeeting(Meeting meeting);


}