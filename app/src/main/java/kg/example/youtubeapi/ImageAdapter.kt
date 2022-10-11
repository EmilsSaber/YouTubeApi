package kg.example.youtubeapi

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kg.example.youtubeapi.databinding.ItemPlaylistBinding
import kg.example.youtubeapi.data.remote.model.Item

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var list = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun add(list: List<Item>) {
        this.list = list as ArrayList<Item>
        Log.d("ololo","s ArrayList<Item>")

        notifyDataSetChanged()
    }

    class ImageViewHolder(private val binding: ItemPlaylistBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(playLists: Item) {
            Log.d("ololo","dkkdkddkdkdkkd")
            binding.image3.load(playLists.snippet.thumbnails.default.url)
            binding.Title.text = playLists.snippet.title
            binding.Title.setTextColor(Color.BLACK)
            binding.Title2.text = playLists.snippet.channelTitle
            binding.Title2.setTextColor(Color.BLACK)
        }
    }
}