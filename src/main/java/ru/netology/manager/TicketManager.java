package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

@NoArgsConstructor
public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) { this.repository = repository; }

    public void add(Ticket ticket) { repository.save(ticket); }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.matchesAirport(from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.matchesAirport(from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result, comparator);
            }
        }
        return result;
    }

    public void removeById(int id) { repository.removeById(id); }
}
