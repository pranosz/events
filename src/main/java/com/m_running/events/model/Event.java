package com.m_running.events.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private double distance;

    @JsonProperty
    private int altitude;

    @JsonProperty
    private int itra;

    @JsonProperty
    private int price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;

    @JsonProperty
    private String location;

    public Event(int id) {
        this.id = id;
    }

    public Event(int id, String name, String description, double distance, int altitude, int itra, int price, Date date, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.distance = distance;
        this.altitude = altitude;
        this.itra = itra;
        this.price = price;
        this.date = date;
        this.location = location;
    }

    public Event() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getDistance() {
        return this.distance;
    }

    public int getAltitude() {
        return this.altitude;
    }

    public int getItra() {
        return this.itra;
    }

    public int getPrice() {
        return this.price;
    }

    public Date getDate() {
        return this.date;
    }

    public String getLocation() {
        return this.location;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @JsonProperty
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @JsonProperty
    public void setItra(int itra) {
        this.itra = itra;
    }

    @JsonProperty
    public void setPrice(int price) {
        this.price = price;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public void setDate(Date date) {
        this.date = date;
    }

    @JsonProperty
    public void setLocation(String location) {
        this.location = location;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Event)) return false;
        final Event other = (Event) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        if (Double.compare(this.getDistance(), other.getDistance()) != 0) return false;
        if (this.getAltitude() != other.getAltitude()) return false;
        if (this.getItra() != other.getItra()) return false;
        if (this.getPrice() != other.getPrice()) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$location = this.getLocation();
        final Object other$location = other.getLocation();
        if (this$location == null ? other$location != null : !this$location.equals(other$location)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Event;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final long $distance = Double.doubleToLongBits(this.getDistance());
        result = result * PRIME + (int) ($distance >>> 32 ^ $distance);
        result = result * PRIME + this.getAltitude();
        result = result * PRIME + this.getItra();
        result = result * PRIME + this.getPrice();
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $location = this.getLocation();
        result = result * PRIME + ($location == null ? 43 : $location.hashCode());
        return result;
    }

    public String toString() {
        return "Event(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", distance=" + this.getDistance() + ", altitude=" + this.getAltitude() + ", itra=" + this.getItra() + ", price=" + this.getPrice() + ", date=" + this.getDate() + ", location=" + this.getLocation() + ")";
    }
}
