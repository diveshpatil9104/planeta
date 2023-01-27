package com.example.planeto

import android.icu.text.CaseMap.Title
import android.os.Parcel
import android.os.Parcelable
import android.view.Gravity
import java.sql.RowId


data class PlanetData(
    val id:Int,
    val title:String?,
    val galaxy:String?,
    val distance:String?,
    val gravity: String?,
    val overview:String?
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(galaxy)
        parcel.writeString(distance)
        parcel.writeString(gravity)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlanetData> {
        override fun createFromParcel(parcel: Parcel): PlanetData {
            return PlanetData(parcel)
        }

        override fun newArray(size: Int): Array<PlanetData?> {
            return arrayOfNulls(size)
        }
    }

}




