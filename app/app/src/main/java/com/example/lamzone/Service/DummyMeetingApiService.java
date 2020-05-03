package com.example.lamzone.Service;

import com.example.lamzone.Model.Meeting;
import com.example.lamzone.Model.Room;

import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

    private List<Room> mRooms = RoomGenerator.generateRooms();

    private List <Meeting> meetings =  MeetingGenerator.generateMeetings();

    @Override
    public List<Room> getRooms() {
        return mRooms;
    }

    @Override
    public List<Meeting> getMeetingsList() {
        return meetings;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {

        meetings.remove(meeting);

    }

    @Override
    public void addMeeting(Meeting meeting) {

        meetings.add(meeting);
    }
}
