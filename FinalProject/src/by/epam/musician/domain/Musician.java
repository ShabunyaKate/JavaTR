package by.epam.musician.domain;
import java.util.ArrayList;
import java.util.List;

public class Musician extends Entity {

    private User user;
    private Day day;
    private List<Song> songs = new ArrayList<>();

    public void setUser(User user) { this.user = user; }
    public void setDay(Day day){
        this.day=day;
    }
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public User getUser() { return user; }
    public List<Song> getSongs() {
        return songs;
    }
    public Day getDay(){
        return day;
    }

    public void add(Song song) {
        songs.add(song);
    }
    public void remove(Song song) {
        songs.remove(song);
    }
}
