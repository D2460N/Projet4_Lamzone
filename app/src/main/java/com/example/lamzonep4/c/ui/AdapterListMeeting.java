package com.example.lamzonep4.c.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lamzonep4.R;

import com.example.lamzonep4.c.events.DeleteMeetingEvent;
import com.example.lamzonep4.c.events.ShowMeetingDetailsEvent;
import com.example.lamzonep4.c.model.Meeting;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterListMeeting extends RecyclerView.Adapter <AdapterListMeeting.ViewHolder> {
    private static final String BUNDLE_MEETING = "BUNDLE_MEETING";
    List<Meeting> mMeeting ;

    public AdapterListMeeting(List<Meeting> mMeeting) {
        this.mMeeting = mMeeting;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageRoom)
        ImageView imageRoom;
        @BindView(R.id.subject)
        TextView subjectMeeting;
        @BindView(R.id.hour)
        TextView hourMeeting;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.Room_Name)
        TextView nameRoom;
        @BindView(R.id.btnDelete)
        ImageButton btnDelete;
        @BindView(R.id.text_email)
        TextView mEmail;

        static final String BUNDLE_MEETING = "BUNDLE_MEETING";

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reunion,parent,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Meeting meeting = mMeeting.get(position);

        holder.subjectMeeting.setText(meeting.getmSubject());
        holder.hourMeeting.setText(meeting.getmHour());
        holder.nameRoom.setText(meeting.getmRoom().getmNameRoom());
        holder.date.setText(meeting.getmDate());
        holder.mEmail.setText(meeting.getmEmails());
        Glide.with(holder.imageRoom.getContext())
                .load(meeting.getmRoom().getmRoomColor())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageRoom);

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               getDefault().post(new DeleteMeetingEvent(meeting));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMeeting.size();
    }

    @Subscribe
    public void onMeetinhDetails(ShowMeetingDetailsEvent) {
        Intent MeetingDetailsIntent = new Intent(this, MeetingDetailsActivity.class);
        meetingDetailsIntent.putExtra(BUNDLE_MEETING, .meeting);
        startActivity(meetingDetailsIntent);
    }

}
