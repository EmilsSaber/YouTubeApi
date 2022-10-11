package kg.example.youtubeapi.ui

import androidx.lifecycle.MutableLiveData
import kg.example.youtubeapi.App
import kg.example.youtubeapi.core.ui.BaseViewModel
import kg.example.youtubeapi.data.remote.model.PlayLists
import kg.example.youtubeapi.result.Resource

class PlaylistViewModel : BaseViewModel() {

    fun getPlaylists(): MutableLiveData<Resource<PlayLists>> {
        return App().repository.getPlaylists()
    }
}