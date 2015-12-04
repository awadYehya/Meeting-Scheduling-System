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
public class MeetingSchedulingSystem {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init();
        initGUI();
    }
    
    /**
     * Initializes application
     */
    public static void init() {
        DataManager.init();
        
        // Some Sample data
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Meeting sample1 = new Meeting("Who will we fire today", "1", 9);
        Meeting sample2 = new Meeting("Chicken or Beef?", "2", 12);
        DataManager.addRoom(room1);
        DataManager.addRoom(room2);
        DataManager.addMeeting(sample1);
        DataManager.addMeeting(sample2);
    }
    
    /**
     * Initializes application
     */
    public static void initGUI() {
        LoadingFrame load = new LoadingFrame();
        MainMenu main = new MainMenu();
    }
}
