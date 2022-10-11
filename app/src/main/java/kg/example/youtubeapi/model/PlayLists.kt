package kg.example.youtubeapi.model

data class PlayLists(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val pageInfo: PageInfo
)