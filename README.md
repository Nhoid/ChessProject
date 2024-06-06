# Projeto de Xadrez em Kotlin

Este repositório contém a implementação de um jogo de xadrez desenvolvido em Kotlin. Atualmente, o jogo funciona apenas via console, mas o objetivo é, futuramente, implementar uma interface gráfica para rodar em Android, além de funcionalidades de multiplayer.

## Objetivos do Projeto

- Implementar um jogo de xadrez completo e funcional via console.
- Desenvolver toda a lógica do jogo, incluindo regras de movimentação, cheque, cheque-mate, e empate.
- Implementar um modo multiplayer.
- Futuramente, criar uma interface gráfica para rodar em dispositivos Android.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

```plaintext
chess-game/
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   ├── chess/
│   │   │   │   ├── impl/
│   │   │   │   │   └── Piece.kt //Interface
│   │   │   │   ├── pieces/
│   │   │   │   │   ├── King.kt
│   │   │   │   │   ├── Queen.kt
│   │   │   │   │   ├── Rook.kt
│   │   │   │   │   ├── Bishop.kt
│   │   │   │   │   ├── Knight.kt
│   │   │   │   │   ├── Pawn.kt
│   │   │   │   │   └── Empty.kt //Peça para preencher espaço vazio do tabuleiro
│   │   │   │   ├── util/
│   │   │   │   │   ├── Coordinates.kt
│   │   │   │   │   ├── Teams.kt
│   │   │   │   │   ├── Codes.kt
│   │   │   │   │   └── CalculateUtil.kt
│   │   │   │   ├── Table.kt
│   │   │   └── Main.kt
└── README.md
```

## Como Executar

1. Clone o repositório:

    ```bash
    git clone https://github.com/Nhoid/ChessProject.git
    ```

2. Navegue até a pasta do projeto:

    ```bash
    cd ChessProject
    ```

3. Compile e execute o projeto:

    ```bash
    ./gradlew run
    ```

## Funcionalidades Implementadas

- Calculo de todos os movimentos válidos.
- Interface via console.

## Funcionalidades Futuras

- Interface de interação.
- Implementação de um modo multiplayer.
- Desenvolvimento de uma interface gráfica para Android.
- Melhoria nas mensagens e feedbacks no console.
- Implementação de salvamento e carregamento de jogos.
