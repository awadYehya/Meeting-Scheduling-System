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
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yha5009
 */
public class RoomTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Room", "Number of Meetings", "Percentage Booked"}; //same as before...
    private Object[][] data = {{}};//same as before...
    private ArrayList<Object[]> dataList = new ArrayList<>();
    private ArrayList<Room> roomsList = new ArrayList<>();

    public RoomTableModel() {
    }
    
    public void clearData() {
        roomsList.clear();
        dataList.clear();
        refreshTable();
    }
    
    public void addRoom(Room room) {
        roomsList.add(room);
        int meetingNum = room.getMeetings().size();
        Double percentBooked = 100*meetingNum/8.00;
        int remSlots = 8 - meetingNum;
        Object[] roomData = {room.getID(), meetingNum, String.format("%.2f%s", percentBooked,"%")};
        dataList.add(roomData);
        refreshTable();
    }
    
    public void removeRoom(Room room) {
        dataList.remove(roomsList.indexOf(room));
        roomsList.remove(room);
        refreshTable();
    }
    
    public Room getRoomAtIndex(int indx) {
        return roomsList.get(indx);
    }
    
    public void refreshTable() {
        data = dataList.toArray(new Object[dataList.size()][]);
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
