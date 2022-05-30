package app.ifnyas.lunarorigins.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import app.ifnyas.lunarorigins.R
import app.ifnyas.lunarorigins.model.Lunar
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class LunarListAdapter(private val items: ArrayList<Lunar>) :
    RecyclerView.Adapter<LunarListAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(item: Lunar)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardLunar: MaterialCardView = itemView.findViewById(R.id.card_lunar)
        var tvLunar: MaterialTextView = itemView.findViewById(R.id.tv_lunar)
        var ivLunar: AppCompatImageView = itemView.findViewById(R.id.iv_lunar)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = items[position]
        holder.tvLunar.text = item.name
        holder.ivLunar.setImageResource(item.image ?: R.drawable.logo)
        holder.cardLunar.setOnClickListener {
            onItemClickCallback.onItemClicked(item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lunar, parent, false)
        )

    override fun getItemCount(): Int = items.size
}