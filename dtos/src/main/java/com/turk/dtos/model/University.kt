package com.turk.dtos.model

import android.os.Parcelable
import androidx.annotation.NonNull
import kotlinx.parcelize.Parcelize
import androidx.recyclerview.widget.DiffUtil



@Parcelize
data class University(
    val universityCode:String,
    val universityName:String,
    val country:String,
    val webpages:String,
    val stateOrProvinceName:String?="NA",
):Parcelable{

    companion object {

        val DIFF_CALLBACK: DiffUtil.ItemCallback<University> =
            object : DiffUtil.ItemCallback<University>() {
                override fun areItemsTheSame(
                    @NonNull oldItem: University,
                    @NonNull newItem: University
                ): Boolean {
                    return oldItem.universityCode == newItem.universityCode
                }

                override fun areContentsTheSame(
                    @NonNull oldItem: University,
                    @NonNull newItem: University
                ): Boolean {
                    return oldItem == newItem
                }
            }


    }
    fun getStateName(): String = stateOrProvinceName?:"NA"
}
