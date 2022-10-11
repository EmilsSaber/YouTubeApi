package kg.example.youtubeapi.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kg.example.youtubeapi.data.remote.model.PlayLists
import kg.example.youtubeapi.data.remote.ApiServise
import kg.example.youtubeapi.core.remote.RetrofitClient
import kg.example.youtubeapi.result.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class Repository {

        private val apiService: ApiServise by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): MutableLiveData<Resource<PlayLists>> {
        return getPlaylist()
    }

    private fun getPlaylist(): MutableLiveData<Resource<PlayLists>> {
        val data = MutableLiveData<Resource<PlayLists>>()
        data.value = Resource.loading()
        apiService.getPlaylist().enqueue(
            object : Callback<PlayLists> {
                override fun onResponse(call: Call<PlayLists>, response: Response<PlayLists>) {
                    if (response.isSuccessful){
                        data.value = Resource.success(response.body())
                        Log.e("ololo", "onResponse:" + response.body() )
                    }}
                override fun onFailure(call: Call<PlayLists>, t: Throwable) {
                    Log.d("ololo", "onSuccess: else")
                    data.value = Resource.error( null,t.message)
                }
            }
        )
        return data
    }

}