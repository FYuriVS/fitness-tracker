package com.yurivital.fitness

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yurivital.fitness.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var rvMain: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.ic_baseline_wb_sunny_24,
                textStringId = R.string.imc,
                color = Color.GREEN
            ),
        )
        mainItems.add(
                MainItem(
                    id = 2,
                    drawableId = R.drawable.baseline_visibility_24,
                    textStringId = R.string.tmb,
                    color = Color.RED
                ),
        )

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = MainAdapter(mainItems)
        rvMain = binding.rvMain
        rvMain.adapter = adapter
        rvMain.layoutManager = GridLayoutManager(this, 2)

    }

    private inner class MainAdapter(private val mainItems: List<MainItem>) : RecyclerView.Adapter<MainViewlHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewlHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewlHolder(view)
        }

        override fun onBindViewHolder(holder: MainViewlHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

        override fun getItemCount(): Int {
           return mainItems.size
        }
    }

    private class MainViewlHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MainItem){
            val img: ImageView = itemView.findViewById(R.id.item_img_icon)
            val name: TextView = itemView.findViewById(R.id.item_txt_name)
            val container: LinearLayout = itemView.findViewById(R.id.item_container_imc)

            img.setImageResource(item.drawableId)
            name.setText(item.textStringId)
            container.setBackgroundColor(item.color)
        }
    }


}