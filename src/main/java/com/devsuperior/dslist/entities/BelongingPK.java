package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable //Encapsula atributos em uma classe só
public class BelongingPK {
    
    @ManyToOne // mapeamento da jpa para relacionamento N-N (muitos para muitos)
    @JoinColumn(name = "game_id") // define o nome da coluna
    private Game game; 
    
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList List;

    public BelongingPK() {

    }

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		List = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return List;
	}

	public void setList(GameList list) {
		List = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + ((List == null) ? 0 : List.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		if (List == null) {
			if (other.List != null)
				return false;
		} else if (!List.equals(other.List))
			return false;
		return true;
	}

    

}
