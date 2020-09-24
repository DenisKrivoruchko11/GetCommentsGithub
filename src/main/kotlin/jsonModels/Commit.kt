package jsonModels

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
    val comment_count: Int,
    val verification: Verification
)

data class CommitInfo(
    val url: String,
    val sha: String,
    val node_id: String,
    val html_url: String,
    val comments_url: String,
    val commit: Commit,
    val author: ParticipantData,
    val committer: ParticipantData,
    val parents: List<CommitData>
)


