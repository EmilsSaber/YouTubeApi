package kg.example.youtubeapi.ui
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kg.example.less2.Base.BaseActivity
import kg.example.youtubeapi.ImageAdapter
import kg.example.youtubeapi.databinding.ActivityPlaylistBinding
import kg.example.youtubeapi.model.PlayLists

class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, PlaylistViewModel>() {
    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }
    private var adapter = ImageAdapter()
    private var list = arrayListOf<PlayLists>()

    override fun initViewModel() {
        binding.recyclerPlaylist.adapter = adapter

        viewModel.getPlaylists().observe(this) {
            Toast.makeText(this, "kokokoo", Toast.LENGTH_SHORT).show()
            Log.d("TAG14", "initViewModel: asda")
            adapter.add(it.items)
        }
    }

    override fun inflateVB(layoutInflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }
}