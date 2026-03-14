package com.example.navigationcomponents.model

import android.os.Parcel
import android.os.Parcelable
import java.math.BigDecimal

data class Money(val amount: BigDecimal) : Parcelable {
    // Parcelable is used to pass data/ even: 'Class' between fragments
    constructor(parcel: Parcel) : this(BigDecimal(0)){

    }

    override fun writeToParcel(dest: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Money> {
        override fun createFromParcel(parcel: Parcel): Money {
            return Money(parcel)
        }

        override fun newArray(size: Int): Array<Money?> {
            return arrayOfNulls(size)
        }
    }

    }
