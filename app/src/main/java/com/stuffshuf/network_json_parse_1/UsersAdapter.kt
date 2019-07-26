package com.stuffshuf.network_json_parse_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.users_list.view.*

class UsersAdapter(val user:ArrayList<Users>):RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view=li.inflate(R.layout.users_list, parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val userdata=user[position]
        holder.bind(userdata)
    }


    class UsersViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(users: Users)
        {
            with(itemView)
            {
                tvid.text=users.id.toString()
                tvname.text=users.name
                tvusername.text=users.username
                tvemail.text=users.email
                 tvstreet.text=users.address.toString()
                // tvPhone.text=users.phone
                // tvweb.text=users.website
                 //tvcname.text=users.company.toString()
                  //tvcity.text=users.street.toString()
               //  tvead.text=users.suite.toString()

            }
        }

    }
}