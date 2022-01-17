package pt.mrpeace.development.recyclerviewexample

import android.view.*
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: ArrayList<Item>, private val onSelectedListener: OnSelectedListener<Item>) : RecyclerView.Adapter<ItemViewHolder>()  {
    var selectedPosition = 0

    init {
        onSelectedListener.onSelect(items[selectedPosition])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false) as View
        return ItemViewHolder(view, onSelectedListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position],selectedPosition==position)

        holder.itemView.setOnClickListener {
            val oldPosition = selectedPosition
            onSelectedListener.onSelect(items[position])
            selectedPosition = position
            notifyItemChanged(oldPosition)
            notifyItemChanged(selectedPosition)
        }
    }

    override fun getItemCount(): Int = items.size

    fun addItems(startPosition:Int,newItems: ArrayList<Item>)
    {
        items.addAll(startPosition,newItems)
        notifyItemChanged(selectedPosition)
        this.notifyItemRangeInserted(startPosition,newItems.size*2)
    }
}