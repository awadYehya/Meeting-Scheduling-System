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
 * A table model for the PeopleTable used on the PeopleMenu. 
 * It is an extension of AbstractTableModel with extra functionality.
 * @author yha5009
 */
public class PeopleTableModel extends AbstractTableModel {
    private final String[] columnNames = {"First", "Last", "Phone"};//same as before...
    private Object[][] data;
    private final ArrayList<Object[]> dataList = new ArrayList<>();
    private final ArrayList<Person> peopleList = new ArrayList<>();

    public PeopleTableModel() {
        this.data = new Object[][]{};
    }
    
    public void clearData() {
        peopleList.clear();
        dataList.clear();
        refreshTable();
    }
    
    public void addPerson(Person pers) {
        peopleList.add(pers);
        Object[] meetData = {pers.getFirstName(), pers.getLastName(), pers.getPhoneNumber()};
        dataList.add(meetData);
        refreshTable();
    }
    
    public void removeMeeting(Person pers) {
        dataList.remove(peopleList.indexOf(pers));
        peopleList.remove(pers);
        refreshTable();
    }
    
    public Person getPersonAtIndex(int indx) {
        return peopleList.get(indx);
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
