package com.example.kotlininternet.network

class ApiUtils {

    companion object
    {
        private const val BASE_URL="http://books.canerture.com/"

        fun kitaplarDAOInterfaceGetir():KitapDAOInterface
        {
            return RetrofitClient.getClient(BASE_URL).create(KitapDAOInterface::class.java)

        }

    }
}