package sources.Events;

import sources.Models.Malysh;
import sources.Models.Building.Room;
import sources.Models.Thing;

public class BecomingCleverEvent extends Event {
    private final Malysh malysh;

    public BecomingCleverEvent(Malysh malysh) {
        super(malysh.getName() + " становится умным");
        this.malysh = malysh;
    }

    public void start() {
        System.out.println("#####");
        System.out.println(getName());
        Room room = malysh.getRoom();
        int count = 0;
        while (room.getFreeSpace() > 0) {
            count += 1;
            int finalCount = count;
            room.addBook(new Thing("Книга") {
                public final String title = getName() + " №" + finalCount;

                @Override
                public void action(String name) {
                    System.out.println(title + " читается");
                }
            });
        }
        java.util.Random random = new java.util.Random();
        int size = room.getBooks().size();
        for (int i = 0; i < 3; i ++) {
            Thing book = room.getBooks().get(random.nextInt(size));
            book.action("читать");
        }
        malysh.setIntelligence(140);
        malysh.setPopularity(0.9);
        System.out.println();
    }
}
