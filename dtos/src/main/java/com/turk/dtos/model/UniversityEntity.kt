package com.turk.dtos.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName


@Parcelize
data class UniversityEntity(
                            @SerializedName("alpha_two_code")
                            val code:String,
                            val name:String,
                            val country:String,
                            val domains:List<String>,
                            @SerializedName("web_pages")
                            val webPages:List<String>?,
                            @SerializedName("state-province")
                            val state:String?
    ):Parcelable
