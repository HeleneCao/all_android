package fr.ch.routardapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import fr.ch.routardapp.R

class PaysListFragment : Fragment() {

    private val viewModel: PaysViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.getPaysList()
        val binding = FragmentPaysListBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = PaysListAdapter(PaysListener { pays -> viewModel.onPaysClicked(pays)
        findNavController().navigate(R.id.action_paysListFragment_to_paysDetailFragment)
        })

        return bindind.root

    }
}