package ir.saharapps.rxjavamvvmkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.saharapps.rxjavamvvmkotlin.R
import ir.saharapps.rxjavamvvmkotlin.adapter.PostItemAdapter
import ir.saharapps.rxjavamvvmkotlin.viewmodel.ApplicationViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //design and implemented by Sahar Asadian

    var applicationViewModel: ApplicationViewModel? = null

    var adapter: PostItemAdapter? = null
    var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        rv_MainActivity_RecyclerView!!.layoutManager = LinearLayoutManager(this)

        applicationViewModel = ViewModelProvider(this)[ApplicationViewModel::class.java]
        applicationViewModel!!.getPostList.observe(this) { postModles ->
            adapter = PostItemAdapter(this, postModles)
            adapter!!.notifyDataSetChanged()
            rv_MainActivity_RecyclerView!!.adapter = adapter
            progressBar!!.visibility = View.GONE
        }
    }
}

//design and implemented by Sahar Asadian