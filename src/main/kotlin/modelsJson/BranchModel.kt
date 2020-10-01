package modelsJson

import com.google.gson.annotations.SerializedName

data class RequiredStatusChecks(
    @SerializedName("enforcement_level")
    val enforcementLevel: Boolean,
    val contexts: List<String>
)

data class Protection(
    val enabled: Boolean,
    @SerializedName("required_status_checks")
    val requiredStatusChecks: RequiredStatusChecks
)

data class Branch(
    val name: String,
    val commit: CommitData,
    val protected: Boolean,
    val protection: Protection,
    @SerializedName("protection_url")
    val protectionUrl: String
)
