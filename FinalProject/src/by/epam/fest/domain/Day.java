package by.epam.fest.domain;

import java.sql.Date;

public class Day extends Entity {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
