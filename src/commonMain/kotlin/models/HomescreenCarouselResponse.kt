package models

import kotlinx.serialization.Serializable

@Serializable
data class HomescreenCarouselResponse(val data:Data)

@Serializable
data class Data(
    val carousel:List<Carousel>
)

@Serializable
data class Carousel (val click_url:String)
