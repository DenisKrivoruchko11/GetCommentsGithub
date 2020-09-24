package utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import jsonModels.Branch
import jsonModels.CommitInfo
import models.CommitsHeap
import java.net.HttpURLConnection
import java.net.URL

private fun getBranches(): Array<Branch> {
    val url = URL("https://api.github.com/repos/JetBrains/kotlin/branches")

    return with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"

        val data = inputStream.bufferedReader().readText()

        val dataList = object : TypeToken<Array<Branch>>() {}.type
        Gson().fromJson(data, dataList)
    }
}

private fun getCommits(sha: String): Array<CommitInfo> {
    val url = URL("https://api.github.com/repos/JetBrains/kotlin/commits?per_page=100&sha=$sha")

    return with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"

        val data = inputStream.bufferedReader().readText()

        val dataList = object : TypeToken<Array<CommitInfo>>() {}.type
        Gson().fromJson(data, dataList)
    }
}

class WordsGetter {

    fun getWords(): MutableList<String> {
        val branches = getBranches()

        val commits = getCommits(branches[0].name).toMutableList()

        val heap = CommitsHeap("")

        for (i in 1..branches.lastIndex) {
            val currentCommits = getCommits(branches[i].name).toMutableList()

            currentCommits.forEach {
                if (heap.getSize() < 100 || it.commit.author.date > heap.getMinDate()) {
                    heap.extractMin()
                    heap.add(it.commit.message, it.commit.author.date)
                }
            }
        }

        val result = mutableListOf<String>()
        commits.forEach { result.add(it.commit.message) }

        return result
    }
}
