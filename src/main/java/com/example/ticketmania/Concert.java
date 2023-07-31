package com.example.ticketmania;
public class Concert {
    private static int nextId = 1;
    public int id;
    private String concertName;
    private String artistName;

    private int day;
    private String month;
    private String fullDate;

    private String time;
    private String location;
    private double price;
    private String poster;

    private int[] areas;

    private int[] pricesArray;

    public Concert(String concertName, String artistName, int day, String month, String fullDate, String time, String poster,
                   int[] areasArray) {
        this.id = nextId++;
        this.concertName = concertName;
        this.artistName = artistName;
        this.day = day;
        this.month = month;
        this.fullDate = fullDate;
        this.time = time;
        this.location = "Terrazas del C. C. C. T.";
        this.price = 15;
        this.pricesArray = new int[]{ 20, 25, 20,    // A - B - C
                                      10, 15, 10 };  // 0 - 1 - 2
        this.poster = poster;
        this.areas = areasArray; // Personas en área
    }

    public String showConcert() {
        StringBuilder areasString = new StringBuilder("[");
        for (int i = 0; i < areas.length; i++) {
            areasString.append(areas[i]);
            if (i < areas.length - 1) {
                areasString.append(", ");
            }
        }
        areasString.append("]");

        return "Concert{" +
                "id:" + id +
                ", Artista:'" + artistName + '\'' +
                ", Día:'" + day + '\'' +
                ", Mes:'" + month + '\'' +
                ", Fecha Completa:'" + fullDate + '\'' +
                ", Hora:'" + time + '\'' +
                ", Ubicación:'" + location + '\'' +
                ", Precio:" + price +
                ", IMG:'" + poster + '\'' +
                ", Áreas:" + areasString.toString() +
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

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
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

    public int getPeopleInArea(int areaNumber) {
        if (areaNumber >= 0 && areaNumber < areas.length) {
            return areas[areaNumber];
        } else {
            throw new IllegalArgumentException("Área inválida: " + areaNumber);
        }
    }

    public int getPriceForArea(int areaNumber) {
        if (areaNumber >= 0 && areaNumber < pricesArray.length) {
            return pricesArray[areaNumber];
        } else {
            throw new IllegalArgumentException("Área inválida: " + areaNumber);
        }
    }

    public void addPeopleToArea(int areaNumber, int peopleToAdd) {
        if (areaNumber >= 0 && areaNumber < areas.length) {
            areas[areaNumber] += peopleToAdd;
        } else {
            throw new IllegalArgumentException("Área inválida: " + areaNumber);
        }
    }
}


