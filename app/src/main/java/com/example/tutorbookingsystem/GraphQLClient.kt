package com.example.tutorbookingsystem

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient

object GraphQLClient {
    private val okHttpClient = OkHttpClient.Builder().build()
    val apolloClient = ApolloClient.Builder()
        .serverUrl("https://graphql.tutorbooking.com/")
        .okHttpClient(okHttpClient)
        .build()
}
