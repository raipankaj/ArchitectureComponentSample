package sample.example.archcomponentsample

import android.support.annotation.NonNull
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.adapter_user_item.view.*
import sample.example.archcomponentsample.db.User

class UserSyncAdapter : ListAdapter<User, UserSyncAdapter.SyncUserViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SyncUserViewHolder {
        return SyncUserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_user_item, parent, false))
    }

    override fun onBindViewHolder(holder: SyncUserViewHolder, position: Int) {
        holder.apply {
            getItem(position)?.also {
                tvId.text = it.id.toString()
                tvName.text = it.name
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<User> = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(
                    @NonNull oldUser: User, @NonNull newUser: User): Boolean {
                // User properties may have changed if reloaded from the DB, but ID is fixed
                return oldUser.id == newUser.id
            }

            override fun areContentsTheSame(
                    @NonNull oldUser: User, @NonNull newUser: User): Boolean {
                // NOTE: if you use equals, your object must properly override Object#equals()
                // Incorrectly returning false here will result in too many animations.
                return oldUser.id == newUser.id && oldUser.name == newUser.name
            }
        }
    }

    inner class SyncUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.tvId
        val tvName: TextView = itemView.tvName
    }
}