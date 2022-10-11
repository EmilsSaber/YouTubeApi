package kg.example.youtubeapi.data.remote.model

data class PlayLists(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val pageInfo: PageInfo
)