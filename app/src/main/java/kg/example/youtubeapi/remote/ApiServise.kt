package kg.example.youtubeapi.remote
import kg.example.youtubeapi.model.PlayLists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServise {
    @GET("playlists")
    fun getPlaylist(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
    ): Call<PlayLists>
}