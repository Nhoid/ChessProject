package com.chess.pieces

import com.chess.pieces.impl.Piece
import com.chess.pieces.piece.*
import com.chess.pieces.util.Codes
import com.chess.pieces.util.Coordenate
import com.chess.pieces.util.Teams
import kotlin.math.pow

class Table {

    companion object {
        val size = 8
    }


    val pieces: Array<Array<Piece?>> = Array(size) { arrayOfNulls<Piece>(size) }

    init {
        for (i in 0 until size) {
            for (j in 0 until size) {
                pieces[i][j] = if ((i + j).isEven())  Empty(symbol = Codes.emptyWhite , place = Coordenate(i,j)) else Empty(symbol = Codes.emptyBlack,place = Coordenate(i,j))
            }
        }
    }

    fun show(){
        var y: Int = 0

        for(row in pieces){
            print("Y ${y++}: ")
            for (piece in row) {
                print(piece?.symbol)
                print(" ")
            }
            println()
        }
        print("  X:")
        for(i in 0 until size){
            print("${i} ")
        }
        println()
    }

    fun getMoveFrom(place: Coordenate): List<Coordenate> {
        //Pega a peça
        val piece : Piece = this.pieces[place.y][place.x] ?: return arrayListOf(Coordenate(0, 0))

        val validMoves = ArrayList<Coordenate>()

        //Verifica se é um cavalo
        if (piece is Knight) return knightMoves(piece)[0]

        for (row in piece.possibleMoves()){
            for (move in row){

                if (pieces[move.y][move.x]?.name != "Empty" && pieces[move.y][move.x]?.team != piece.team){
                    validMoves.add(move)
                    break
                }

                validMoves.add(move)
            }
        }

        return validMoves
    }



    fun addPiece() {
        for (i in arrayOf(1,-1)) {
            //Peões
            addPawn(i)

            //Torres
            addRook(i)

            //Cavalos
            addKnight(i)

            //Bispos
            addBishop(i)

            addQueen(i)

        }
    }

    private fun addQueen(i: Int) {
        val queen = Queen(
            if (i == 1) Teams.Black else Teams.White,
            if (i == 1) "Black Queen" else "White Queen",
            if (i == 1) Codes.blackQueen else Codes.whiteQueen,
            if (i == 1) Coordenate(0, 3) else Coordenate(7, 3)
        )
        addAtPlace(queen, queen.place)
    }

    private fun addBishop(i: Int) {
        for (j in arrayOf(2, 5)) {
            val bishop: Bishop = Bishop(
                if (i == 1) Teams.Black else Teams.White,
                if (i == 1) "Black Bishop" else "White Bishop",
                if (i == 1) Codes.blackBishop else Codes.whiteBishop,
                if (i == 1) Coordenate(0, j) else Coordenate(7, j)
            )
            addAtPlace(bishop, bishop.place)
        }
    }

    private fun addKnight(i: Int) {
        for (j in 0 until 2) {
            val knight: Knight = Knight(
                if (i == 1) Teams.Black else Teams.White,
                if (i == 1) "Black Horse" else "White Horse",
                if (i == 1) Codes.blackKnight else Codes.whiteKnight,
                if (i == 1) Coordenate(0, 6.0.pow(j.toDouble()).toInt()) else Coordenate(
                    7,
                    6.0.pow(j.toDouble()).toInt()
                ),
            )
            addAtPlace(knight, knight.place)
        }
    }

    private fun addRook(i: Int) {
        for (j in 0 until 2) {
            val rook: Rook = Rook(
                if (i == 1) Teams.Black else Teams.White,
                if (i == 1) "Black Tower" else "White Tower",
                if (i == 1) Codes.blackRook else Codes.whiteRook,
                true,
                if (i == 1) Coordenate(0, j * 7) else Coordenate(7, j * 7),
            )
            addAtPlace(rook, rook.place)
        }
    }

    private fun addPawn(i: Int) {
        for (j in 0 until size) {
            val pawn = Pawn(
                true,
                if (i == 1) Teams.Black else Teams.White,
                "Pawn $j",
                if (i == 1) Codes.blackPawn else Codes.whitePawn,
                if (i == 1) Coordenate(1, j) else Coordenate(6, j),
            )
            addAtPlace(pawn, pawn.place)
        }
    }

    //Cacula os possiveis movimentos do cavalo
    private fun knightMoves(piece: Piece): ArrayList<ArrayList<Coordenate>> {

        //Pega os movimentos da peça
        val moves = piece.possibleMoves()

        moves.forEach { it -> it.filter {it -> pieces[it.y][it.x]?.team != piece.team}}

        //Filtra, saber se tem alguma peça do proprio time no lugar
        return  moves
    }

    //função auxiliar
    fun addAtPlace(piece: Piece, place: Coordenate) {
        this.pieces[place.y][place.x] = piece
    }

}

private fun Int.isEven(): Boolean = this and 1 != 0
