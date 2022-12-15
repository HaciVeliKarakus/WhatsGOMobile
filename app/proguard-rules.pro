# Add project specific ProGuard rules here.

##################### kotlinx.serialization #####################
# https://github.com/Kotlin/kotlinx.serialization#android

-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt # core serialization annotations

# kotlinx-serialization-json specific. Add this if you have java.lang.NoClassDefFoundError kotlinx.serialization.json.JsonObjectSerializer
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

# Change here com.yourcompany.yourpackage
-keep,includedescriptorclasses class io.bordo.**$$serializer { *; }
-keepclassmembers class io.bordo.** {
    *** Companion;
}
-keepclasseswithmembers class io.bordo.** {
    kotlinx.serialization.KSerializer serializer(...);
}
##################### kotlinx.serialization #####################
# Ktor (to avoid 'java.lang.ClassCastException: java.lang.Class cannot be cast to java.lang.reflect.ParameterizedType')
-keep class io.ktor.** { *; }
