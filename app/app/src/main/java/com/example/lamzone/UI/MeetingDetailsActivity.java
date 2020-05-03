package com.example.lamzone.UI;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lamzone.R;
import com.example.lamzone.DI.DI;
import com.example.lamzone.Model.Meeting;
import com.example.lamzone.Service.MeetingApiService;


import butterknife.BindView;
import butterknife.ButterKnife;



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



    @BindView(R.id.toolbar)
    Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_details);
        ButterKnife.bind(this);
        mApiService = DI.getMeetingApiService();
        myMeeting = (Meeting) getIntent().getSerializableExtra(BUNDLE_NEIGHBOUR);
        myToolbar.setText(myMeeting.getmSubject());
        myMeetingRoom.setText(myMeeting.getmRoom());
        myMeetingMails.setText(myMeeting.getmEmails());
        myMeetingDate.setText(myMeeting.getmDate());
        myMeetingTime.setText(myMeeting.getmHour());
        setSupportActionBar(myToolbar);
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