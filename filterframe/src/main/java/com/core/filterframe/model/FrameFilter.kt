package com.core.filterframe.model

data class FrameFilter(
    var numberList: MutableList<Int> = mutableListOf(),
    var ratioList: MutableList<RatioFilter> = mutableListOf()
) {
    fun isSelected(): Boolean {
        return numberList.isNotEmpty() || ratioList.find { it.isSelected } != null
    }
}