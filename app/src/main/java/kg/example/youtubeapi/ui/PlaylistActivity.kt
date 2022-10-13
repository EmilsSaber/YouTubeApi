package kg.example.youtubeapi.ui
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import kg.example.less2.Base.BaseActivity
import kg.example.youtubeapi.ImageAdapter
import kg.example.youtubeapi.databinding.ActivityPlaylistBinding
import kg.example.youtubeapi.data.remote.model.PlayLists
import kg.example.youtubeapi.result.Status
import kg.example.youtubeapi.utils.CheckConnectionInternet

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
            when(it.status){
                Status.SUCCESS ->{
                    binding.progress.isVisible = false
                    it.data?.items?.let { it1 -> adapter.add(it1) }
                }
                Status.ERROR -> {
                    binding.progress.isVisible = false
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    binding.progress.isVisible = true
                }
            }
        }
        CheckConnectionInternet(this).observe(this){
            binding.incInternet.conInt.isVisible = !it
        }
    }

    override fun inflateVB(layoutInflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }
}