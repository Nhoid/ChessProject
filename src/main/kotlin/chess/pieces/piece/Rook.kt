package com.chess.pieces.piece

import com.chess.pieces.impl.Piece
import com.chess.pieces.util.CalculateUtil
import com.chess.pieces.util.Coordenate
import com.chess.pieces.util.Teams

class Rook (
    override val team: Teams,
    override val name: String,
    override val symbol: Char,
    var firstMove: Boolean,
    override var place: Coordenate
) : Piece {

    override fun doMove(place: Coordenate) {
        if (this.firstMove) this.firstMove = false
        this.place = place
    }

    override fun possibleMoves(): ArrayList<ArrayList<Coordenate>> {

        //Possiveis movimentos da torre
        return CalculateUtil.lineAllMoves(place)
    }

    override fun toString(): String {
        return "Rook(name='$name')"
    }



}