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
import org.w3c.dom.Text

class PostItemAdapter(var context: Context, var postList: MutableList<PostModel>) :
    RecyclerView.Adapter<PostItemAdapter.PostItemHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemHolder {
        Log.d("TAG", "onCreateViewHolder: 11111111111 " + getItemCount())
        var view : View = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return PostItemHolder(view)
    }

    override fun onBindViewHolder(holder: PostItemHolder, position: Int) {
        holder.txtTitle.text = postList[position].title.toString()
        holder.txtBody.text = StringBuilder(postList[position].body!!.substring(0,20)).append("...").toString()
        holder.txtUserId.text = postList[position].userId.toString()
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class PostItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var txtTitle: TextView
            var txtBody: TextView
            var txtUserId: TextView

            init {
                txtTitle = itemView.findViewById(R.id.txt_postItem_Title)
                txtBody = itemView.findViewById(R.id.txt_postItem_body)
                txtUserId = itemView.findViewById(R.id.txt_postItem_userID)
            }
        }

}