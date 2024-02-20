/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomcoferenceBooking;

//import roomconferencebooking.*;

public class ConferenceRoom {
    private String roomName;
    private boolean isBooked;

    public ConferenceRoom(String roomName) {
        this.roomName = roomName;
        this.isBooked = false;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        isBooked = true;
    }

    public void cancelBooking() {
        isBooked = false;
    }
}
