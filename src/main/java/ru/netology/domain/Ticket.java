package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket implements Comparable{
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
    public int compareTo(Object o) {
        Ticket p = (Ticket) o;
        return price - p.price;
    }
}
