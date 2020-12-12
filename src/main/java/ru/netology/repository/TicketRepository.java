package ru.netology.repository;

import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket){
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {return tickets; }

    public Ticket findById(int id) {
        for (int i = 0; i < tickets.length; i++) {
            int index = tickets.length - i - 1;
            if (tickets[index].getId() == id) {
                return tickets[index];
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) { throw new NotFoundException("Element with id: " + id + " not found"); }
        int lenght = tickets.length - 1;
        Ticket[] tmp = new Ticket[lenght];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    public void removeAll() { tickets = new Ticket[0]; }
}
