package kg.example.youtubeapi.ui
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.example.youtubeapi.App
import kg.example.youtubeapi.base.BaseViewModel
import kg.example.youtubeapi.model.PlayLists
import kg.example.youtubeapi.remote.ApiServise
import kg.example.youtubeapi.remote.RetrofitClient
import kg.example.youtubeapi.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    fun getPlaylists(): LiveData<PlayLists>{
        return App().repository.getPlaylists()
    }
}