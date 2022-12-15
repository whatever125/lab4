package sources.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Building {
    private String street;
    private int number;
    private final List<Room> rooms = new ArrayList<>();

    public Building() {
        System.out.println("Строение типа " + this.getClass().getName() + " создано");
    }

    public Building(String street) {
        this.street = street;
        System.out.println("Строение типа " + this.getClass().getName() + " по адресу " + street + " создан");
    }

    public Building(String street, int number) {
        this.street = street;
        this.number = number;
        System.out.println("Строение типа " + this.getClass().getName() + " по адресу " + street + ", " + number + " создан");
    }

    public class Room {
        private Malysh owner;
        private final List<Thing> books = new ArrayList<>();
        private double freeSpace = 100;

        public Room(Malysh owner) {
            this.owner = owner;
            owner.setRoom(this);
        }

        public Malysh getOwner() {
            return owner;
        }

        public void setOwner(Malysh owner) {
            this.owner = owner;
            owner.setRoom(this);
        }

        public List<Thing> getBooks() {
            return books;
        }

        public void addBook(Thing book) {
            if (freeSpace > 0) {
                freeSpace -= 1;
                books.add(book);
            }
        }

        public double getFreeSpace() {
            return freeSpace;
        }

        public void setFreeSpace(double freeSpace) {
            this.freeSpace = freeSpace;
        }

        @Override
        public String toString() {
            return "Комната, владелец " + owner.getName() + ", находится в " + Building.this;
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Malysh owner) {
        Room room = new Room(owner);
        this.rooms.add(room);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Строение типа " + this.getClass().getName() + " по адресу " + street + " " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building building)) return false;
        return number == building.number && Objects.equals(street, building.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number);
    }
}
