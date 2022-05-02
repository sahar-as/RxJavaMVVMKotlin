package ir.saharapps.rxjavamvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.saharapps.rxjavamvvmkotlin.adapter.PostItemAdapter
import ir.saharapps.rxjavamvvmkotlin.viewmodel.ApplicationViewModel

class MainActivity : AppCompatActivity() {

    var applicationViewModel: ApplicationViewModel? = null

    var adapter: PostItemAdapter? = null
    var recyclerView: RecyclerView? = null
    var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.rv_MainActivity_RecyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        applicationViewModel = ViewModelProvider(this)[ApplicationViewModel::class.java]
        applicationViewModel!!.getPostList.observe(this) { postModles ->
            Log.d("MainActivity", "onCreate: 222222222222222222: " + postModles.size)
            adapter = PostItemAdapter(this, postModles)
            adapter!!.notifyDataSetChanged()
            recyclerView!!.adapter = adapter
            progressBar!!.visibility = View.GONE
        }
    }
}