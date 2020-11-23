package Practice_12;

public class Main {

    public static void main(String[] args) {

        Artist artist=new Artist();
        System.out.println("My favourite kpop group is");
        artist.draw("White",Palette.WHITE);
        artist.draw("Punk",Palette.PINK);

        artist.draw("||||||||||||||||||||||||||",Palette.RESET);

        artist.draw("I like to coding",Palette.RED);
        artist.draw("And to talk about it",Palette.YELLOW);
        artist.draw("My friends like it too",Palette.GREEN);
        artist.draw("Gaming also my hobby",Palette.CYAN);
        artist.draw("Also I like listen to music",Palette.BLUE);
        artist.draw("You are invited to my club",Palette.MAGENTA);


    }
}
