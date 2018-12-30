# CS-170 - Final Project
Contributors: Alan Huang, Eric Jin, Kevin Le\
Instructor: Paul Oser\
Oxford College of Emory University

Dependencies: Java Development Kit 1.8.0, AppletViewer (Included)

## Preface
This project idea was inspired by and developed shortly after the release ofthe popular mobile game *Fire Emblem Heroes* by Nintendo.

## Usage Guide
On Windows, simply download the Final Project folder and execute *run.bat* to demo the project.
The instructions window should appear. Confirm the dialogue box to continue.<br/><br/>
![Instructions](/Documentation/instructions.PNG)

The main window is composed of 3 components: Turn Counter, Game Interface, and Information. Data such as Player and Enemy hitpoints, status, and dialogue will be displayed in the Information section when relevant. Otherwise, all user interaction is currently performed on the Game Interface section.<br/><br/>
![User Interface](/Documentation/gameplay.PNG)

When all win conditions are met, the user will be greeted by the endgame screen. The user will need to manually exit the game by closing the game window (see ***Known Issues***).\
\
![Endgame](/Documentation/endgame.PNG)

## Gameplay Mechanics
<img src="Documentation/marth.png" align=right width=120>
The objective of the game is to control the player character and defeat all enemies on the map. The enemy units are denoted by fruits. The current version of the game includes an apple, orange, and cherry enemy type that each have different stats for hitpoints and attack power.
<br/>
<br/>
To control the player character, first click on the character **Marth**, depicted to the right of this description. Marth can move 2 spaces in any direction, although he is affected by terrain. To attack an enemy, simply move Marth onto a space occupied by an enemy and a battle will occur.
<br/><br/>
Afterwards, the HP of the player and enemy will be updated. A unit is defeated when its HP reaches zero. To win, defeat all the enemies!

## Known Issues
1. System.exit(0) does not work in AppletViewer or modern browsers. The user must close the application manually.

2. The player unit is normally not allowed to move in an L formation (similar to a knight in chess); however, when an enemy unit is in the specified location, the player will break said rule. The cause of this inconsistency has not yet been found.

3. The current iteration of the game does not have a loss condition. This is because the current mechanics of the game do not allow the player to lose, as the player unit statistically outclasses the three enemies combined.
