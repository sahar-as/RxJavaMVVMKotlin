package ir.saharapps.rxjavamvvmkotlin.repository

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ir.saharapps.rxjavamvvmkotlin.model.PostModel
import ir.saharapps.rxjavamvvmkotlin.network.APIData
import ir.saharapps.rxjavamvvmkotlin.network.APIServices

class MainRepository {
    private val apiService: APIServices = APIData.getAPIServices
    private val compositeDisposable = CompositeDisposable()

    val getPostModelLiveData: MutableLiveData<MutableList<PostModel>>
        get() {
            val data: MutableLiveData<MutableList<PostModel>> = MutableLiveData<MutableList<PostModel>>()
            compositeDisposable.add(apiService.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{postModels ->
                    if(postModels != null){
                        data.value = postModels
                    }
                })
            return data
        }
}