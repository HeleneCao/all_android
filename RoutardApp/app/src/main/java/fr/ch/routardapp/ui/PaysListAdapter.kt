package fr.ch.routardapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import fr.ch.routardapp.network.Pays


class PaysListAdapter (val clickListener: PaysListener) :
    ListAdapter<Pays, PaysListAdapter.PaysViewHolder>(DiffCallBack){

        class PaysViewHolder(
            var binding : ListViewItemBinding
        ) : RecyclerView.ViewHolder(binding.root){
            fun bind(clickListener: PaysListener, pays : Pays){
                binding.pays = pays
                binding.clickListener = clickListener
                binding.executePendingBindings()

            }
        }

    companion object DiffCallback : DiffUtil.ItemCallback<Pays>() {
        override fun areItemsTheSame(oldItem: Pays, newItem: Pays): Boolean {
            return oldItem.idPays == newItem.idPays
    }

        override fun areContentsTheSame(oldItem: Pays, newItem: Pays): Boolean {
            return oldItem.codePays == newItem.codePays
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaysViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PaysViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PaysViewHolder, position: Int) {
        val pays = getItem(position)
        holder.bind(clickListener, pays)
    }
}

class PaysListener(val clickListener: (pays: Pays) -> Unit) {
    fun onClick(pays: Pays) = clickListener(pays)
}
