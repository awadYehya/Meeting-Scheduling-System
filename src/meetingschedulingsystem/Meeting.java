/*
 * Copyright (C) 2015 Yehya Awad
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package meetingschedulingsystem;

import java.util.ArrayList;

/**
 *
 * @author Yehya Awad
 * 
 */
public class Meeting {
    /*
        Private Properties
    */
    private final long ID;
    private final String title;
    private String roomID;
    private ArrayList<Person> attendees;
    private int timeSlot;

    public Meeting(String title,String roomID, int timeSlot) {
        this.ID = System.currentTimeMillis() % 1000; // setting unique ID by time
        this.roomID = roomID;
        this.title = title;
        this.attendees = new ArrayList<>(10);
        this.timeSlot = timeSlot;
    }
    
    /**
     * Get the value of roomID
     *
     * @return the value of roomID
     */
    public String getRoomID() {
        return roomID;
    }

    /**
     * Set the value of roomID
     *
     * @param roomID new value of roomID
     */
    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    /**
     * Get the value of timeSlot
     *
     * @return the value of timeSlot
     */
    public int getTimeSlot() {
        return timeSlot;
    }

    /**
     * Set the value of timeSlot
     *
     * @param timeSlot new value of timeSlot
     */
    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
    
    /**
     * Adds an attendee
     * @param attnd Person object
     */
    public void addAttendee(Person attnd) {
        attendees.add(attnd);
    }
    
    /**
     * Remove an attendee
     * @param attnd Person object
     * @return boolean true if person existed in attendee list
     */
    public boolean removeAttendee(Person attnd) {
        boolean remove = attendees.remove(attnd);
        return remove;
    }

    public long getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Person> getAttendees() {
        return attendees;
    }
    
    /**
     * Formats and returns the time slot
     * @return String of the time formated nicely
     */
    public String getFormattedTimeSlot(){
        int tempTime = timeSlot%12;
        if (timeSlot == 12) tempTime = 12;
        return String.format("%s:00 %s", tempTime, ((timeSlot < 9) || (timeSlot == 12) ? "PM": "AM"));
    }

    @Override
    public String toString() {
        return this.title+" at "+this.getFormattedTimeSlot();
    }
    
}
