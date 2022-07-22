package com.weather.app.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class UserModel(
    @SerialName("node_id")
    val nodeID: String? = null,

    @SerialName("avatar_url")
    val avatarURL: String? = null,

    @SerialName("gravatar_id")
    val gravatarID: String? = null,

    @SerialName("url")
    val url: String? = null,

    @SerialName("html_url")
    val htmlURL: String? = null,

    @SerialName("followers_url")
    val followersURL: String? = null,

    @SerialName("following_url")
    val followingURL: String? = null,

    @SerialName("gists_url")
    val gistsURL: String? = null,

    @SerialName("starred_url")
    val starredURL: String? = null,

    @SerialName("subscriptions_url")
    val subscriptionsURL: String? = null,

    @SerialName("organizations_url")
    val organizationsURL: String? = null,

    @SerialName("repos_url")
    val reposURL: String? = null,

    @SerialName("events_url")
    val eventsURL: String? = null,

    @SerialName("received_events_url")
    val receivedEventsURL: String? = null,


    @SerialName("site_admin")
    val siteAdmin: Boolean? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("company")
    val company: String? = null,

    @SerialName("blog")
    val blog: String? = null,

    @SerialName("location")
    val location: String? = null,

    @SerialName("twitter_username")
    val twitterUsername: JsonObject? = null,

    @SerialName("public_repos")
    val publicRepos: Long? = null,

    @SerialName("public_gists")
    val publicGists: Long? = null,

    @SerialName("created_at")
    val createdAt: String? = null,

    @SerialName("updated_at")
    val updatedAt: String? = null
)

