package org.example

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse


fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()

    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val meuJogo = Jogo()
    meuJogo.titulo = "Batman: Arkham Asylum Game of the Year Edition"
    meuJogo.capa = "https:\\/\\/shared.fastly.steamstatic.com\\/store_item_assets\\/steam\\/apps\\/35140\\/capsule_sm_120.jpg?t=1739318487"

    println(meuJogo.toString())
}
