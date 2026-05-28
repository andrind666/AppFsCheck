# =========================
# SFSCheck Proguard Rules
# =========================

# Keep JNI Native Methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep NativeLib
-keep class com.sfscheck.engine.NativeLib {
    *;
}

# Keep Fragments
-keep public class * extends androidx.fragment.app.Fragment

# Keep Activities
-keep public class * extends android.app.Activity

# Keep AppCompat
-keep class androidx.appcompat.** { *; }

# Keep Material Components
-keep class com.google.android.material.** { *; }

# Keep ViewBinding
-keep class **Binding {
    *;
}

# Keep Kotlin Metadata
-keep class kotlin.Metadata { *; }

# Keep Kotlin Coroutines
-dontwarn kotlinx.coroutines.**

# Keep JNI Bridge
-keep class com.sfscheck.** {
    native <methods>;
}

# Prevent stripping native methods
-keepclasseswithmembers class * {
    public native <methods>;
}

# Keep enums
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep Parcelable
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# Keep Serializable
-keepnames class * implements java.io.Serializable

# Keep model classes
-keep class com.sfscheck.model.** {
    *;
}

# Prevent warnings
-dontwarn javax.annotation.**
-dontwarn org.jetbrains.annotations.**
-dontwarn kotlin.**
-dontwarn sun.misc.**

# Optimization
-optimizationpasses 5

# Enable optimization
-optimizations !code/simplification/arithmetic

# Keep line numbers for crash logs
-keepattributes SourceFile,LineNumberTable

# Keep annotations
-keepattributes *Annotation*

# Remove logs in release
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}

# Keep JNI library loader
-keep class java.lang.System {
    public static void loadLibrary(java.lang.String);
}

# Keep BuildConfig
-keep class **.BuildConfig { *; }

# Keep Resources
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Avoid obfuscating JNI names
-keepclasseswithmembernames,includedescriptorclasses class * {
    native <methods>;
}
