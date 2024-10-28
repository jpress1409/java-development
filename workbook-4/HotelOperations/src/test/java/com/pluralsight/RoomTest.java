package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void getCheckIn() {

            //arrange
            Room room = new Room(1,1);
            room.isAvailable();
            room.isDirty();
            room.isOccupied();
            //act
            room.getCheckIn();
            //assert
            room.isAvailable();
            assertEquals()


    }

    @Test
    void getCheckOut() {
    }

    @Test
    void cleanRoom() {
    }
}