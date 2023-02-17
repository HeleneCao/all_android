package fr.ch.routardapp

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.ch.routardapp.network.Pays
import fr.ch.routardapp.ui.PaysApiStatus
import fr.ch.routardapp.ui.PaysListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Pays>?) {
    val adapter = recyclerView.adapter as PaysListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: PaysApiStatus?) {
    when(status) {
        PaysApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
        }
        PaysApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        PaysApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE

        }
    }
}
