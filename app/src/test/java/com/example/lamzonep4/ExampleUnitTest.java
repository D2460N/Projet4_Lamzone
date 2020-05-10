package com.example.lamzonep4;


import com.example.lamzonep4.c.ui.ActivityMeetingsList;
import com.example.lamzonep4.c.di.DI;
import com.example.lamzonep4.c.model.Meeting;
import com.example.lamzonep4.c.service.MeetingApiService;
import com.example.lamzonep4.c.service.MeetingGenerator;
import com.example.lamzonep4.c.service.RoomGenerator;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.junit.Assert.*;


public class ExampleUnitTest {

    private MeetingApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getMeetingsList() {

        List<Meeting> mMeetings = service.getMeetingsList();

        List<Meeting> expectedMeetings = MeetingGenerator.meetingList;
        assertThat(mMeetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeetings.toArray()));
    }

    @Test
    public void addMeetingWithSuccess() {

        Meeting meeting = new Meeting("Reunion 4 ", RoomGenerator.generateRooms().get(4), "09", "Jan 2020",
                "david@lamzone.com");
        service.addMeeting(meeting);
        assertTrue(service.getMeetingsList().contains(meeting));

    }

    @Test
    public void deleteReunionWithSuccess() {
        Meeting meetingToDelete = service.getMeetingsList().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeetingsList().contains(meetingToDelete));
    }

    @Test
    public void FilterRooms() {
        Meeting meeting = new Meeting("Reunion 4 ", RoomGenerator.generateRooms().get(4), "09", "Jan 2020",
                "david@lamzone.com");
        List<Meeting> mMeetings = service.getMeetingsList();
        mMeetings.add(meeting);
        Collections.sort(mMeetings, new ActivityMeetingsList.ComparatorRooms());

        for(int i =0 ; i < mMeetings.size()-1 ; i++) {
            assertThat(mMeetings.get(i).getmRoom().getmNameRoom(), is(lessThanOrEqualTo(mMeetings.get(i+1).getmRoom().getmNameRoom())));
        }
    }

    @Test
    public void FilterDate() {
        Meeting meeting = new Meeting("Reunion 4 ", RoomGenerator.generateRooms().get(4), "09", "Jan 2020",
                "david@lamzone.com");
        List<Meeting> mMeetings = service.getMeetingsList();
        mMeetings.add(meeting);

        Collections.sort(mMeetings, new ActivityMeetingsList.ComparatorDate());

        for (int i = 0; i < mMeetings.size() - 1; i++) {

            assertThat(mMeetings.get(i).getmDate(), is(lessThanOrEqualTo(mMeetings.get(i+1).getmDate())));
        }
    }

}


