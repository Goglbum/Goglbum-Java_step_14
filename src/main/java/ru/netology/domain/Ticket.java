package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int timeMin;

    public boolean matchesAirport(String from, String to) {
        if (departureAirport.equalsIgnoreCase(from) & arrivalAirport.equalsIgnoreCase(to)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }
}
