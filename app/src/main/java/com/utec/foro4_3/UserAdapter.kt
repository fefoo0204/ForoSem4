package com.utec.foro4_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val users: MutableList<User> = mutableListOf()

    fun setUsers(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreUsuarioTextView: TextView = itemView.findViewById(R.id.userName)
        private val nombreCompletoTextView: TextView = itemView.findViewById(R.id.fullName)
        private val correoElectronicoTextView: TextView = itemView.findViewById(R.id.email)
        private val numeroTelefonoTextView: TextView = itemView.findViewById(R.id.phone)

        fun bind(user: User) {
            nombreUsuarioTextView.text = user.userName
            nombreCompletoTextView.text = user.fullName
            correoElectronicoTextView.text = user.email
            numeroTelefonoTextView.text = user.phone
        }
    }
}