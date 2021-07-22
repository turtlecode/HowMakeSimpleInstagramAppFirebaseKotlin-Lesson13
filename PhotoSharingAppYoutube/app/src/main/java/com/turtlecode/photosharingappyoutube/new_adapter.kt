package com.turtlecode.photosharingappyoutube

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_row.view.*

class new_adapter (val post_list : ArrayList<Post>) : RecyclerView.Adapter<new_adapter.PostHolder>() {
    class PostHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row,parent,false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.itemView.rec_mail.text = post_list[position].mail
        holder.itemView.rec_comment.text = post_list[position].comment
        Picasso.get().load(post_list[position].image).into(holder.itemView.rec_img)
    }

    override fun getItemCount(): Int {
        return post_list.size
    }
}