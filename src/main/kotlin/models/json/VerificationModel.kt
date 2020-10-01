package models.json

data class VerificationModel(
    val verified: Boolean?,
    val reason: String?,
    val signature: String?,
    val payload: String?
)
