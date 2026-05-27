package com.sfscheck.engine

object NativeLib {

    init {
        System.loadLibrary("sfscheck")
    }

    external fun getAuthenticityScore(): Int

    external fun getCPUInfo(): String

    external fun getTotalRAM(): Long

    external fun isRooted(): Boolean
}
