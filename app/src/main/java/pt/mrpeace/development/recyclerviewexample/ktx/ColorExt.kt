package pt.mrpeace.development.recyclerviewexample

import android.graphics.Color

fun Color.getTextColor(): Int {
    val t = 150/255f
    return if (this.red() >=t|| this.green() >= t  || this.blue() >= t) {
        Color.BLACK
    } else {
        Color.WHITE
    }
}