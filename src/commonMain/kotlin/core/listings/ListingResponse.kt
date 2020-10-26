package core.listings

import kotlinx.serialization.Serializable

@Serializable
data class ListingResponse (val data:Data)

@Serializable
data class Data(val listings:Array<Listing>)

@Serializable
data class Listing(
    val id:Int? = null,
    val name:String? = null,
    val slug:String? = null,
    val state:String? = null,
    val best_of_weedmaps:Boolean? = null,
    val social_equity:Boolean? = null,
    val city:String? = null,
    val type:String? = null,
    val wmid:Int? = null,
    val latitude:Double? = null,
    val longitude:Double? = null,
    val web_url:String? = null,
    val package_level:String? = null,
    val feature_order:Int? = null,
    val ranking:Double? = null,
    val rating:Double? = null,
    val reviews_count:Int? = null,
    val avatar_image:AvatarResponse? = null,
    val license_type:String? = null,
    val address:String? = null,
    val distance:Double? = null,
    val zip_code:String? = null,
    val timezone:String? = null,
    val intro_body:String? = null,
//    val support_case_link:String?,
    val gofundme_link:String? = null,
    val static_map_url:String? = null,
    val open_now:Boolean? = null,
    val closes_in:String? = null,
    val todays_hours_str:String? = null,
    val min_age:Int? = null,
    val region_id:Int? = null,
    val menu_items_count:Int? = null,
    val verified_menu_items_count:Int? = null,
    val endorsement_badge_count:Int? = null,
    val is_published:Boolean? = null,
    val online_ordering:OnlineOrdering? = null,
    val retailer_services:Array<String>? = null,
    val has_curbside_pickup:Boolean? = null,
    val has_featured_deal:Boolean? = null

)

@Serializable
data class OnlineOrdering(
    val after_hours_enabled:Boolean? = null,
    val enabled_for_pickup:Boolean? = null,
    val enabled_for_delivery:Boolean? = null,
    val identification_required:Boolean? = null,
    val purchase_min:MoneyResponse? = null,
    val fee:MoneyResponse? = null,
    val eta_min:Int? = null,
    val eta_max:Int? = null,
    val display_eta:Boolean? = null,
    val wm_service_fee:MoneyResponse? = null
)

@Serializable
data class MoneyResponse(
    val cents:Int?  = null,
    val currency:String? = null,
    val amount:Double? = null
)

@Serializable
data class AvatarResponse(
    val small_url:String?,
    val original_url:String?
)
