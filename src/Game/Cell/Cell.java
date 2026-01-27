package Game.Cell;

import Game.GameEntity;
import Game.Position;

public abstract class Cell extends GameEntity {
    private CellState state = CellState.Hidden;
    public String symbol;

    public Cell(Position pos) {
        super(pos);
    }

    public CellState getState() {
        return state;
    }

    protected void setState(CellState state) {
        this.state = state;
    }

    public boolean Flag() {
        // Se já foi revelada, não faça nada
        if (getState() == CellState.Revealed) return false;
        else if (getState() == CellState.Hidden) setState(CellState.Flagged);
        return false;
    }

    public void UnFlag() {
        if (getState() == CellState.Flagged) setState(CellState.Hidden);
    }

    public abstract boolean Reveal();

    @Override
    public String toString() {
        return switch (getState()) {
            case Revealed -> "[" + symbol + "]";
            case Flagged -> "[P]";
            default -> "[ ]";
        };
    }
}
