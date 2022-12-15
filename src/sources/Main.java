package sources;

import sources.Models.Story;

public class Main {
    public static void main(String[] args) {
        Story story = new Story();
        story.start();
        story.tell();
    }
}
