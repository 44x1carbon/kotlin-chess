package shogi.layer

import shogi.Grid
import shogi.koma.Koma

open abstract class KomaLayer(grids: List<Grid<Koma>>): Layer<Koma>(grids) {}