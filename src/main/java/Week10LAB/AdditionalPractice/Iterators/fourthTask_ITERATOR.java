package Week10LAB.AdditionalPractice.Iterators;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Song4 {
    String title;
    String artist;
    String genre;

public Song4(String title, String artist, String genre) {
    this.title = title;
    this.artist = artist;
    this.genre = genre;
}

public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}

public String getArtist() {
    return artist;
}
public void setArtist(String artist) {
    this.artist = artist;
}

public String getGenre() {
    return genre;
}
public void setGenre(String genre) {
    this.genre = genre;
}

@Override
public String toString() {
    return "Title: " + this.title + " , Genre: " + this.genre + " , Artist: " + this.artist;
    }
}

class TitlePrefixFilterIterator implements Iterator<Song4> {
    List<Song4> playlist;
    String prefix;
    int currentIndex = 0;

    public TitlePrefixFilterIterator(List<Song4> playlist, String prefix) {
        this.playlist = playlist;
        this.prefix = prefix;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < playlist.size()) {
            Song4 song = playlist.get(currentIndex);
            if(song.getArtist().startsWith(prefix)) {
                return true;
            } currentIndex++;
        } return false;
    }

    @Override
    public Song4 next() {
        if (hasNext()) {
            return playlist.get(currentIndex++);
        } else
            throw new NoSuchElementException();
    }

}

class Main05 {
    public static void main(String[] args) {
        List<Song4> playlist = new ArrayList<>();
        playlist.add(new Song4("FRANCHISE","Travis Scott","RAP"));
        playlist.add(new Song4("ASTROWORLD","Travis Scott","RAP"));
        playlist.add(new Song4("LTWYL","Travis Teller","POP"));
        playlist.add(new Song4("RAP DEVIL","MGK","HIPHOP/RAP"));

        TitlePrefixFilterIterator iterator = new TitlePrefixFilterIterator(playlist,"Tr");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
