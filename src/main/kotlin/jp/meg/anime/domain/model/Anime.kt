package jp.meg.anime.domain.model

data class Anime(
        val id: Int,
        val title: String,
        val titleShort1: String,
        val titleShort2: String,
        val titleShort3: String,
        val publicUrl: String,
        val twitterAccount: String,
        val twitterHashTag: String,
        val ogp: Ogp?,
        val sex: Int,
        val cityCode: Int,
        val cityName: String,
        val sequel: Int,
        val coursId: Int,
        val createdAt: String,
        val updatedAt: String
){
    val thumnailUrl: String
        get() {
            if (ogp == null) {
                return "/sc/images/noimage.png"
            }
            return if (ogp.ogImage == "") "/sc/images/noimage.png" else ogp.ogImage
        }
}