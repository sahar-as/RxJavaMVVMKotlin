package ir.saharapps.rxjavamvvmkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ir.saharapps.rxjavamvvmkotlin.model.PostModel
import ir.saharapps.rxjavamvvmkotlin.repository.MainRepository

class ApplicationViewModel : ViewModel() {
    private val mainRepository : MainRepository = MainRepository()

    val getPostList:LiveData<MutableList<PostModel>>
    get() = mainRepository.getPostModelLiveData
}