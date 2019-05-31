package com.example.myapplication.data;

import java.util.Date;

public class ListMeeting {
    private int MeetingNumber;
    private String MeetingName;
    private String MeetingRoom;
    private Date MeetingTime;

    public int getMeetingNumber() {
        return MeetingNumber;
    }

    public void setMeetingNumber(int meetingNumber) {
        MeetingNumber = meetingNumber;
    }

    public String getMeetingName() {
        return MeetingName;
    }

    public void setMeetingName(String meetingName) {
        MeetingName = meetingName;
    }

    public String getMeetingRoom() {
        return MeetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        MeetingRoom = meetingRoom;
    }

    public Date getMeetingTime() {
        return MeetingTime;
    }

    public void setMeetingTime(Date meetingTime) {
        MeetingTime = meetingTime;
    }
}
