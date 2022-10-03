package kg.example.youtubeapi.ui
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.example.youtubeapi.base.BaseViewModel
import kg.example.youtubeapi.model.PlayLists
import kg.example.youtubeapi.remote.ApiServise
import kg.example.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    private val apiServise: ApiServise by lazy {
        RetrofitClient.create()
    }
    fun getPlaylist(): LiveData<PlayLists>{
        return playlist()
    }

    private fun playlist(): LiveData<PlayLists> {
        val data = MutableLiveData<PlayLists>()
        apiServise.getPlaylist("AIzaSyBAeAl45ErPy2WBm8bL0YbcMEeSm-IcYFg", "contentDetails,snippet", "UC2Ru64PHqW4FxoP0xhQRvJg").enqueue(
            object : Callback<PlayLists>{
                override fun onResponse(call: Call<PlayLists>, response: Response<PlayLists>) {
                    if (response.isSuccessful){
                    data.value = response.body()
                    Log.e("ololo", "onResponse: ", )
                }}

                override fun onFailure(call: Call<PlayLists>, t: Throwable) {
                    Log.d("ololo", "onSuccess: else")
                }
            }
        )
       return data
    }
}