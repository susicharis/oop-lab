package FinalExamPrep2.Lab10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Song {
    String title;
    String artist;
    String genre;

    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }
}

class GenreFilterIterator implements Iterator<Song> {
    List<Song> playlist;
    String targetGenre;
    int currentIndex = 0;

    public GenreFilterIterator(List<Song> playlist, String targetGenre) {
        this.playlist = playlist;
        this.targetGenre = targetGenre;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < playlist.size()) {
            if(playlist.get(currentIndex).getGenre().equals(targetGenre)) {
                return true;
            } currentIndex++;
        } return false;
    }

    @Override
    public Song next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        } return playlist.get(currentIndex++);
    }
}

class Main01 {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();
        // ... ostatak ez ...
    }
}
