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
 * @author yha5009
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

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static void setRooms(ArrayList<Room> rooms) {
        DataManager.rooms = rooms;
    }

    public static ArrayList<Person> getPeople() {
        return people;
    }

    public static void setPeople(ArrayList<Person> people) {
        DataManager.people = people;
    }

    public static ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public static void setMeetings(ArrayList<Meeting> meetings) {
        DataManager.meetings = meetings;
    }

    public static void addRoom(Room room) {
        DataManager.rooms.add(room);
    }
    
    public static void addMeeting(Meeting meet) {
        DataManager.meetings.add(meet);
    }
    
    public static void addPerson(Person pers) {
        DataManager.people.add(pers);
    }
    
    public static boolean removeRoom(Room room) {
        DataManager.rooms.remove(room);
        return true; // success
    }
    
    public static boolean removeMeeting(Meeting meet) {
        DataManager.meetings.remove(meet);
        return true; // success
    }
    
    public static boolean removePerson(Person pers) {
        DataManager.people.remove(pers);
        return true; // success
    }
    
}
