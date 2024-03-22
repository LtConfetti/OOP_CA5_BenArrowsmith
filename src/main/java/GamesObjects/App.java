package GamesObjects;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import DAOs.MySqlGamesDao;
import DAOs.GamesDaoInterface;
import DTOs.Games;
import Exceptions.DaoException;


public class App
{
    public static void main(String[] args)
    {
        GamesDaoInterface IUserDao = new MySqlGamesDao();

        try
        {
            System.out.println("\nCall findAllGames()");
            List<Games> games = IUserDao.findAllGames();

            if( games.isEmpty() )
                System.out.println("There are no Games");
            else {
                for (Games game : games)
                    System.out.println("User: " + game.toString());
            }

            System.out.println("\nCall findGameByID");
            int gameId = 110;

            Games game = IUserDao.findGameByID(gameId);

            if( game != null ) // null returned if userid and password not valid
                System.out.println("Game found: " + game);
            else
                System.out.println("Game with that ID not found");


            System.out.println("\nCall deleteGameByID");
            int gameToDeleteId = 111;

            Games deletedGame = IUserDao.deleteGameByID(gameToDeleteId);

            if (deletedGame != null)
                System.out.println("Deleted Game: " + deletedGame);
            else
                System.out.println("No game to delete :<");
            System.out.println("\nCall insertGame");
            IUserDao.insertGame(new Games(959, "bluhbluh", "99", 23, 473, new Date(364738274)));
        }
        catch(DaoException e )
        {
            e.printStackTrace();
        }
    }
}

