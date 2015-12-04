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
     * @param room
     */
    public static void addRoom(Room room) {
        if (DataManager.rooms.contains(room)){
            throw new Error("Room already exists in Data.");
        }
        DataManager.rooms.add(room);
    }
    
    /**
     * Adds a meeting to the data ArrayList and to the corresponding room
     * @param meet 
     */
    public static void addMeeting(Meeting meet) {
        for (Room room : rooms) {
            System.out.println("Trying room: "+room);
            System.out.println("Meeting room: "+meet.getRoomID());
            if (room.getID().equals(meet.getRoomID())) {
                meetings.add(meet);
                room.addMeeting(meet); // Add meeting to the room
                updateRoom(room);
                return;
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
     * @param room
     * @return 
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
     * @param meet 
     */
    public static void removeMeeting(Meeting meet) {
        for (Room room : rooms) {
            if (room.getID().equals(meet.getRoomID())) {
                System.out.println("Room x Meeting match");
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
     * @param pers 
     */
    public static void removePerson(Person pers) {
        DataManager.people.remove(pers);
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
}
