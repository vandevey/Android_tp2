package fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.databinding.NeighborItemBinding
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.fragments.CRUD
import fr.gobelins.edu.vandevelde.tp02_yoan_vandevelde.models.Neighbor

class ListNeighborsAdapter(items: MutableList<Neighbor>, eventHandler: CRUD<Neighbor>) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {
    private val mNeighbours: MutableList<Neighbor> = items
    private val eventHandler: CRUD<Neighbor> = eventHandler

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: NeighborItemBinding = NeighborItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbour: Neighbor = mNeighbours[position]
        // Display Neighbour Name
        holder.binding.itemListName.text = neighbour.name
        val context = holder.binding.root.context

        Glide.with(context)
            .load(neighbour.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_person)
            .error(R.drawable.ic_person)
            .skipMemoryCache(false)
            .into(holder.binding.itemListAvatar)

        holder.binding.itemListDeleteButton.setOnClickListener(View.OnClickListener {
            eventHandler.onDeleteNeibor(mNeighbours[position])
            notifyDataSetChanged()
        })
    }

    override fun getItemCount(): Int {
        return mNeighbours.size
    }

    class ViewHolder(val binding: NeighborItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}