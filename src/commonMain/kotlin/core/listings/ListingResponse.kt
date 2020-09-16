package core.listings

import kotlinx.serialization.Serializable

@Serializable
data class ListingResponse (val data:Data)

@Serializable
data class Data(val listings:Array<Listings>)

@Serializable
data class Listings(
    val id:Int?,
    val name:String?,
    val slug:String?,
    val state:String?,
    val best_of_weedmaps:Boolean?,
    val social_equity:Boolean?,
    val city:String?,
    val type:String?,
    val wmid:Int?,
    val latitude:Double?,
    val longitude:Double?,
    val web_url:String?,
    val package_level:String?,
    val feature_order:Int?,
    val ranking:Double?,
    val rating:Double?,
    val reviews_count:Int?,
    val avatar_image:AvatarResponse?,
    val license_type:String?,
    val address:String?,
    val distance:Double?,
    val zip_code:String?,
    val timezone:String?,
    val intro_body:String?,
//    val support_case_link:String?,
    val gofundme_link:String?,
    val static_map_url:String?,
    val open_now:Boolean?,
    val closes_in:String?,
    val todays_hours_str:String?,
    val min_age:Int?,
    val region_id:Int?,
    val menu_items_count:Int?,
    val verified_menu_items_count:Int?,
    val endorsement_badge_count:Int?,
    val is_published:Boolean?,
    val online_ordering:OnlineOrdering?,
    val retailer_services:Array<String>?,
    val has_curbside_pickup:Boolean?,
    val has_featured_deal:Boolean?

)

@Serializable
data class OnlineOrdering(
    val after_hours_enabled:Boolean?,
    val enabled_for_pickup:Boolean?,
    val enabled_for_delivery:Boolean?,
    val identification_required:Boolean?,
    val purchase_min:MoneyResponse?,
    val fee:MoneyResponse?,
    val eta_min:Int?,
    val eta_max:Int?,
    val display_eta:Boolean?,
    val wm_service_fee:MoneyResponse?
)

@Serializable
data class MoneyResponse(
    val cents:Int,
    val currency:String,
    val amount:Double
)

@Serializable
data class AvatarResponse(
    val small_url:String?,
    val original_url:String?
)
