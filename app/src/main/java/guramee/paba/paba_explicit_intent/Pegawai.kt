package guramee.paba.paba_explicit_intent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pegawai(
    val NIP : Int,
    val Nama : String?,
    val Dept : String?
) : Parcelable
