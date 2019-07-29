package by.epam.fest.domain;

public class Song extends Entity{
    private String song;
    private Integer musician_id;

    public void setSong(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }
    public Integer getMusician_id() {return musician_id; }

    public void setMusician_id(Integer musician_id) { this.musician_id = musician_id; }
}
