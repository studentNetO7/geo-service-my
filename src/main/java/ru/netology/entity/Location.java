package ru.netology.entity;

import java.util.Objects;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int building;

    public Location(String city, Country country, String street, int building) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    @Override
    public String toString() {
        return "Location{city='" + city + "', country='" + country + "', street='" + street + "', building='" + building + "'";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Проверяем, ссылается ли объект на тот же экземпляр
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на null и тип
        Location location = (Location) obj; // Приведение типа
        return building == location.building && // Сравниваем zipCode
                Objects.equals(city, location.city) && // Сравниваем city
                country == location.country && // Сравниваем country
                Objects.equals(street, location.street); // Сравниваем street
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, street, building); // Генерация hash-кода
    }
}
