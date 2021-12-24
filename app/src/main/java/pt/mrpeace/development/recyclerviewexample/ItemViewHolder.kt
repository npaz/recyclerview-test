package pt.mrpeace.development.recyclerviewexample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(v: View, private val onSelectedListener: OnSelectedListener<Item>)  : RecyclerView.ViewHolder(v), View.OnClickListener {
    private val numberView: TextView = v.findViewById(R.id.number)
    private val colorView: View = v.findViewById(R.id.color)
    private lateinit var item: Item

    init {
        v.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        onSelectedListener.onSelect(item)
    }


    fun bind(item: Item) {
        this.item = item
        numberView.text = item.value.toString()
        colorView.setBackgroundColor(item.color)
    }
}