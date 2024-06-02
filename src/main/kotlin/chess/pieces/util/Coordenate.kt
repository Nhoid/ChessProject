package com.chess.pieces.util

class Coordenate(var y: Int, var x: Int) {

//Verifica se x e y são coordenadas validas para um tabuleiro de xadrez
    init {
        if (x > 7 || x < 0) throw IllegalArgumentException("x must be between 0 and 7")
        if (y > 7 || y < 0) throw IllegalArgumentException("y must be between 0 and 7")
    }

    override fun toString(): String {
        return "Coordenate(x=$x, y=$y)"
    }


}