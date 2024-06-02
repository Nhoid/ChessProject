package com.chess.pieces.piece

import com.chess.pieces.Table
import com.chess.pieces.impl.Piece
import com.chess.pieces.util.CalculateUtil
import com.chess.pieces.util.Coordenate
import com.chess.pieces.util.Teams
import kotlin.math.min
import kotlin.math.abs
import kotlin.math.max

class Bishop(
    override val team: Teams,
    override val name: String,
    override val symbol: Char,
    override var place: Coordenate
) : Piece {

    override fun doMove(place: Coordenate) {
        this.place = place
    }

    override fun possibleMoves(): ArrayList<ArrayList<Coordenate>> {

        return CalculateUtil.diagonalAllMoves(place)
    }


}