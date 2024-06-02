package com.chess.pieces.impl

import com.chess.pieces.util.Coordenate
import com.chess.pieces.util.Teams

interface Piece {
    val team : Teams

    val name : String

    val symbol: Char

    var place: Coordenate

    fun doMove(place: Coordenate)

    fun possibleMoves(): ArrayList<ArrayList<Coordenate>>


}