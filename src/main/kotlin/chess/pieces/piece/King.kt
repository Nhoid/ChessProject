//package com.chess.pieces.piece
//
//import com.chess.pieces.impl.Piece
//import com.chess.pieces.util.Coordenate
//import com.chess.pieces.util.Teams
//
//class King(
//    override val team: Teams,
//    override val name: String,
//    override val symbol: Char,
//    override var place: Coordenate,
//    var firstMove: Boolean = true
//): Piece {
//    override fun doMove(place: Coordenate) {
//        this.place = place
//        if (this.firstMove) this.firstMove = false
//    }
//
//    override fun possibleMoves(): ArrayList<ArrayList<Coordenate>> {
//
//        val moves: ArrayList<ArrayList<Coordenate>> = arrayListOf()
//
//
//        for(i in arrayOf(1,-1)) {
//            for (j in arrayOf(1,-1)) {
//
//                val diagonal: ArrayList<Coordenate> = ArrayList()
//
//
//
//
//                moves.add(diagonal)
//
//                if (i == j) {
//
//                    val line: ArrayList<Coordenate> = ArrayList()
//
//
//
//
//
//                    moves.add(line)
//                }
//            }
//        }
//    }
//
//}