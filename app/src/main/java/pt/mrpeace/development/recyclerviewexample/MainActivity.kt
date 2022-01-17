package pt.mrpeace.development.recyclerviewexample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), OnSelectedListener<Item> {
    private val rnd = Random()

    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = generateItem(20000)

        list.layoutManager = GridLayoutManager(this,5,RecyclerView.VERTICAL,false)

        add_one.setOnClickListener {
            adapter.addItems(1,generateItem(1))
        }


        add_more.setOnClickListener {
            adapter.addItems(2,generateItem(10))
        }

        adapter = ItemAdapter(items, this)
        list.adapter = adapter
    }

    private fun generateItem(elements: Int): ArrayList<Item> {
        val list = ArrayList<Item>()
        for (i in 1..elements) {
            list.add(
                Item(
                    rnd.nextInt(100),
                    Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                )
            )
        }
        return list
    }

    override fun onSelect(item: Item) {
        header_text.text = item.value.toString()
        header_text.setBackgroundColor(item.color)
        header_text.setTextColor(Color.valueOf(item.color).getTextColor())
    }
}