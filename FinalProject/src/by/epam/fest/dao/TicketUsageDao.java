package by.epam.fest.dao;

import by.epam.fest.domain.TicketUsage;
import by.epam.fest.exception.TaskException;

import java.util.List;

public interface TicketUsageDao extends Dao<TicketUsage>{
   List<TicketUsage> readAllTicketsByUserId(Integer id)throws TaskException;
}
