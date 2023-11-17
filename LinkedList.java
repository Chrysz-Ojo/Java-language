 package org.example;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ListIterator;
//LinkedList challenge
//Using LinkedList functionality, to create a list of a places,
// ordered by distance from the starting point.
// And we will use  a ListIterator to move backwards and forwards,
// through this ordered itinerary of places.
record Place(String name, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList<Place>placeToVisit= new LinkedList<>();
        Place adelaide = new Place("Adelaide", 1374);
        addPlace(placeToVisit,adelaide);
        addPlace(placeToVisit, new Place("adelaide",1374));
        addPlace(placeToVisit, new Place("Thrish",174));
        addPlace(placeToVisit, new Place("Bridane",474));
        addPlace(placeToVisit, new Place("Willy  Spice",1384));
        addPlace(placeToVisit, new Place("Randy Match",1114));
        addPlace(placeToVisit, new Place("Vice Logan",1370));


        placeToVisit.addFirst (new  Place("Yola", 10));
        System.out.println(placeToVisit);
        var iterator = placeToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();
        while (!quitLoop) {
            if (!iterator.hasPrevious()){
                System.out.println("Originating: " + iterator.next());
                forward = true;
            }

            if (!iterator.hasNext()){
                System.out.println("Originating: " + iterator.previous());
                forward = false;
            }
            System.out.println("Enter Value:");
            String menuItem = scanner.next().toUpperCase().substring(0,1);

            switch (menuItem) {
                case "F":
                    System.out.println("User want to go forward");
                    if (!forward) {      // Reversing Direction
                        forward = true;
                        if (iterator.hasNext()){
                            iterator.next(); //Adjust position forward
                        }
                    }
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;

                case "B":
                    System.out.println("User want to go backward");
                    if (!forward) {      // Reversing Direction
                        forward = false;
                        if (iterator.hasPrevious()){
                            iterator.previous(); //Adjust position backwards
                        }
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                    break;

                case "M":
                    printMenu();
                    break;

                case "L":
                    System.out.println(placeToVisit);
                    break;

                default:
                    quitLoop = true;
                    break;


            }
        }
    }
    private static void addPlace(LinkedList<Place> list, Place place){

        if (list.contains(place)){
            System.out.println("Found duplicate: " + place);
            return;
        }
        for (Place p : list){
            if (p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found duplicate: " + place);
                return;
            }
        }
        int matchedIndex =0;
        for (var listPlace : list) {
            if (place.distance() < listPlace.distance()){
                list.add(matchedIndex,place);
                return;
            }
            matchedIndex++;
        }
       list.add(place);

    }
    private static void printMenu(){
        System.out.println("""
                Available actions (select word or letter):
                (F)orwards
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit""");
