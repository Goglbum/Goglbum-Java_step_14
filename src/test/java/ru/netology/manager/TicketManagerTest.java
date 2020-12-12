package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class TicketManagerTest {
    @Mock
    private TicketRepository repository;
    @InjectMocks
    private TicketManager manager;
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
        Ticket[] returned = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};
        doReturn(returned).when(repository).findAll();
    }

    @Test
    public void findAllDefault() {
        Ticket[] actual = manager.findAll("LED", "MOW");
        Ticket[] expected = new Ticket[]{ticket8, ticket2, ticket5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllDefaultOneTicket() {
        Ticket[] actual = manager.findAll("LED", "GOJ");
        Ticket[] expected = new Ticket[]{ticket3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllDefaultNonTicket() {
        Ticket[] actual = manager.findAll("KUF", "LED");
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllComparatorByTime() {
        Ticket[] actual = manager.findAll("LED", "MOW", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[]{ticket5, ticket2, ticket8};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllComparatorByTimeOneTicket() {
        Ticket[] actual = manager.findAll("LED", "GOJ", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[]{ticket3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllComparatorByTimeNonTicket() {
        Ticket[] actual = manager.findAll("KUF", "LED", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, actual);
    }
}