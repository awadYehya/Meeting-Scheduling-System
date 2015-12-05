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
 * @author yha5009
 */

public class Room {
    
    private final String ID;
    private ArrayList<Meeting> meetings;
    
    /** 
     * Constructor  
     * @param ID unique identification of the room
     */
    public Room(String ID) {
        this.ID = ID;
        meetings = new ArrayList<>(10); // initial capacity 10
    }
    
    /** 
     * Constructor  
     * @param ID unique identification of the room
     */
    public Room(Integer ID) {
        this(ID.toString());
    }

    /**
     * Get the value of ID
     *
     * @return the value of ID
     */
    public String getID() {
        return ID;
    }   
    
    /**
     * Adds a meeting to the room
     * @param meet Meeting being added
     */
    public void addMeeting(Meeting meet) {
        meetings.add(meet);
    }
    
    /**
     * Remove a meeting from the room
     * @param meet Meeting being removed
     */
    public void removeMeeting(Meeting meet) {
        System.out.println(meetings.remove(meet));
    }

    /**
     * Checks if the time slot is taken
     * @param time Integer time (hour) being checked
     * @return true if time slot is taken
     */
    public boolean isTimeslotTaken(int time) {
        for (Meeting meet : meetings) {
            if (time == meet.getTimeSlot()) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public String toString() {
        return ID; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
