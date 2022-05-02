package ir.saharapps.rxjavamvvmkotlin.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.saharapps.rxjavamvvmkotlin.R
import ir.saharapps.rxjavamvvmkotlin.model.PostModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.post_item.*

//design and implemented by Sahar Asadian

class PostItemAdapter(var context: Context, var postList: MutableList<PostModel>) :
    RecyclerView.Adapter<PostItemAdapter.PostItemHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemHolder {
        Log.d("TAG", "onCreateViewHolder: 11111111111 " + getItemCount())
        var view : View = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return PostItemHolder(view)
    }

    override fun onBindViewHolder(holder: PostItemHolder, position: Int) {
        holder.txt_postItem_Title.text = postList[position].title.toString()
        holder.txt_postItem_body.text = StringBuilder(postList[position].body!!.substring(0,20)).append("...").toString()
        holder.txt_postItem_userID.text = postList[position].userId.toString()
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    //add experimental = ture in gradle now you can use this extension to remove findViewById
    inner class PostItemHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer

}