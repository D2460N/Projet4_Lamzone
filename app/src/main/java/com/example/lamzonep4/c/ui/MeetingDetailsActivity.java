package com.example.lamzonep4.c.ui;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.lamzonep4.c.di.DI;
import com.example.lamzonep4.c.model.Meeting;
import com.example.lamzonep4.R;
import com.example.lamzonep4.c.service.MeetingApiService;


import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.lamzonep4.c.ui.AdapterListMeeting.ViewHolder.BUNDLE_MEETING;


public class MeetingDetailsActivity extends AppCompatActivity {


    Meeting myMeeting;

    @BindView(R.id.meeting_subject)
    TextView myMeetingSubject;

    @BindView(R.id.meeting_room)
    ImageView myMeetingRoom;

    @BindView(R.id.meeting_mails)
    TextView myMeetingMails;

    @BindView(R.id.meeting_date)
    TextView myMeetingDate;

    @BindView(R.id.meeting_time)
    TextView myMeetingTime;

    private MeetingApiService mApiService;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);
        ButterKnife.bind(this);
        mApiService = DI.getMeetingApiService();
        myMeeting = (Meeting) getIntent().getSerializableExtra(BUNDLE_MEETING);
        myMeetingRoom.setImageResource(myMeeting.getmRoom().getmRoomColor());
        myMeetingMails.setText(myMeeting.getmEmails());
        myMeetingDate.setText(myMeeting.getmDate());
        myMeetingTime.setText(myMeeting.getmHour());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}