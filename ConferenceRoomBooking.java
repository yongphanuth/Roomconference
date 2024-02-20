/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RoomcoferenceBooking;

import java.util.ArrayList;
import java.util.List;

public class ConferenceRoomBooking {
    private final List<ConferenceRoom> conferenceRooms;

    public ConferenceRoomBooking() {
        conferenceRooms = new ArrayList<>();
    }

    public void addConferenceRoom(ConferenceRoom room) {
        conferenceRooms.add(room);
    }

    public void displayAvailableRooms() {
        System.out.println("Available Conference Rooms:");
        for (ConferenceRoom room : conferenceRooms) {
            if (!room.isBooked()) {
                System.out.println(room.getRoomName());
            }
        }
    }

    public void displayAllRooms() {
        System.out.println("All Conference Rooms:");
        for (ConferenceRoom room : conferenceRooms) {
            System.out.println(room.getRoomName() + (room.isBooked() ? " (Booked)" : ""));
        }
    }

    public boolean bookRoom(String roomName) {
        for (ConferenceRoom room : conferenceRooms) {
            if (room.getRoomName().equals(roomName) && !room.isBooked()) {
                room.bookRoom();
                return true;
            }
        }
        return false;
    }

    public boolean cancelBooking(String roomName) {
        for (ConferenceRoom room : conferenceRooms) {
            if (room.getRoomName().equals(roomName) && room.isBooked()) {
                room.cancelBooking();
                return true;
            }
        }
        return false;
    }

    public boolean removeConferenceRoom(String roomName) {
        for (ConferenceRoom room : conferenceRooms) {
            if (room.getRoomName().equals(roomName)) {
                conferenceRooms.remove(room);
                return true;
            }
        }
        return false;
    }
}

