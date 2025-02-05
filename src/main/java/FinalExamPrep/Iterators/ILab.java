package FinalExamPrep.Iterators;

import java.util.*;
/*
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

    @Override
    public String toString() {
        return "Title : " + this.title + " , Genre : " + this.genre + " , Artist : " + this.artist;
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
        while (currentIndex < playlist.size()) {
            if(playlist.get(currentIndex).getGenre().equals(targetGenre)) {
                return true;
            } currentIndex++;
        } return false;
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } return playlist.get(currentIndex++);
    }
}

class Main05 {
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

 */