package ge.edu.geolab.gevents.model;

import ge.edu.geolab.gevents.model.base.IEvent;

/**
 * Created by akaki on 21.02.17.
 */

public enum Event implements IEvent {
    ART_EVENT(0, "Art"),
    BOOK_EVENT(1, "Book"),
    MOVIE_EVENT(2, "Movie"),
    FUNDRAISER(3, "Fundraiser"),
    VOLUNTEERING(4, "Volunteering"),
    FAMILY_EVENT(5, "Family"),
    FESTIVAL_EVENT(6, "Festival"),
    NEIGHBORHOOD(7, "Neighborhood"),
    RELIGIOUS_EVENT(8, "Religious"),
    SHOPPING(9, "Shopping"),
    COMEDY_EVENT(10, "Comedy"),
    MUSIC_EVENT(11, "Music"),
    DANCE_EVENT(12, "Dance"),
    NIGHTLIFE(13, "Nightlife"),
    THEATER_EVENT(14, "Theater"),
    DINING_EVENT(15, "Dining"),
    FOOD_TASTING(16, "Food"),
    CONFERENCE_EVENT(17, "Conference"),
    MEETUP(18, "MeetUp"),
    CLASS_EVENT(19, "Class"),
    LECTURE(20, "Lecture"),
    WORKSHOP(21, "Workshop"),
    FITNESS(22, "Fitness"),
    SPORTS_EVENT(23, "Sport"),
    OTHER(24, "Other");

    Event(int id, String name) {
        this.id = id;
        this.name = name;
    }

    final int id;
    final String name;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}