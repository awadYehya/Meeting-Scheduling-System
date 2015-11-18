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

/**
 *
 * @author Yehya Awad
 * 
 */
public class Meeting {
    private String roomID;
    
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

    private int timeSlot;

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

}
