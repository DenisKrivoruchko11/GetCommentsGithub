package jsonModels

data class verificationModel(
    val verified: Boolean?,
    val reason: String?,
    val signature: String?,
    val payload: String?
)
