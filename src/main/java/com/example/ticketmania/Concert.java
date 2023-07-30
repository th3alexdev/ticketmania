package com.example.ticketmania;
public class Concert {
    private static int nextId = 1;
    public int id;
    private String concertName;
    private String artistName;

    private String date;
    private String fullDate;

    private String time;
    private String location;
    private double price;
    private String poster;

    public Concert(String concertName, String artistName, String date, String fullDate, String time, String poster) {
        this.id = nextId++;
        this.concertName = concertName;
        this.artistName = artistName;
        this.date = date;
        this.fullDate = fullDate;
        this.location = "Terrazas del C. C. C. T.";
        this.price = 15;
        this.poster = poster;
    }

    public String showConcert() {
        return "Concert{" +
                "id=" + id +
                ", Artista='" + artistName + '\'' +
                ", Fecha='" + date + '\'' +
                ", Fecha Completa='" + fullDate + '\'' +
                ", Hora='" + time + '\'' +
                ", Ubicación='" + location + '\'' +
                ", Precio=" + price +
                ", IMG='" + poster + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getConcertName() {
        return concertName;
    }

    public String getDate() {
        return date;
    }

    public String getFullDate() {
        return fullDate;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getPoster() {
        return poster;
    }
}


