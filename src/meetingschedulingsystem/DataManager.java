/*
 * Copyright (C) 2015 yha5009
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
import javax.swing.JOptionPane;

/**
 *
 * @author Yehya Awad
 */
public class DataManager {

    private static ArrayList<Room> rooms;
    private static ArrayList<Person> people;
    private static ArrayList<Meeting> meetings;

    public static void init(ArrayList<Room> rooms, ArrayList<Person> people, ArrayList<Meeting> meetings) {
        DataManager.rooms = rooms;
        DataManager.people = people;
        DataManager.meetings = meetings;
    }
    
    public static void init() {
        init(new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    }
    
    /**
     * Clears all data
     */
    public static void clear() {
        rooms = new ArrayList<>();
        people = new ArrayList<>();
        meetings = new ArrayList<>();
    }
    
    
    public static ArrayList<Room> getRooms() {
        return rooms;
    }

//    public static void setRooms(ArrayList<Room> rooms) {
//        DataManager.rooms = rooms;
//    }

    public static ArrayList<Person> getPeople() {
        return people;
    }

//    public static void setPeople(ArrayList<Person> people) {
//        DataManager.people = people;
//    }

    public static ArrayList<Meeting> getMeetings() {
        return meetings;
    }

//    public static void setMeetings(ArrayList<Meeting> meetings) {
//        DataManager.meetings = meetings;
//    }

    /** Updates a room with new data
     * 
     * @param room 
     */
    private static void updateRoom(Room room) {
        superRemoveRoom(room); // uses a different type of remove that bypasses meetings check
        addRoom(room);
    }
    
    /**
     * Updates a meeting
     * @param meet 
     */
    private static void updateMeeting(Meeting meet) {
        removeMeeting(meet);
        addMeeting(meet);
    }
    
    /**
     * Adds a room to the data ArrayList
     * @param room Room being added
     */
    public static void addRoom(Room room) {
        for (Room rm: DataManager.rooms) {
            if (rm.getID().equals(room.getID())){
                JOptionPane.showMessageDialog(null,"Can't use ID: "+room.getID()
                        +" as it is already being used.","Duplicate room",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (DataManager.rooms.contains(room)){
            throw new Error("Room already exists in Data.");
        }
        DataManager.rooms.add(room);
    }
    
    /**
     * Adds a meeting to the data ArrayList and to the corresponding room
     * @param meet Meeting being added to the data
     * @return 
     */
    public static boolean addMeeting(Meeting meet) {
        for (Room room : rooms) {
            if (room.getID().equals(meet.getRoomID())) {
                if (room.isTimeslotTaken(meet.getTimeSlot())){
                    return false;
                }
                meetings.add(meet);
                room.addMeeting(meet); // Add meeting to the room
                updateRoom(room);
                return true;
            }
        }
        throw new Error("Meeting being added to non-existent room.");
    }
    
    public static void addPerson(Person pers) {
        if (DataManager.people.contains(pers)) {
            throw new Error("Person already in data.");
        }
        DataManager.people.add(pers);
    }
    
    /**
     * Removes a room only if it has no meetings
     * @param room Room being removed
     * @return boolean true if removed false if cannot remove
     */
    public static boolean removeRoom(Room room) {
        if (room.getMeetings().isEmpty()) {
            DataManager.rooms.remove(room);
            return true; // deleted
        }
        System.out.println("Trying to delete room that has meetings.");
        return false;
    }
    
    /**
     * Room remover that bypasses meetings check
     * @param room 
     */
    private static void superRemoveRoom(Room room) {
        if (DataManager.rooms.contains(room)) {
            DataManager.rooms.remove(room);
            return;
        }
        throw new Error("Attemted to remove room that does not exist.");
    }
    
    /**
     * Removes the meeting
     * @param meet Meeting being removed
     */
    public static void removeMeeting(Meeting meet) {
        for (Room room : rooms) {
            if (room.getID().equals(meet.getRoomID())) {
                meetings.remove(meet);
                room.removeMeeting(meet);
                updateRoom(room);
                return;
            }
        }
        throw new Error("Meeting attempted to delete does not exist in a room.");
    }
    
    /**
     * Removes a person
     * @param pers Person being removed
     * @return Boolean true if removed, false if not removed
     */
    public static boolean removePerson(Person pers) {
        if (getPersonMeetings(pers).size() > 0) {
            return false;
        }
        DataManager.people.remove(pers);
        return true;
    }
    
    public static boolean doesRoomExist(Room room) {
        return doesRoomExist(room.getID());
    }
    
    public static boolean doesRoomExist(String roomID) {
        for (Room room : DataManager.rooms) {
            if (room.getID() == null ? room.getID() == null : room.getID().equals(room.getID())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Removes all meetings from a certain room and updates the Data in the manager
     * @param room 
     * @return  
     */
    public static Room clearMeetingsInRoom(Room room) {
        ArrayList<Meeting> roomMeetings = new ArrayList<>(room.getMeetings());
        for (Meeting meet : roomMeetings){
            room.removeMeeting(meet);
        }
        updateRoom(room);
        return room;
    }
    
    /**
     * 
     * @param pers
     * @return 
     */
    public static ArrayList<Meeting> getPersonMeetings(Person pers) {
        ArrayList<Meeting> persMeetings = new ArrayList<>();
        
        for (Meeting meet : DataManager.meetings){
            for (Person attnd : meet.getAttendees()){
                if (pers.toString().equals(attnd.toString())) {
                    persMeetings.add(meet);
                }
            }
        } 
        
        return persMeetings;
    }
}
