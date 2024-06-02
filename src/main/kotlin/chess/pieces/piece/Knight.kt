package com.chess.pieces.piece

import com.chess.pieces.impl.Piece
import com.chess.pieces.util.Coordenate
import com.chess.pieces.util.Teams

class Knight(
    override val team: Teams,
    override val name: String,
    override val symbol: Char,
    override var place: Coordenate
) : Piece {
    override fun doMove(place: Coordenate) {
        this.place = place
    }

    override fun possibleMoves(): ArrayList<ArrayList<Coordenate>> {

        val moves: ArrayList<Coordenate> = ArrayList<Coordenate>()

        for(i in arrayOf(1,-1)){
            //Cria os movimentos pra cima e para baixo do cavalo
            try {
                val moveLeft: Coordenate = Coordenate(place.y-1, place.x+(2*i))
                moves.add(moveLeft)
            } catch (e: IllegalArgumentException) {
                continue
            }
            try {
                val moveRight: Coordenate = Coordenate(place.y+1, place.x+(2*i))
                moves.add(moveRight)
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
        for(i in arrayOf(1,-1)){
            //Cria os movimentos da esquerda e direita do cavalo
            try {
                val moveLeft: Coordenate = Coordenate(place.y + (2*i), place.x+1)
                moves.add(moveLeft)
            } catch (e: IllegalArgumentException) {
                continue
            }
            try {
                val moveRight: Coordenate = Coordenate(place.y + (2*i), place.x-1)
                moves.add(moveRight)
            } catch (e: IllegalArgumentException) {
                continue
            }
        }

        return arrayListOf(moves)
    }

    override fun toString(): String {
        return "Knight(name='$name')"
    }


}