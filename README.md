# Undertale mini-game 

This Game was inspired by the interaction whichs occurs after you cast an attack in the videogame Undertale.  

![Undertale illustration](https://lparchive.org/Undertale/Update%2042/25-3635.gif)

## Gameplay

The gameplay is pretty simple : A bar is sliding from an edge of the screen to another repeatedly, there is a size-diminishing box in the center of the screen, and you have to press the spacebar button at the right moment (when the bar is on the box) to score a point. The more points you score, the faster the bar moves. You have 3 lives, everytime you miss the box you lose a life unit. Upon losing your third life point, you lose.

All the scores are stored in a sqlite Database file in the "DB" directory. The database API used to display highscores is jdbc (added in the lib directory).

## Installation

1. Clone this repository
2. Extract the implementable source code 
2. In an Eclipse workspace, create a new Java Project. Uncheck "use default location" and browse your extracted "Undertale-mini-game" folder instead
3. Launch as a Java application
4. Enjoy the game ! :D
