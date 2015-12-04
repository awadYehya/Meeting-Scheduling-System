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

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author yha5009
 */
public class RoomsMenu extends javax.swing.JFrame {
    
    private RoomTableModel rtm = new RoomTableModel(); // room table model
    
    /**
     * Creates new form MeetingsMenu
     */
    public RoomsMenu() {
        initComponents();
        initTable();
        initSettings();
        updateModel();
        initListenerUpdate();
    }
    
    /**
     * Show dialog for nothing selected
     */
    private void showNoRoomSelected() {
        JOptionPane.showMessageDialog(this,
                "Please select a room first.",
                "Room not selected",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Initialize frame settings
     */
    private void initSettings() {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(this);
    }
    
    /**
     * Initialize table settings
     */
    private void initTable() {
        roomsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        roomsTable.getTableHeader().setReorderingAllowed(false);
    }
    
    /**
     * Updates table every time it is somehow changed/affected/focused on etc.
     */
    private void initListenerUpdate() {
        this.addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                updateModel();
            }
            @Override
            public void windowStateChanged(WindowEvent e) {
                updateModel();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                updateModel();
            }
            
            @Override
            public void windowDeactivated(WindowEvent e) {
                updateModel();
            }
            
            @Override
            public void windowActivated(WindowEvent e) {
                updateModel();
            }
            
            @Override
            public void windowOpened(WindowEvent e) {
                updateModel();
            }
            
        });
    }
    
    /**
     * Updates the table model and table with any changes to the data
     */
    private void updateModel() {
        rtm.clearData();
        for (Room room : DataManager.getRooms()) {
            rtm.addRoom(room);
        }
        rtm.refreshTable();
        roomsTable.setModel(rtm);
        roomsTable.getTableHeader().resizeAndRepaint();
        roomsTable.updateUI();
    }
    
    /**
     * Opens a dialog asking user if he wants to delete.
     * @return 
     */
    private int confirmDeleteDialog() {
        return JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete the selected room(s)?"
                        + "\nNote: You cannot delete rooms with meetings in them.",
                "Deleting rooms", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomsTable = new javax.swing.JTable();
        addRoomButton = new javax.swing.JButton();
        deleteSelectedButton = new javax.swing.JButton();
        showSelectedButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Rooms");

        roomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title", "Room", "Time", "# Attendees"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        roomsTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(roomsTable);

        addRoomButton.setText("Add new");
        addRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomButtonActionPerformed(evt);
            }
        });

        deleteSelectedButton.setText("Delete all selected");
        deleteSelectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedButtonActionPerformed(evt);
            }
        });

        showSelectedButton.setText("Show room Selected");
        showSelectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSelectedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addRoomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteSelectedButton, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(showSelectedButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showSelectedButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteSelectedButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Button action
     * @param evt 
     */
    private void addRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomButtonActionPerformed
        AddRoomDialog addDialog = new AddRoomDialog(this, true);
        addDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                updateModel();
            }
        });
    }//GEN-LAST:event_addRoomButtonActionPerformed
    /**
     * Button action
     * @param evt 
     */
    private void deleteSelectedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedButtonActionPerformed
        int removeCount = 0;
        if (roomsTable.getSelectedRows().length == 0){
            showNoRoomSelected();
            return;
        }
        int [] selectedRows = roomsTable.getSelectedRows();
        int confirmCancel = confirmDeleteDialog();
        if (confirmCancel == JOptionPane.YES_OPTION) {
            for (int rowindx: selectedRows) {
                Room selectedRoom;
                selectedRoom = rtm.getRoomAtIndex(rowindx);
                if (DataManager.removeRoom(selectedRoom)) {
                } else {
                    // TODO: pops new dialog
                    System.out.println("Could not remove: "+selectedRoom);
                    continue;
                }
                removeCount += 1;
            }
            updateModel();
            JOptionPane.showMessageDialog(this, removeCount+" Room(s) deleted succesfully.");
        }
        roomsTable.clearSelection();
    }//GEN-LAST:event_deleteSelectedButtonActionPerformed
    /**
     * Button action
     * @param evt 
     */
    private void showSelectedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSelectedButtonActionPerformed
        if (roomsTable.getSelectedRow() < 0){
            showNoRoomSelected();
            return;
        }
        int selectedRow = roomsTable.getSelectedRow();
        Room selectedRoom = rtm.getRoomAtIndex(selectedRow);
        ShowMeetingDialog showmeetingd = new ShowMeetingDialog(new Meeting("X", "1", 2)); // FIX THIS SHIT
        showmeetingd.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e); //To change body of generated methods, choose Tools | Templates.
                updateModel();
            }
        });
        showmeetingd.setVisible(true);
        roomsTable.clearSelection();
    }//GEN-LAST:event_showSelectedButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MeetingsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MeetingsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MeetingsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MeetingsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MeetingsMenu().setVisible(true);
//            }
//        });
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRoomButton;
    private javax.swing.JButton deleteSelectedButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable roomsTable;
    private javax.swing.JButton showSelectedButton;
    // End of variables declaration//GEN-END:variables
}
