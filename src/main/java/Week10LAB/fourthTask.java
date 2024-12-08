package Week10LAB;
/*
Kad implementiratmo Iterator<Klasa>, pravimo klasu koja omogucava iteraciju kroz objekte tipa Song
To znaci da definisemo kako se prolazi kroz kolekciju tih objekata, jedan po jedan
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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
        return genre;
    }


    @Override
    public String toString() {
        return "Title: " + this.title + " , Artist: " + this.artist + " , Genre: " + this.genre;
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
        if (hasNext()) {
            return playlist.get(currentIndex++);
        } else
            throw new NoSuchElementException("NO!");
    }

}

class Main99 {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();
        playlist.add(new Song("Love the way you lie","Eminem","Rap"));
        playlist.add(new Song("Rap God","Eminem","Rap"));
        playlist.add(new Song("Prada","Voyage","Turbofolk"));
        playlist.add(new Song("Reference","Voyage","Rap"));


        GenreFilterIterator iterator = new GenreFilterIterator(playlist,"Rap");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
