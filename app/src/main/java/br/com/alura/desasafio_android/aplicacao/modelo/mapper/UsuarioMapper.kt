package br.com.alura.desasafio_android.aplicacao.modelo.mapper

import com.google.gson.annotations.SerializedName

data class UsuarioMapper(
    @SerializedName("avatar_url")
    val url:String? = null,
    @SerializedName("name")
    val nome: String? = null,
    @SerializedName("login")
    val usuario: String? = null,
    @SerializedName("bio")
    val descricao: String? = null
)
