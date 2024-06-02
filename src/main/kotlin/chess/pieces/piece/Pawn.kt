package com.chess.pieces.piece

import com.chess.pieces.impl.Piece
import com.chess.pieces.util.Coordenate
import com.chess.pieces.util.Teams

class Pawn(
    var firsMove: Boolean = true,
    override val team: Teams,
    override val name: String,
    override val symbol: Char,
    override var place: Coordenate
) : Piece {

    override fun doMove(place: Coordenate) {
        if (this.firsMove) this.firsMove = false
        this.place = place
    }

    override fun possibleMoves(): ArrayList<ArrayList<Coordenate>> {

        //Possiveis movimentos do peão, caso seja o primeiro movimento
        if (this.firsMove){
            return arrayListOf( arrayListOf(
                Coordenate(1, this.place.y + (1*team.i)),
                Coordenate(1, this.place.y + (2*team.i))
            ) )
        }

        //Caso não seja o primeiro
        return arrayListOf( arrayListOf(Coordenate(1, this.place.y + (1*team.i))) )
        
    }

    override fun toString(): String {
        return "Pawn(name='$name')"
    }

//    fun transform(piece: Piece): Piece {
//
//    }


}