package kg.example.youtubeapi.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.example.youtubeapi.model.PlayLists
import kg.example.youtubeapi.remote.ApiServise
import kg.example.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class Repository() {

        private val apiServise: ApiServise by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): LiveData<PlayLists>{
        return getPlaylist()
    }

    private fun getPlaylist(): LiveData<PlayLists> {
        val data = MutableLiveData<PlayLists>()
        apiServise.getPlaylist().enqueue(
            object : Callback<PlayLists> {
                override fun onResponse(call: Call<PlayLists>, response: Response<PlayLists>) {
                    if (response.isSuccessful){
                        data.value = response.body()
                        Log.e("ololo", "onResponse:" + response.body() )
                    }}
                override fun onFailure(call: Call<PlayLists>, t: Throwable) {
                    Log.d("ololo", "onSuccess: else")
                }
            }
        )
        return data
    }

}