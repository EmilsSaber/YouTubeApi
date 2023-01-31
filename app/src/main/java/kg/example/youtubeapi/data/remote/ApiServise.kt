package kg.example.youtubeapi.data.remote
import kg.example.youtubeapi.utils.Constant
import kg.example.youtubeapi.data.remote.model.PlayLists
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServise {
    @GET("playlists")
    fun getPlaylist(
        @Query("key") apiKey: String = Constant.apiKey,
        @Query("part") part: String = Constant.part,
        @Query("channelId") channelId: String = Constant.channelId,
    ): Call<PlayLists>
}