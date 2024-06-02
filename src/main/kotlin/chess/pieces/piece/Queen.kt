package com.chess.pieces.piece

import com.chess.pieces.Table
import com.chess.pieces.impl.Piece
import com.chess.pieces.util.CalculateUtil
import com.chess.pieces.util.Coordenate
import com.chess.pieces.util.Teams
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Queen(
    override val team: Teams,
    override val name: String,
    override val symbol: Char,
    override var place: Coordenate
): Piece {
    override fun doMove(place: Coordenate) {
        this.place = place
    }

    override fun possibleMoves(): ArrayList<ArrayList<Coordenate>> {

        //Calcula os movimentos diagonais
        val moves = CalculateUtil.diagonalAllMoves(place)

        //movimentos horizontais e verticais
        moves.addAll(CalculateUtil.lineAllMoves(place))

        return moves
    }


}