package com.core.filterframe.model

data class RatioFilter(
    var ratio: Float = -1f,
    var name: String = "",
    var resId: Int = 0,
    var isSelected: Boolean = false
)