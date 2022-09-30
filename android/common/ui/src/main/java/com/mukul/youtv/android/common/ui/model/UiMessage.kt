package com.mukul.youtv.android.common.ui.model

import androidx.annotation.StringRes
import java.util.*

sealed class UiMessage(
    val id: Long = UUID.randomUUID().mostSignificantBits,
    val type: UiMessageType = UiMessageType.Simple,
    val message: String = "",
    @StringRes val stringRes: Int = 0,
) {
    object EMPTY: UiMessage()
}

sealed class UiMessageType {
    object Simple: UiMessageType()
    object Resource: UiMessageType()
}
