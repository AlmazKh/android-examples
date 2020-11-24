package com.almaz.examples

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Joke(
    @SerializedName("id")
    var id: String,
    @SerializedName("joke")
    var text: String,
    @SerializedName("status")
    var status: Int
) : Parcelable
