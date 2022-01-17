package pt.mrpeace.development.recyclerviewexample

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(v: View, private val onSelectedListener: OnSelectedListener<Item>)  : RecyclerView.ViewHolder(v) {
    private val numberView: TextView = v.findViewById(R.id.number)
    private val colorView: View = v.findViewById(R.id.color)
    private val selected_icon: View = v.findViewById(R.id.selected_icon)
    private lateinit var item: Item

    fun bind(item: Item, isSelected: Boolean) {
        this.item = item
        numberView.text = item.value.toString()
        if(isSelected)
        {
            numberView.setTextColor(item.color)
        }else
        {
            numberView.setTextColor(Color.BLACK)
        }

        colorView.setBackgroundColor(item.color)
        selected_icon.isVisible = isSelected
    }
}