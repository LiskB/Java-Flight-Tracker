# Flight Tracker

The purpose of this program is to allow the airline operators to track all of their flights, the passengers on the current flights, and the amount of seats available. The airline will be able to see upcoming flights, and be able to reserve seats and book passengers on them. Concepts were learned in computer science courses and independently, such as OOP and threads. Initially completed June 2017, although improvements have been made since then.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

For development purposes:
* [Java](https://www.java.com/en/download/) (any recent version will be compatible)
* Java IDE (preferably Netbeans) or other java compiling tools / software

### Installing

For convenience, a compiled JAR file is provided in the folder 'Compiled JAR'. Simply download this file to view the program.

If the code is required for development purposes, either clone or download the repository. Open this code with the IDE of your choice to compile it, or use other compiling tools.

### How To Use

* When the program is opened, click on the "Load Program" button in the centre of the screen.
* Next is a graphical interface that shows the animation of current planes. To speed up the animations, click one of the buttons in the top left.

To see passengers of current planes:
* Click on one of the "Info" buttons in the top right of the screen to open the interface for that plane.
* To see information about a specific passenger, click on a seat. A red seat is taken, a green one is empty.
* Click on the "Back to Radar" button to return to the previous screen

For plane info and booking:
* Click in the "Manage Flights" button in the bottom left of the screen.
* The two charts show the current and upcoming flights, with information about them.
* To book a new flight, click the "Book New Flight" button, and enter required information.
* To book a new passenger, click the "Book New Passenger" button, and enter required information.
* Click on the "Back to Radar" button to return to the previous screen.

### Key Features

* Graphical animation of plane icons
* Predictive arrival times based on distance
* Ability to speed up animation, will automatically adjust time
* Able to book custom flights with passenger, these flights will then be animated across the map
* Organized management of flights
* Saved log file of all activity of the program during the session

## Built With

* [Java](https://www.java.com/en/) - The language used
* [Netbeans IDE](https://netbeans.org/) - Swing GUI builder

## Authors

**Branden Lisk**

## Screenshots
![Welcome Screen](/screenshots/welcome.png?raw=true)

![Main Screen](/screenshots/main.png?raw=true)

![Booking Screen](/screenshots/booking.png?raw=true)

![Plane Info Screen](/screenshots/plane.png?raw=true)
