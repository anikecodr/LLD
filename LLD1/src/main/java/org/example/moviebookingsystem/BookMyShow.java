package org.example.moviebookingsystem;

import org.example.moviebookingsystem.constant.City;
import org.example.moviebookingsystem.constant.SeatCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookMyShow {


    MovieController movieController;
    TheaterController theaterController;

    BookMyShow() {
        this.movieController = new MovieController();
        this.theaterController = new TheaterController();
    }

    public static void main(String[] args) {

        System.out.println("-----Book My show is my application-----");

        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();



    }

    public void initialize() {

        //initialize movie
        initializeMovie();

        //initailize theatre
        initializeTheater();

        //Create booking

        createBooking(City.Bangalore, "Saiyara");
        createBooking(City.Bangalore, "Saiyara");






    }

    private void createBooking(City city, String movieName) {

        //1. Search movie with my location

        List<Movie> movieList = movieController.getMoviesByCity(city);

        //2. select the movie which you want to see;, i want to see War2;

         Movie interestedMovie = movieList.stream().filter(movie -> movie.getMovieName().equals(movieName)).findFirst().orElse(null);

        //3. Get all shows of this movie in location;

        List<Theater> theaterList = theaterController.getTheaterForCity(city);

        //4. Get all the show of the movie in that city;

        //get all show from all theater
        List<List<Show>> showList= theaterList.stream().map(Theater::getShows).toList();

        List<Show> allShowsForCity = new ArrayList<>();
        showList.forEach(allShowsForCity::addAll);

        List<Show> showsForInterestedMovie = allShowsForCity.stream().filter(show -> show.getMovie().equals(interestedMovie)).toList();

        //5. Book Seat for a show;

        Show selectedShow = showsForInterestedMovie.get(0);

        int seatNumSelected = 30;

        if(isSeatAvailable(selectedShow, seatNumSelected)) {
            System.out.println("Seat is available :: starting booking");

            Seat selectedSeat  = selectedShow.getScreen().getSeatForASeatNumber(seatNumSelected);
            selectedShow.addBookingSeat(selectedSeat);
            Booking booking  = new Booking(30, selectedShow, Collections.singletonList(selectedSeat));

            Payment payment = new Payment(21, "UPI", selectedSeat.getPrice());

            booking.setPayment(payment);

            System.out.println("----Booking is confirmed with the following booking details " + booking.toString());
    } else {
      System.out.println("The selected is already occupied :: Thanks");
        }
  }

  private void initializeMovie() {

        Movie saiyara = new Movie("Saiyara", 200);
        Movie war2 = new Movie("War2", 230);
        Movie harryPorter = new Movie("HarryPorter", 302);

        movieController.addMovie(saiyara);
        movieController.addMovie(war2);
        movieController.addMovie(harryPorter);


        movieController.addMovieToACity(City.Bangalore, saiyara);
        movieController.addMovieToACity(City.Bangalore, harryPorter);
        movieController.addMovieToACity(City.Hyderabad, war2);
        movieController.addMovieToACity(City.Mumbai, harryPorter);
    }

    private void initializeTheater() {

        Theater pvr = new Theater(32, "PVR", "PVR HITECH CITY HYD");
        addScreenToTheater(pvr);
        addShowsToTheater(pvr);

        Theater ambMovies = new Theater(23, "AMB MOVIES", "Kormangala Bangalore");
        addScreenToTheater(ambMovies);
        addShowsToTheater(ambMovies);


        theaterController.mapTheaterToCity(City.Bangalore, ambMovies);
        theaterController.mapTheaterToCity(City.Hyderabad, pvr);

        theaterController.addTheater(pvr);
        theaterController.addTheater(ambMovies);
    }

    private void addScreenToTheater(Theater theater) {
        Screen screen = new Screen(1);

        for(int i=1; i<=30; i++) {
            screen.addSeat(new Seat(i, SeatCategory.SILVER, 100));
        }

        for(int i=31; i<=70; i++) {
            screen.addSeat(new Seat(i, SeatCategory.GOLD, 150));
        }

        for(int i=71; i<=100; i++) {
            screen.addSeat(new Seat(i, SeatCategory.PLATINUM, 200));
        }

        theater.addScreen(screen);

         screen = new Screen(2);

        for(int i=1; i<=30; i++) {
            screen.addSeat(new Seat(i, SeatCategory.SILVER, 100));
        }

        for(int i=31; i<=70; i++) {
            screen.addSeat(new Seat(i, SeatCategory.GOLD, 150));
        }

        for(int i=71; i<=100; i++) {
            screen.addSeat(new Seat(i, SeatCategory.PLATINUM, 200));
        }
        theater.addScreen(screen);
    }

    private void addShowsToTheater(Theater theater) {

        Show morningShow = new Show(1, movieController.allMovies.get(0), 10, theater.getScreens().get(0));

        theater.addShows(morningShow);

        Show eveningShow = new Show(2, movieController.allMovies.get(1), 3, theater.getScreens().get(1));
        theater.addShows(eveningShow);
    }

    private boolean isSeatAvailable(Show show, int seatNumber) {
        return show.bookingSeatIds.stream().noneMatch(seat -> seat.seatNumber == seatNumber);
    }
}