package utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import jsonModels.Branch
import jsonModels.CommitInfo
import models.Heap
import models.HeapItem
import java.net.HttpURLConnection
import java.net.URL
import java.util.Date

private fun <T> getData(url: URL): List<T> {
    return with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"

        val data = inputStream.bufferedReader()

        val type = object : TypeToken<List<T>>() {}.type
        Gson().fromJson(data, type)
    }
}

private fun getBranches(url: URL): List<Branch> {
    return with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"

        val data = inputStream.bufferedReader()

        val type = object : TypeToken<List<Branch>>() {}.type
        Gson().fromJson(data, type)
    }
}

private fun getCommits(url: URL): List<CommitInfo> {
    return with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"

        val data = inputStream.bufferedReader()

        val type = object : TypeToken<List<CommitInfo>>() {}.type
        Gson().fromJson(data, type)
    }
}

class WordsGetter(private val baseUrl: String) {

    fun getCommitsData(commitsQuantity: Int): List<String> {
        val heap = Heap<Date, String>(commitsQuantity)

        val branches = getBranches(URL("${baseUrl}branches"))
        branches.forEach {
            val commits = getCommits(URL("${baseUrl}commits?per_page=$commitsQuantity&sha=${it.name}"))

            commits.forEach { commit -> heap.tryToAdd(HeapItem(commit.commit.author.date, commit.commit.message)) }
        }

        val result = mutableListOf<String>()
        heap.forEach { result.add(it.value) }
        return result
    }
}
