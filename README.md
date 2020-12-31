# Markdown

## setUp: 1. We found that NEXUS 5X is the best performance virtual devise for our project.
          2. In build.gradle file, we put Mockito in for testing purposes.
                The following code is what we put in the build.gradle file.
                repositories { jcenter() }
                dependencies { testCompile "org.mockito:mockito-core:2.+" }
          3. Please tap Run 'app' to run this project.

## Game page for SlidingTile
    This page is the main game page for SlidingTile game. We will have the Tiles' map in the middle
    of the page, the number of tiles is your choice completely.

    There are four functions in this page:

    Playing the game
        After tapping a tile on the map, the tile will swap with the blank tile around it, but if
        there is no blank tile around the tile you tap, that means you just tapped an invalid tile.
        After the map is in row-major order, you won the game!

    Steps
        On the left-bottom corner of this page, the number of steps taken by you will be recorded
        there. Note that carefully manage your steps, since your score depends on it!

    Undo functionality
        After you tap "UNDO" button in the main game page, this functionality allows you to retrieve
         the last game stage. If you miss tapped a unwanted tile, there is always a chance for you
         to regret, we will deduct the step(s) for you.

    Quit
        Sometimes the game can be challenging, and you might want to quit the game before or after
        you win. So, if you tap the "Quit" button, we will save the game for you and quit to the
        main page.

### Game launch center:
    This page allows user to sign up or log in into the there account.

    If you didn't sign up before, you need to sign up before you play our game.
    Otherwise, you will get a error message in the message bax.

    Sign up:
        1. Clicking the sign up button.
        2. Enter username and password starting with a letter.
           Otherwise, you will get a error message in the message bax.
        3. Click sign up button, it will direct to the Game center (only sliding tile game so far)

    If you sign up before, you can log in from Game launch center.

    Log in:
        1. Clicking the log in button.
        2. Enter username and current password that you signed up.
           Otherwise, you will get a error message in the message bax.
        3. Click log in button, it will direct to the Game center (only sliding tile game so far)

### Game Center(Bonus):
    After you sign up/ log in,
    or after you choice Log Out Button in Starting page,

    you can choice a game to play in this Game Center.
    it will direct to the corresponding game starting page.

    Current Game available: SlidingTile, Mine, Sudoku.

### Starting page:
    After you choice SlidingTile game in Game Center,
    or after you choice Back to home Button in YouWin page,

    you enter Starting page.

    In Starting page, it has following feature:

        + A Massage Box with our welcome message to you.
        + A New Game Button
            - Start a new game (enter Game Setting page).
        + A Continue Button
            - Continue a previous game (load and enter a autosaved SlidingTile game)
        + A Log Out Button
            - Return to Game Launch Center.
        + A ScoreBoard Button
            - Enter Scoreboard page.
        + A Profile Button
            - Enter Profile page.

### Game Setting:
    After you choice New Game Button in Starting page,
    or After you choice Play Again Button in YouWin page,
    you enter Game Setting page.

    In Game Setting, it has following features:

        + picture background switch Button (choice game mode)
            - if switch Button is on:
                choice a picture and play SlidingTile game with given picture as background.
            - if switch Button is off:
                play a default SlidingTile game with number as background.
        + a size spinner (with size option: 3x3, 4x4(default), 5x5)
        + a confirm and play Button
            - enter SlidingTile game with mode and size you choose.

# SlidingTile game
    In SlidingTile game, it has following features:

        + Play a SlidingTile game with setting you choice with unlimited chance to undo.
        + Something happen when you solve the puzzle.
            - See a "You Win" message.
            - the Scoring system will calculate your score this game
            - go to You Win page

# Mine game
    In Mine game(or Minesweeper), the player must follow the rules that pops up after entering.
    Detailed rules for Mine:
                            1. Its a 16 * 16 board that has hidden booms under tiles, and each time
                            the player single tap will open a tile to reveal its true identity.

                            2. There are five states for one tile: Gray, Gray with flag, Number,
                            White, and pink lighting
                                Gray: This tile is yet to be opened.
                                Gray with flag: This tile is flagged to mark as a possible boom.
                                Number: This tile is safe and is opened, but there are boom(s)
                                hidden in the surrounding 3 - 8 tiles. The number of hidden booms is
                                represented by this number.
                                White: This tile is opened and safe and no boom around.
                                Pink lighting: This tile is opened and it is a boom.

                            3. The player's double tap will flag any closed(Gray) tiles or dismiss
                            an existing flag tile.

                            4. Every single safe tile must be opened and every single boom must be
                            flagged to win the game.
## Mine Setting
    There are three difficulties for Mine: Easy, Medium and Hard. The player will need to select one
    and press CONFIRM AND PLAY to enter the game.

## Mine Score
    The difficulty of this game and the efficiency of the player largely determined the score after
    he/she finish the game(if opened a boom tile, then the score is automatically -1). The player's
    initial score will be 1000 time of the number of booms(difficulty), but each second after
    confirming to play will cause a -0.5% deduction of the score, so be quick and careful!

## Mine game page
    Quit
        Sometimes the game can be challenging, and you might want to quit the game before or after
        you win. So, if you tap the "Quit" button, we will save the game for you and quit to the
        main page.


#### Scoring system:
    After you solve the puzzle, you enter Scoring system page.

    In Scoring system, it has following features:

        + calculate the score
            - score = a base score (1000) multiple by 10 to the power of (Level-3),
                      and divided by the number of moves used.

# YouWin page:
    After solving the game, you enter YouWin page.

    In YouWin page, it has following features:

        + See your score this game.
        + A Play Again button
            - Go to setting page.
        + A See Scoreboard Button
            - Enter Scoreboard page.
        + A Back to home Button
            - Back to Home page.

### Scoreboard:
    After you choose ScoreBoard Button in Starting page,
    or after you choose See Scoreboard in YouWin page,

    you enter a page to choose the game type of the score board you want to see.

    In ScoreBoard, it has following features:

        + Top1 score and username for Easy, Medium and Hard level
            - Display highest score and username for all players that have signed up and played this game.
        + Other scores and usernames for Easy, Medium and Hard level except the Top1's
            - Display all scores for all players that have signed up and played this game.
        + Game type
            - SlidingTile or Sudoku or Mine

#### Per game scoreboard: Scoreboard
    After you choose MyScore Button in Starting page,

    you enter ScoreBoard page.

    In ScoreBoard, it has following features:

        + Highest Score
            - Display current player's highest score of 3 games.

#### Profile for each player:
    At the starting page, you can see a profile button at the upper-left corner; click it you will
    be able to see your profile with information of your account like username, password and records
    We also added an avatar to represent you, BUT THAT FUNCTION IS NOT READY YET!!!