package com.example.e_commerce.models

import android.os.Parcel
import android.os.Parcelable

data class ProductCategory(
  val category: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductCategory> {
        override fun createFromParcel(parcel: Parcel): ProductCategory {
            return ProductCategory(parcel)
        }

        override fun newArray(size: Int): Array<ProductCategory?> {
            return arrayOfNulls(size)
        }
    }
}