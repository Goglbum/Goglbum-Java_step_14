package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 10, "MOW", "LED", 60);
    Ticket ticket2 = new Ticket(2, 60, "LED", "MOW", 80);
    Ticket ticket3 = new Ticket(3, 99, "LED", "GOJ", 70);
    Ticket ticket4 = new Ticket(4, 40, "LED", "KUF", 80);
    Ticket ticket5 = new Ticket(5, 70, "LED", "MOW", 40);
    Ticket ticket6 = new Ticket(6, 60, "MOW", "GOJ", 20);
    Ticket ticket7 = new Ticket(7, 70, "MOW", "KUF", 70);
    Ticket ticket8 = new Ticket(8, 20, "LED", "MOW", 90);
    Ticket ticket9 = new Ticket(9, 90, "KUF", "MOW", 60);

    @BeforeEach
    public void setUp() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.save(ticket7);
        repository.save(ticket8);
        repository.save(ticket9);
    }

    @Test
    public void removeById() {
        repository.removeById(4);
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket5, ticket6, ticket7, ticket8, ticket9};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByNonExistId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(11));
    }
}