package ir.saharapps.rxjavamvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import ir.saharapps.rxjavamvvmkotlin.viewmodel.ApplicationViewModel

class MainActivity : AppCompatActivity() {

    var applicationViewModel: ApplicationViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        applicationViewModel = ViewModelProvider(this)[ApplicationViewModel::class.java]
        applicationViewModel!!.getPostList.observe(this) { postModles ->
            Log.d("MainActivity", "onCreate: PostList: " + postModles[0].userId)
        }
    }
}