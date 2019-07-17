package by.epam.musician.domain;

public class TicketUsage extends Entity{
    private Ticket ticket;
    private User user;
    private Integer count;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public User getUser() {
        return user;
    }

    public Integer getCount() {
        return count;
    }


}
