package jsonModels

data class RequiredStatusChecks(
    val enforcement_level: Boolean,
    val contexts: List<String>
)

data class Protection(
    val enabled: Boolean,
    val required_status_checks: RequiredStatusChecks
)

data class Branch(
    val name: String,
    val commit: CommitData,
    val protected: Boolean,
    val protection: Protection,
    val protection_url: String
)