package ir.saharapps.rxjavamvvmkotlin.network

object APIData {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val getAPIServices: APIServices
    get() = RetrofitClient.getRetrofitClient(BASE_URL).create(APIServices::class.java)
}