# Undertale mini-game 

This Game was inspired by the interaction whichs occurs after you cast an attack in the videogame Undertale.

[![Game Demo](https://j.gifs.com/Jyn5m2.gif)](https://gifs.com/gif/game-demo-Jyn5m2)

## Gameplay

The gameplay is pretty simple : A bar is sliding from an edge of the screen to another repeatedly, there is a size-diminishing box in the center of the screen, and you have to press the spacebar button at the right moment (when the bar is on the box) to score a point. The more points you score, the faster the bar moves. You have 3 lives, everytime you miss the box you lose a life unit. Upon losing your third life point, you lose.

All the scores are stored in a sqlite Database file in the "DB" directory. The database API used to display highscores is jdbc (added in the lib directory).

## Installation

You can either use the implementable eclipse project in the Eclipse IDE :
1. Clone this repository
2. Extract the implementable eclipse project
3. In an Eclipse workspace, create a new Java Project. Uncheck "use default location" and browse your extracted "Undertale-mini-game" folder instead
4. Launch as a Java application

Or build the project yourself with the source code :
1. Copy the source code folder in a JavaFX project
2. Add the main libraries to your project : System and JavaFX libraries
3. Copy the lib and DB folders to the base of your project
 
 

