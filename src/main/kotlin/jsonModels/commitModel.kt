package jsonModels

import com.google.gson.annotations.SerializedName

data class CommitData(
    val url: String,
    val sha: String
)

data class Commit(
    val url: String,
    val author: Participant,
    val committer: Participant,
    val message: String,
    val tree: CommitData,
    @SerializedName("comment_count")
    val commentCount: Int,
    val verification: verificationModel
)

data class CommitInfo(
    val url: String,
    val sha: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("comments_url")
    val commentsUrl: String,
    val commit: Commit,
    val author: ParticipantData,
    val committer: ParticipantData,
    val parents: List<CommitData>
)
