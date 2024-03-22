package DAOs;

import java.util.List;

import DTOs.Games;
import Exceptions.DaoException;

public interface GamesDaoInterface
{
    public List<Games> findAllGames() throws DaoException;
    public Games findGameByID(int game_ID) throws DaoException;
    public Games deleteGameByID(int game_id) throws DaoException;
    public void insertGame(Games games) throws DaoException;
}
