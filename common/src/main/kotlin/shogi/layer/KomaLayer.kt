package shogi.layer

import shogi.Square
import shogi.koma.Koma

open abstract class KomaLayer(squares: List<Square<Koma>>): Layer<Koma>(squares) {}