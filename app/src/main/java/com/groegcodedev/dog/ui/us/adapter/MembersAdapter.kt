package com.groegcodedev.dog.ui.us.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.groegcodedev.dog.R

class MembersAdapter(
    private val membersList: ArrayList<Member> // Lista de miembros a mostrar en el RecyclerView
) : RecyclerView.Adapter<MembersAdapter.MembersViewHolder>() {

    // Modelo de datos para los miembros
    data class Member(val memberImage: Int)

    // ViewHolder para los elementos de miembro
    class MembersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Vista de imagen del miembro
        val memberImageView: ImageView = itemView.findViewById(R.id.imageView_groupMember)
    }

    // Método para inflar el diseño del elemento y crear un ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_group_members, parent, false)
        return MembersViewHolder(view)
    }

    // Método para obtener el número total de elementos en el RecyclerView
    override fun getItemCount(): Int {
        return membersList.size
    }

    // Método para enlazar los datos de un miembro con su ViewHolder
    override fun onBindViewHolder(holder: MembersViewHolder, position: Int) {
        val member = membersList[position]
        holder.memberImageView.setImageResource(member.memberImage)
    }
}
