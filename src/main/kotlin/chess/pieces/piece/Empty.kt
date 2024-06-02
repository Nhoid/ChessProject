package com.chess.pieces.piece

import com.chess.pieces.impl.Piece
import com.chess.pieces.util.Coordenate
import com.chess.pieces.util.Teams

class Empty(
    override val team: Teams = Teams.Empty,
    override val name: String = "Empty",
    override val symbol: Char,
    override var place: Coordenate
) : Piece {


    override fun doMove(place: Coordenate) {
        return
    }

    override fun possibleMoves(): ArrayList<ArrayList<Coordenate>> {
        return arrayListOf()
    }

    override fun toString(): String {
        return "Empty(name='$name')"
    }


}