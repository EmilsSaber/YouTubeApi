package kg.example.youtubeapi.ui
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kg.example.less2.Base.BaseActivity
import kg.example.youtubeapi.R
import kg.example.youtubeapi.databinding.ActivityPlaylistBinding

class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, PlaylistViewModel>(){
    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)
    }

    override fun initViewModel() {
        viewModel.getPlaylist().observe(this){
            Toast.makeText(this, "kokokoo", Toast.LENGTH_SHORT).show()
            Log.d("TAG14", "initViewModel: asda")
    }

    }
    override fun inflateVB(layoutInflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

}