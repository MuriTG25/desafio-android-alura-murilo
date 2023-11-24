package br.com.alura.desasafio_android.aplicacao.modelo.mapper

import com.google.gson.annotations.SerializedName

data class RepositorioMapper(
    @SerializedName("name")
    val nome: String? = null,
    @SerializedName("description")
    val descricao: String? = null,
)
