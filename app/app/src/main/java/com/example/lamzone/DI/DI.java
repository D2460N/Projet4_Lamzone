package com.example.lamzone.DI;

import com.example.lamzone.Service.DummyMeetingApiService;
import com.example.lamzone.Service.MeetingApiService;

public class DI {
    private static MeetingApiService service = new MeetingApiService();

    /**
     * Get an instance on @{@link MeetingApiService}
     * @return
     */
    public static MeetingApiService getMeetingApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link MeetingApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static DummyMeetingApiService getNewInstanceApiService() {

        return new DummyMeetingApiService();
    }

}