package squaregame.squares.player2;

import java.util.List;

import squaregame.Action;
import squaregame.GameBoard;
import squaregame.Player;
import squaregame.squares.SquareAction;
import squaregame.squares.SquareLogic;
import squaregame.squares.SquareLogicUtilities;

/**
 * Created by Russell on 5/5/18.
 */
public class DefaultSquare2 extends SquareLogic {

    public DefaultSquare2(Player player) {
        super(player);
    }

    @Override
    public SquareAction run(int row, int col, List<Player> view) {
        List<GameBoard.Direction> directions = SquareLogicUtilities.getEmptyDirections(view);
        if (directions.isEmpty()) {
            return new SquareAction(Action.WAIT, GameBoard.Direction.CENTER, this, new DefaultSquare2(this.player));
        }
        return new SquareAction(Action.REPLICATE, directions.get(0), this, new DefaultSquare2(this.player));
    }
}
