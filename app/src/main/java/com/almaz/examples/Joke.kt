package com.almaz.examples

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("id")
    var id: String,
    @SerializedName("joke")
    var text: String,
    @SerializedName("status")
    var status: Int
)
