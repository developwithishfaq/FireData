package com.easy.firedata.ads

import com.easy.firedata.configs.FireAdConfigs
import com.easy.firedata.sdk.FireDataSdk

object FireAdsExtensions {

    fun FireDataSdk.onAdLoaded(
        userId: String,
        adId: String,
        adKey: String,
        adType: String,
        dataMap: HashMap<String, String>
    ) {
        onAdCustomEvent(
            userId = userId,
            adId = adId,
            adKey = adKey,
            adType = adType,
            historyType = "loaded",
            dataMap = HashMap(dataMap),
        )
    }

    fun FireDataSdk.onAdFailed(
        userId: String,
        adId: String,
        adKey: String,
        adType: String,
        errorCode: Int,
        message: String,
        dataMap: HashMap<String, String>
    ) {
        val map = hashMapOf(
            FireAdConfigs.ErrorCodeKey to errorCode.toString(),
            FireAdConfigs.MessageKey to message
        )
        onAdCustomEvent(
            userId = userId,
            adId = adId,
            adKey = adKey,
            adType = adType,
            historyType = "failed",
            dataMap = HashMap(map + dataMap),
        )
    }

    fun FireDataSdk.onAdImpression(
        userId: String,
        adId: String,
        adKey: String,
        adType: String,
        dataMap: HashMap<String, String>
    ) {
        onAdCustomEvent(
            userId = userId,
            adId = adId,
            adKey = adKey,
            adType = adType,
            historyType = "impression",
            dataMap = dataMap,
        )
    }

    fun FireDataSdk.onAdClick(
        userId: String,
        adId: String,
        adKey: String,
        adType: String,
        dataMap: HashMap<String, String>
    ) {
        onAdCustomEvent(
            userId = userId,
            adId = adId,
            adKey = adKey,
            adType = adType,
            historyType = "click",
            dataMap = dataMap,
        )
    }

    fun FireDataSdk.onAdRevenue(
        userId: String,
        adId: String,
        adKey: String,
        adType: String,
        revenueMicros: Long,
        currency: String,
        dataMap: HashMap<String, String>
    ) {
        val revenueInDollars = revenueMicros / 1_000_000.0
        onAdCustomEvent(
            userId = userId,
            adId = adId,
            adKey = adKey,
            adType = adType,
            historyType = "revenue",
            dataMap = HashMap(
                dataMap + mapOf(
                    FireAdConfigs.RevenueCurrencyKey to currency,
                    FireAdConfigs.RevenueAmountKey to revenueInDollars.toString(),
                )
            ),
        )
    }

    fun FireDataSdk.onAdRequested(
        userId: String,
        adId: String,
        adKey: String,
        adType: String,
        dataMap: HashMap<String, String>
    ) {
        onAdCustomEvent(
            userId,
            adId,
            adKey,
            adType,
            "request",
            dataMap,
        )
    }
}