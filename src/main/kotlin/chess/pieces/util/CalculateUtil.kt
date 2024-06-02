package com.chess.pieces.util

import com.chess.pieces.Table
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class CalculateUtil {

    companion object{

        fun diagonalAllMoves(place: Coordenate): ArrayList<ArrayList<Coordenate>>{

            val moves = ArrayList<ArrayList<Coordenate>>()

            for(i in arrayOf(1,-1)){
                for (j in arrayOf(1,-1)){

                    val coordinates: ArrayList<Coordenate> = ArrayList()

                    var counter: Int = 1

                    while(true) {

                        if (counter > calculateDiagonalLimit(j, i, place)) break

                        try {
                            val move: Coordenate = Coordenate(abs((j * place.y) + counter), abs((i * place.x) + counter))

                            coordinates.add(move)

                            counter++
                        } catch (e: IllegalArgumentException) {
                            break
                        }
                    }
                    moves.add(coordinates)
                }
            }

            return moves
        }



        fun lineAllMoves(place: Coordenate): ArrayList<ArrayList<Coordenate>> {

            val moves = ArrayList<ArrayList<Coordenate>>()

            moves.add(xMove(0, place.x, place))
            moves.add(xMove(place.x, 8 , place))
            moves.add(yMove(0, place.y, place))
            moves.add(yMove(place.y, 8 , place))

            return moves
        }



        //Calcular Limite de movimento diagonal
        private fun calculateDiagonalLimit(directionY: Int, directionX: Int, place: Coordenate): Int {
            return when {
                directionY < 0 -> when {
                    directionX < 0 -> min(place.y, place.x)  // Cima-Esquerda
                    directionX > 0 -> max(place.x ,place.y)  // Cima-Direita
                    else -> throw IllegalArgumentException("Invalid directionX value")
                }
                directionY > 0 -> when {
                    directionX < 0 -> max(place.y, place.x)  // Baixo-Esquerda
                    directionX > 0 -> max(Table.size-place.x, Table.size-place.y)  // Baixo-Direita
                    else -> throw IllegalArgumentException("Invalid directionX value")
                }
                else -> throw IllegalArgumentException("Invalid directionY value")
            }
        }


        //Cacular movimentos verticais
        private fun xMove(from: Int, to: Int, place: Coordenate) : ArrayList<Coordenate> {
            val coordenates: ArrayList<Coordenate> = ArrayList()

            for (i in from until to) {
                val move = Coordenate(i, place.x)
                coordenates.add(move)
            }

            return coordenates
        }

        //calcular movimentos horizontais
        private fun yMove(from: Int, to: Int, place: Coordenate) : ArrayList<Coordenate> {
            val coordenates: ArrayList<Coordenate> = ArrayList()

            for (i in from until to) {
                val move = Coordenate(place.y, i)
                coordenates.add(move)
            }

            return coordenates
        }
    }

}